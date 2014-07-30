name := "playHazelcast-parent"

version := Common.version

lazy val playHazelcast = project.in(file("playHazelcast")).settings(Common.settings: _*)

lazy val playHazelcastClient = project.in(file("playHazelcastClient")).settings(Common.settings: _*)

lazy val playHazelcastScalaSample = project.in(file("sample/sample-playHazelcast-scala")).settings(Common.settings: _*)
    .dependsOn(playHazelcast, playHazelcastClient)


libraryDependencies ++= Seq()

Common.settings

lazy val playHazelcastParent = project.in(file("."))
    .aggregate(playHazelcast, playHazelcastClient)

