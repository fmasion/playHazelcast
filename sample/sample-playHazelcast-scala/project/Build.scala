import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sample-playHazelcast-scala"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "playhazelcast"  % "playhazelcast_2.10" % "2.6.7",
    "playhazelcastclient"  % "playhazelcastclient_2.10" % "2.6.7"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    resolvers += Resolver.url("Fred's GitHub Play Repository", url("http://fmasion.github.com/releases/"))(Resolver.ivyStylePatterns)
  )

}
