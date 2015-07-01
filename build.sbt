name := "scala-shopping-cart"

version := "1.0"

scalaVersion := "2.11.6"

resolvers += "Sonatype OSS Groups Public" at "https://oss.sonatype.org/content/groups/public"

resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies ++= {
  Seq(
    "org.scalatest"       %%  "scalatest"     % "2.2.4" % "test",
    "org.mockito"         %   "mockito-all"   % "1.10.19" % "test"
  )
}
