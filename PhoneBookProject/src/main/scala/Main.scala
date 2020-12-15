import ActorMessages.{CreateUserApiActor, GetUsersApiActor}
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
    val apiService:ApiService=new ApiService
    apiService.runServer()
  }
}
