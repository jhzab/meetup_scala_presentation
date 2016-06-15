sealed trait Animal extends Product with Serializable
final case class Snake(name: String, poisonous: Boolean) extends Animal
final case class Dog(name: String) extends Animal

object CaseClass {
  def greet(): Unit = {
    val dog = Dog("Fluffy")
    println(dog.name)
  }

  def greetAnimal(a: Animal): Unit = a match {
    case Dog(name) => println(s"Hey ${name}")
    case Snake(name, poisonous) =>
      if (poisonous)
        println(s"Running away...!")
  }
}
