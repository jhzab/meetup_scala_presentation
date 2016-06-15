import akka.actor.Actor
import akka.actor.ActorLogging
import akka.actor.ActorSystem
import akka.actor.Props

final case object Ball

sealed trait Ball
final case class SmallBall()
final case class BigBall(t: String)

final class Ping extends Actor with ActorLogging {
  var cnt = 0
  def receive = {
    case Ball =>
      cnt += 1
      sender() ! BigBall("PING")
      Thread.sleep(1000)
      println(s"Count: $cnt")
    case _ => log.error("Received something weird, go away!")
  }
}

final class Pong extends Actor with ActorLogging {
  var cnt = 0
  def receive = {
    case SmallBall => sender() ! SmallBall()
    case BigBall(t) =>
      cnt += 1
      sender().tell(Ball, self)
      Thread.sleep(1000)
      log.info(s"Very informative message: $t")
    case _ => log.error("Received something weird, go away!")
  }
}

object PingPong {
  def runPingPongDemo(): Unit = {
    val actorSystem = ActorSystem("PingPong")
    val ping = actorSystem.actorOf(Props[Ping], "ping")
    val pong = actorSystem.actorOf(Props[Pong], "pong")

    pong.tell(Ball, ping)
  }
}
