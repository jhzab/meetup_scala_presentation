name := "scala_meetup_presentation"

scalaVersion := "2.11.8"

version := "0.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",       // yes, this is 2 args
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-unchecked",
  "-Xfatal-warnings",
  "-Xlint",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",        // N.B. doesn't work well with the ??? hole
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard",
  "-Xfuture"
  // very annoying in the REPL
  //"-Ywarn-unused-import"     // 2.11 only
)

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.4",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.4",
  "com.lihaoyi" %% "pprint" % "0.4.1",
  "com.lihaoyi" %% "fastparse" % "0.3.7",
  "com.typesafe.akka" %% "akka-actor" % "2.4.7"
)
