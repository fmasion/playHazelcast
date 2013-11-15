import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playHazelcast"
  val appVersion      = "0.2.0"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.hazelcast" % "hazelcast" % "2.6.3",
    "com.hazelcast" % "hazelcast-cloud" % "2.6.3"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
