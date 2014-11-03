name := "playHazelcast-parent"

version := Common.version

lazy val playHazelcast = project.in(file("playHazelcast")).settings(Common.settings: _*).enablePlugins(PlayScala)

lazy val playHazelcastClient = project.in(file("playHazelcastClient")).settings(Common.settings: _*).enablePlugins(PlayScala)

lazy val playHazelcastScalaSample = project.in(file("sample/sample-playHazelcast-scala")).settings(Common.settings: _*)
    .dependsOn(playHazelcast, playHazelcastClient).enablePlugins(PlayScala)

libraryDependencies ++= Seq()

Common.settings

lazy val playHazelcastParent = project.in(file(".")).aggregate(playHazelcast, playHazelcastClient)

