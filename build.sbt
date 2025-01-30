inThisBuild(
  List(
    scalaVersion := "3.6.3",
    organization := "africa.shuwari.laminae",
    description := "Laminae collection for easier construction of Laminar applications.",
    homepage := Some(url("https://github.com/shuwarifrica/sbt-js")),
    scmInfo := ScmInfo(
      url("https://github.com/shuwariafrica/laminae"),
      "scm:git:https://github.com/shuwariafrica/laminae.git",
      Some("scm:git:git@github.com:shuwariafrica/laminae.git")
    ).some,
    startYear := Some(2024),
    semanticdbEnabled := true
  )
)

lazy val `laminae-root` =
  project
    .in(file("."))
    .shuwariProject
    .apacheLicensed
    .notPublished
    .settings(Publishing.aggregate)
    .aggregate(`laminae-core`, `laminae-ix`)

lazy val `laminae-core` =
  project
    .in(file("modules/core"))
    .settings(Publishing.project)
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(libraries.laminar)
    .settings(
      ScalaCompiler.basePackages ++= List("laminae")
    )

lazy val `laminae-ix` =
  project
    .in(file("modules/ix"))
    .settings(Publishing.project)
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(libraries.laminar)
    .dependsOn(`laminae-core`)
    .settings(
      ScalaCompiler.basePackages ++= List("laminae.components.ix")
    )

lazy val `laminae-documentation` =
  project
    .in(file(".sbt-shuwari-doc"))
    .enablePlugins(MdocPlugin)
    .settings(
      mdocIn := (LocalRootProject / baseDirectory).value / "modules" / "documentation",
      mdocOut := (LocalRootProject / baseDirectory).value,
      mdocVariables := Map(
        "VERSION" -> version.value,
        "LAMINAR_VERSION" -> libraries.laminar.value.revision
      )
    )

lazy val libraries = new {
  val laminar = Def.setting("com.raquo" %%% "laminar" % "17.2.0")
}
