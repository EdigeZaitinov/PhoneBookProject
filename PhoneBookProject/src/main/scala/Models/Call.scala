package Models

import scala.collection.mutable.ListBuffer

final case class Call(userId1:String,userId2:String,callTime:Int)

object CallHistory {
  var callHistory:ListBuffer[Call] = ListBuffer()
}