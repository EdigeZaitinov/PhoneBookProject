package Actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

object APIActor {
  sealed trait APIActorMessages
  case class SimulateCall(time:Int) extends APIActorMessages
  case class CreateUser() extends APIActorMessages
  case class GetUsers(pageNumber:Int,pageSize:Int) extends APIActorMessages
  case class GetCallHistory()extends APIActorMessages

  val apiActor:Behavior[APIActorMessages]=Behaviors.setup{context=>
    Behaviors.receiveMessage{
      case SimulateCall(time)=>{
        println("simulating "+time.toString+"seconds")
        Behaviors.same
      }
      case CreateUser()=>{
        println("Creating")
        Behaviors.same
      }
      case GetUsers(pageNumber,pageSize)=>{
        println("getting"+pageNumber.toString+"-pageNumber "+pageSize.toString+"-pageSize of users")
        Behaviors.same
      }
      case GetCallHistory()=>{
        println("getting call history")
        Behaviors.same
      }
      case _=>{
        println("her ego znaet")
        Behaviors.same
      }
    }
  }

}
