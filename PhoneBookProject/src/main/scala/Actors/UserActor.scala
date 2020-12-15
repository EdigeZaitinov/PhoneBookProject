package Actors

import ActorMessages.{CallUserUserActor, CreateUserUserActor, GetUsersUserActor, SimulateCallApiActor}
import akka.actor.{Actor, Props}
import akka.pattern.ask
import akka.stream.Attributes.CancellationStrategy.PropagateFailure
import akka.util.Timeout

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class UserActor extends Actor {
  override def receive: Receive = {
    case CallUserUserActor(userID1, userID2,time) => {
      println("Calling user")
      val apiActor=context.actorOf(Props[ApiActor],"child")
      implicit val timeout = Timeout(10 seconds)
      val future = apiActor ? SimulateCallApiActor(4)
      val result = Await.result(future, timeout.duration)
      println(result)
    }
    case CreateUserUserActor(userID, name, phoneNumber) => {
      println("Creating User with name=" + name + " and number=" + phoneNumber)
    }
    case GetUsersUserActor(pageNumber, pageSize) => {

    }
  }
}

