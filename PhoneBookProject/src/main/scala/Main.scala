import ActorMessages.{CallUserUserActor, CreateUserApiActor, CreateUserUserActor, GetUsersApiActor}
import Actors.{ApiActor, UserActor}
import Services.ApiService
import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{complete, concat, get, path, pathSingleSlash}
import akka.util.Timeout

import scala.concurrent.Await
import akka.pattern.ask

import scala.concurrent.duration._
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

object Main {
  def main(args: Array[String]): Unit = {
    val apiService: ApiService = new ApiService
    apiService.runServer()
    val actorSystem = ActorSystem("System")
    val userActor = actorSystem.actorOf(Props[UserActor](), "UserActor")
    val userActor2 = actorSystem.actorOf(Props[UserActor](), "Useractor1")
    userActor ! CallUserUserActor("1", "2", 9)
    userActor2 ! CallUserUserActor("2", "3", 6)
    userActor ! CreateUserUserActor("11", "Rasul", "9696969696")
  }
}
