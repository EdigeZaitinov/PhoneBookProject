package Actors

import ActorMessages.{CallUserUserActor, CreateUserApiActor, CreateUserUserActor, GetUsersUserActor, SaveCall, SimulateCallApiActor}
import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class UserActor extends Actor {
  override def receive: Receive = {
    case CallUserUserActor(userID1, userID2,time) => {
      println("Calling user")
      val apiActor=context.actorOf(Props[ApiActor],"child")
      implicit val timeout = Timeout(10 seconds)
      val future = apiActor ? SimulateCallApiActor(time)
      apiActor!SaveCall(userID1,userID2,time)
      val result = Await.result(future, timeout.duration)
      println(result)
    }
    case CreateUserUserActor(userID, name, phoneNumber) => {
      val apiActor=context.actorOf(Props[ApiActor],"child1")
      apiActor!CreateUserApiActor(userID,name, phoneNumber)
    }
    case GetUsersUserActor(pageNumber, pageSize) => {

    }
  }
}

