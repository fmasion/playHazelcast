import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playHazelcastClient"
  val appVersion      = "0.2.0"

  val appDependencies = Seq(
    // Add your project dependencies here,
    //"com.hazelcast" % "hazelcast" % "2.5.1",
    "com.hazelcast" % "hazelcast-client" % "2.6.3"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
