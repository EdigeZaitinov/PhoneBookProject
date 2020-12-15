package ActorMessages

sealed trait ApiActorMessages
case class SimulateCallApiActor(time: Int) extends ApiActorMessages

case class CreateUserApiActor(userID:String,name: String, phoneNumber: String) extends ApiActorMessages

case class GetUsersApiActor() extends ApiActorMessages

case class GetCallHistoryApiActor() extends ApiActorMessages

case class SaveCall(userId1:String,userId2:String,time:Int)extends ApiActorMessages