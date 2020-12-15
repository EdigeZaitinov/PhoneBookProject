package ActorMessages

sealed trait UserActorMessages

case class CallUserUserActor(userID1:String,userID2:String,time:Int) extends UserActorMessages
case class GetUsersUserActor(pageNumber:Int,pageSize:Int) extends UserActorMessages
case class CreateUserUserActor(userID:String,name:String,phoneNumber:String) extends UserActorMessages
