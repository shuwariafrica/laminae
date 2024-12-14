import sbt.Def

inThisBuild(
  List(
    scalaVersion := "3.6.2",
    organization := "africa.shuwari.laminae",
    description := "Laminae collection for easier construction of Laminar applications.",
    homepage := Some(url("https://github.com/shuwarifrica/sbt-js")),
    version := VersionPlugin.versionSetting.value,
    dynver := VersionPlugin.versionSetting.toTaskable.toTask.value,
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    publishCredentials,
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
    .settings(sonatypeProfileNameSetting)
    .aggregate(`laminae-core`, `laminae-ix`)

lazy val `laminae-core` =
  project
    .in(file("modules/core"))
    .settings(publishSettings)
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(libraries.laminar)
    .settings(
      shuwarijs.basePackages ++= List("laminae")
    )

lazy val `laminae-ix` =
  project
    .in(file("modules/ix"))
    .settings(publishSettings)
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(libraries.laminar)
    .dependsOn(`laminae-core`)
    .settings(
      shuwarijs.basePackages ++= List("laminae.components.ix")
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

def publishCredentials: Setting[?] = credentials := List(
  Credentials(
    "Sonatype Nexus Repository Manager",
    sonatypeCredentialHost.value,
    System.getenv("PUBLISH_USER"),
    System.getenv("PUBLISH_USER_PASSPHRASE")
  )
)

def pgpSettings: List[Setting[?]] = List(
  PgpKeys.pgpSelectPassphrase :=
    sys.props
      .get("SIGNING_KEY_PASSPHRASE")
      .map(_.toCharArray),
  usePgpKeyHex(System.getenv("SIGNING_KEY_ID"))
)

def publishSettings: List[Setting[?]] = publishCredentials +: pgpSettings ++: List(
  packageOptions += Package.ManifestAttributes(
    "Created-By" -> "Simple Build Tool",
    "Built-By" -> System.getProperty("user.name"),
    "Build-Jdk" -> System.getProperty("java.version"),
    "Specification-Title" -> name.value,
    "Specification-Version" -> version.value,
    "Specification-Vendor" -> organizationName.value,
    "Implementation-Title" -> name.value,
    "Implementation-Version" -> VersionPlugin.implementationVersionSetting.value,
    "Implementation-Vendor-Id" -> organization.value,
    "Implementation-Vendor" -> organizationName.value
  ),
  publishTo := sonatypePublishToBundle.value,
  pomIncludeRepository := (_ => false),
  publishMavenStyle := true,
  sonatypeProfileNameSetting
)

def sonatypeProfileNameSetting: Setting[String] = sonatypeProfileName := "africa.shuwari"
