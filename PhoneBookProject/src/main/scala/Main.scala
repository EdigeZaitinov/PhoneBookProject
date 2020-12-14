import Actors.APIActor
import Actors.APIActor.GetUsers
import akka.actor.typed.ActorSystem

object Main {
  def main(args: Array[String]): Unit = {
    val apiActorSystem=ActorSystem(APIActor.apiActor,"apiActorSystem")
    apiActorSystem!GetUsers(1,20)
    apiActorSystem!GetUsers(2,20)
  }
}
