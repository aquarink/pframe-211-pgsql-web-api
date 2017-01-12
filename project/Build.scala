import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "belajar-web"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
		javaCore,
		javaJdbc,
		javaEbean,
        //"com.jolbox" % "bonecp" % "0.8.0-rc3",
		// Add your project dependencies here,
		"be.objectify" %% "deadbolt-java" % "2.1.2",
		"postgresql" % "postgresql" % "9.1-901.jdbc4"
    )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
