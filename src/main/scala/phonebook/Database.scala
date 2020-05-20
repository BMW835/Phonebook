package phonebook

import scala.slick.driver.PostgresDriver.simple._
import scala.util.{Failure, Success, Try}

case class Phone(
                  id: Int,
                  name: String,
                  phone: String)

class Phonebook(tag: Tag) extends Table[(Int, String, String)](tag, "phonebook") {
  def id: Column[Int] = column[Int]("id")
  def name: Column[String] = column[String]("name")
  def phone: Column[String] = column[String]("phone")
  def * = (id, name, phone)
}

trait Database {
  def add(name: String, phone: String): Unit = {
    val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]

        Try(phones.map(c => (c.name, c.phone)) += (name, phone)) match {
          case Success(_) => println(name + " " + phone + " added!")
          case Failure(_) => println("An error occurred!")
        }
    }
  }

  def all(): Unit = {
    val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]

        phones.list foreach { row =>
          println("id " + row._1 + " username " + row._2 + " phone " + row._3)
        }
    }
  }

  def mod(id: Int, name: String, phone: String): Unit = {
    val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]

        Try(phones
          .filter(_.id === id)
          .map(c => (c.name, c.phone))
          .update((name, phone))) match {
          case Success(_) => println("Record successfully updated!")
          case Failure(_) => println("An error occurred!")
        }
    }
  }

  def del(id: Int): Unit = {
    val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]

        Try(phones
          .filter(_.id === id)
          .delete) match {
          case Success(_) => println("Record successfully updated!")
          case Failure(_) => println("An error occurred!")
        }
    }
  }

  def clear(): Unit = {
    val connectionUrl = "jdbc:postgresql://balarama.db.elephantsql.com:5432/isbgmvfg?user=isbgmvfg&password=PyjJxgZt_Gxirm6Z7hDAUOonsZiywZoM"
    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val phones = TableQuery[Phonebook]

        Try(phones.delete) match {
          case Success(_) => println("Database cleared!")
          case Failure(_) => println("Database not cleared!")
        }
    }
  }

}

object DB extends Database