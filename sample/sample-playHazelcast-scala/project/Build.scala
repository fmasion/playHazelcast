import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sample-playHazelcast-scala"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    "playhazelcast"  % "playhazelcast_2.10" % "3.2.1",
    "playhazelcastclient"  % "playhazelcastclient_2.10" % "3.2.1"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
    resolvers += Resolver.sonatypeRepo("snapshots"),
    resolvers += Resolver.sonatypeRepo("releases"),
    resolvers += Resolver.file("Local repo", file(System.getProperty("user.home") + "/.ivy2/local"))(Resolver.ivyStylePatterns)
  )

 val resolutionRepos = Seq(
    "spray repo" at "http://repo.spray.io/",
    "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
    // "Local Maven Repository" at Path.userHome.asFile.toURI.toURL + ".m2/repository",
    "twitter Repository" at "http://maven.twttr.com", // why am I using this ?
    "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"
  )
}
