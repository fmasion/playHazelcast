import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "playHazelcast"
  val appVersion      = "0.1"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "com.hazelcast" % "hazelcast" % "2.5.1",
    "com.hazelcast" % "hazelcast-cloud" % "2.5.1"
  )


  //val main = play.Project(appName, appVersion, appDependencies).settings(
  val main = Project(id = "playHazelcast", base = file("."), settings = Project.defaultSettings).settings(    
    // Add your own project settings here      
  )

}
