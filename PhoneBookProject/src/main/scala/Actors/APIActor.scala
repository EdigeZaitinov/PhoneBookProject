package Actors

import ActorMessages.{CreateUserApiActor, GetCallHistoryApiActor, GetUsersApiActor, SaveCall, SimulateCallApiActor}
import Models.{Call, CallHistory, User, UserDB}
import akka.actor.AbstractActor.Receive
import akka.actor.{Actor, ActorRef, ActorSystem}
import io.circe.Encoder.AsObject.importedAsObjectEncoder
import io.circe.generic.auto.exportEncoder
import io.circe.syntax.EncoderOps


class ApiActor extends Actor {

  override def receive: Receive = {
    case SimulateCallApiActor(time) => {
      println("simulating " + time.toString + "seconds")
      Thread.sleep(time * 1000)
      sender() ! "Call ended"
    }
    case CreateUserApiActor(userID, name, phoneNumber) => {
      println("Creating User with name=" + name + " and number=" + phoneNumber)
      UserDB.users += User(userID, name, phoneNumber)
    }
    case GetUsersApiActor() => {
      println("getting users")
      val users = UserDB.users.toList
      val json = users.asJson
      sender() ! json
    }
    case GetCallHistoryApiActor() => {
      println("getting call history")
      val callHistory = CallHistory.callHistory.toList
      val json = callHistory.asJson
      sender() ! json
    }
    case SaveCall(userId1,userId2,time) => {
      println("Saving Call")
      CallHistory.callHistory+=Call(userId1,userId2,time)
    }
    case _ => {
      println("ошибка звонка")
    }
  }
}

