object Run {
  def main(args: Array[String]): Unit = {
    CaseClass.greet()
    CaseClass.greetAnimal(Dog("Fluffy"))
    ValidationDemo.run
    EqualDemo.run
    //PingPong.runPingPongDemo()
  }
}
