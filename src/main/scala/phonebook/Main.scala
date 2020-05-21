package phonebook

import scala.slick.driver.PostgresDriver.simple._
import scala.util.{Failure, Success, Try}

object Main extends App {
/*
  case class Phone(
                   id: Int,
                   name: String,
                   phone: String)

  class Phonebook(tag: Tag) extends Table[(Int, String, String)](tag, "phonebook") {
    def id = column[Int]("id")
    def name = column[String]("name")
    def phone = column[String]("phone")
    def * = (id, name, phone)
  }
*/
  override def main(args: Array[String]): Unit = {
    /*val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"

    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]
*/
        /*Try( phones.filter(_.id === 2).map(c => (c.name, c.phone)).update(("Matty", "001")) ) match{
          case Success(_) => println("Record successfully updated!")
          case Failure(_) => println("An error occurred!")
        }*/


        /*Try( phones.map(c => (c.name, c.phone)) += ("Deff", "004") ) match {
          case Success(_) => println("Success!")
          case Failure(_) => println("An error occurred!")
        }*/

        /*phones.filter(_.name like "%m2%") foreach { row =>
          println("id " + row._1 + " username " + row._2 + " phone " + row._3)
        }*/

    //}

    //DB.clear()
    //DB.add("Bill", "798")
    //DB.mod(18,"Bim2", "187098")
    //DB.del(19)
    //DB.all()
    //DB.nameLike("m2")
    //DB.phoneLike("79")

    case class Todo(id: Long, name: String, isComplete: Boolean)

  }
}