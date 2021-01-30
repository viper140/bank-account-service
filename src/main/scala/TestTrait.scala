
trait HelloAble {
  def sayHello(name: String)
}

trait MakeFriends {
  def makeFriends(person: Person)
}

class Person(val name: String) extends HelloAble with MakeFriends {
  override def makeFriends(person: Person): Unit = println(s"my name is $name,your name is ${person.name}")

  override def sayHello(name: String): Unit = println(s"hello,$name")
}

object TestTrait {
  val personA: Person = new Person("JACK")
  val personB: Person = new Person("Leo")

  def main(args: Array[String]): Unit = {
    personA.sayHello("Vic")
    personA.makeFriends(personB)
  }

}
