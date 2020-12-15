package Services

import ActorMessages.{CreateUserApiActor, GetCallHistoryApiActor, GetUsersApiActor}
import Actors.{ApiActor, UserActor}
import akka.actor.{ActorSystem, Props}
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives.{as, complete, concat, entity, get, path, pathSingleSlash, post}
import akka.util.Timeout

import scala.concurrent.Await
import akka.pattern.ask

import scala.concurrent.duration._

class ApiService {

  implicit val actorSystem = ActorSystem("PhoneBookSystem")
  implicit val apiActor = actorSystem.actorOf(Props[ApiActor](), "ApiActor")
  val routes = concat(
    get {
      pathSingleSlash {
        complete(HttpEntity("Welcome to our project"))
      }
    },
    get {
      path("users") {
        implicit val timeout = Timeout(10 seconds)
        val future = apiActor ? GetUsersApiActor()
        val result = Await.result(future, timeout.duration)
        complete(HttpEntity(ContentTypes.`application/json`, result.toString()))
      }
    },
    get{
      path("callHistory"){
        implicit val timeout = Timeout(10 seconds)
        val future = apiActor ? GetCallHistoryApiActor()
        val result = Await.result(future, timeout.duration)
        complete(HttpEntity(ContentTypes.`application/json`,result.toString))
      }
    }
  )

  def runServer() {
    val bindingFuture = Http().newServerAt("localhost", 8080).bind(routes)
    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  }
}

