import scalaz._
import Scalaz._

trait EqDemo[L, R] {
 def equal(a1: L, a2: R): Boolean
}

object EqualDemo {
  val f = (a: Int, b: String) => {
    b.parseInt match {
      case Success(i) => i == a
      case Failure(_) => false
    }
  }

  implicit val intStringEq = new EqDemo[Int, String] {
    def equal(a: Int, b: String): Boolean = f(a, b)
  }

  def run() = {
    runDemoEq(5, "3")
    runScalazEq()
  }

  def runDemoEq[A,B](a: A, b: B)(implicit eq: EqDemo[A, B]): Unit = {
    println(eq.equal(a, b))
  }

  case class Test(a: Int)
  def runScalazEq(): Unit = {
    // this will not even compile
    // println("Array(1,2) == Array(\"foo\"): " + (Array(1,2) === Array("foo")))
    println("Array(1,2) == Array(\"foo\"): " + (Array(1,2) == Array("foo")))
  }
}
