package Models

import scala.collection.mutable.ListBuffer

final case class User(userID: String, name: String, phoneNumber: String)

object UserDB {
  var users = ListBuffer(User("1", "Edige", "87710567727"),
    User("2", "Nurai", "87075534422"),
    User("3", "Nursultan", "87710275567"))

  def findUserByName(name: String) = users.find(_.name == name)

  def findUserByPhoneNumber(phoneNumber: String) = users.find(_.phoneNumber == phoneNumber)

  def findUserByID(userID: String) = users.find(_.userID == userID)
}