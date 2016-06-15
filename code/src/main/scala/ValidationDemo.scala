import scalaz._
import Scalaz._

object ValidationDemo {
  case class Telemetry(a: Int, b: Double)

  def f(x: String) =
    x.parseInt.toValidationNel

  def g(x: String): ValidationNel[NumberFormatException, Double] =
    x.parseDouble.toValidationNel    

  def run(): Unit = {
    // applicative builder
    pprint.pprintln((f("2") |@| g("3"))(Telemetry.apply))
    pprint.pprintln((f("2") |@| g("x"))(Telemetry.apply))
  }
}
