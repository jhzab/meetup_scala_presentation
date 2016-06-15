import ops1._
import ops2._

object ops1 {
  class Test()
  implicit class TestOps(val str: String)  {
    def op1: String = str
  }
}

object ops2 {
  class Test()
  class TestOps(val str: String)
}


class Test {
  "foo".op1
}
