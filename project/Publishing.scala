import com.jsuereth.sbtpgp.SbtPgp
import com.jsuereth.sbtpgp.SbtPgp.autoImport.{PgpKeys, usePgpKeyHex}
import xerial.sbt.Sonatype
import xerial.sbt.Sonatype.autoImport.{sonatypeCredentialHost, sonatypeProfileName, sonatypePublishToBundle}

import sbt.Keys.*
import sbt.*

object Publishing extends AutoPlugin {

  def aggregate: Setting[String] = sonatypeProfileNameSetting

  def project: Seq[Setting[?]] = publishSettings

  override def buildSettings: List[Def.Setting[?]] = List(
    sonatypeCredentialHost := "s01.oss.sonatype.org",
    publishCredentials
  )

  override def requires = SbtPgp && Sonatype && VersionPlugin

  override def trigger = allRequirements

  private def publishCredentials: Setting[?] = credentials := List(
    Credentials(
      "Sonatype Nexus Repository Manager",
      sonatypeCredentialHost.value,
      System.getenv("PUBLISH_USER"),
      System.getenv("PUBLISH_USER_PASSPHRASE")
    )
  )

  private def pgpSettings: List[Setting[?]] = List(
    PgpKeys.pgpSelectPassphrase :=
      sys.props
        .get("SIGNING_KEY_PASSPHRASE")
        .map(_.toCharArray),
    usePgpKeyHex(System.getenv("SIGNING_KEY_ID"))
  )

  private def publishSettings: List[Setting[?]] = publishCredentials +: pgpSettings ++: List(
    packageOptions += Package.ManifestAttributes(
      "Created-By" -> "Simple Build Tool",
      "Built-By" -> System.getProperty("user.name"),
      "Build-Jdk" -> System.getProperty("java.version"),
      "Specification-Title" -> name.value,
      "Specification-Version" -> version.value,
      "Specification-Vendor" -> organizationName.value,
      "Implementation-Title" -> name.value,
      "Implementation-Version" -> VersionPlugin.autoImport.implementationVersion.value,
      "Implementation-Vendor-Id" -> organization.value,
      "Implementation-Vendor" -> organizationName.value
    ),
    publishTo := sonatypePublishToBundle.value,
    pomIncludeRepository := (_ => false),
    publishMavenStyle := true,
    sonatypeProfileNameSetting
  )

  private def sonatypeProfileNameSetting: Setting[String] = sonatypeProfileName := "africa.shuwari"

}
