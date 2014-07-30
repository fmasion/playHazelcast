import sbt.Keys._
import sbt._

object Common{
val version = "3.2.3-play2.2"	
val settings = Seq(
   Keys.version := version,
   publishTo := Some("Fred's bintray" at "https://api.bintray.com/maven/fmasion/maven/playHazelcast"),
   publishMavenStyle := true

)

}