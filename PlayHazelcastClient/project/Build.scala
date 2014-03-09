import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playHazelcastClient"
  val appVersion      = "2.6.7"

  val appDependencies = Seq(
    "com.hazelcast" % "hazelcast-client" % "2.6.7",
    "com.hazelcast" % "hazelcast-cloud" % "2.6.7"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
