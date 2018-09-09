name := "specs"

organization := "org.scala-tools.testing"

version := "1.6.11-fs1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.7" % "optional",
  "org.eclipse.mylyn.wikitext" % "wikitext" % "0.9.4.I20090220-1600-e3x" % "optional",
  "org.eclipse.mylyn.wikitext" % "wikitext.textile" % "0.9.4.I20090220-1600-e3x"% "optional",
  "org.markdownj" % "markdownj" % "0.3.0-1.0.2b4" % "optional",
  "org.scala-tools.testing" % "test-interface" % "0.5" % "optional",
  "org.easymock" % "easymock" % "2.5.1" % "optional",
  "org.easymock" % "easymockclassextension" % "2.4" % "optional",
  "org.scalacheck" % "scalacheck_2.11" % "1.14.0" % "optional",
  "org.jmock" % "jmock" % "2.5.1" % "optional",
  "org.jmock" % "jmock-legacy" % "2.5.1" % "optional",
  "org.mockito" % "mockito-all" % "1.9.5" % "optional",
  "cglib" % "cglib" % "2.1_3" % "optional",
  "org.objenesis" % "objenesis" % "1.0" % "optional",
  "org.scala-lang" % "scala-compiler" % "2.11.8" % "optional",
  "org.scala-lang.modules" % "scala-xml_2.11" % "1.0.5" % "optional")


testOptions := Seq(Tests.Filter(s => s.endsWith("Spec")))

resolvers += "Sonatype-releases" at "http://oss.sonatype.org/content/repositories/releases"
resolvers += "Sonatype-snapshots" at "http://oss.sonatype.org/content/repositories/snapshots"

/** Publishing */
credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { x => false }

pomExtra := (
  <url>http://code.google.com/p/specs/</url>
  <licenses>
    <license>
      <name>MIT-style</name>
      <url>http://www.opensource.org/licenses/mit-license.php</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>http://github.com/etorreborre/specs</url>
    <connection>scm:http:http://etorreborre@github.com/etorreborre/specs.git</connection>
  </scm>
  <developers>
    <developer>
      <id>etorreborre</id>
      <name>Eric Torreborre</name>
      <url>http://etorreborre.blogspot.com/</url>
      </developer>
    </developers>
)
