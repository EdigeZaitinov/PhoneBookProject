package ActorMessages

sealed trait ApiActorMessages
case class SimulateCallApiActor(time: Int) extends ApiActorMessages

case class CreateUserApiActor(userID:String,name: String, phoneNumber: String) extends ApiActorMessages

case class GetUsersApiActor(pageNumber: Int, pageSize: Int) extends ApiActorMessages

case class GetCallHistoryApiActor() extends ApiActorMessages