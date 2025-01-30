import sbt.*
import sbtdynver.DynVerPlugin
import sbtdynver.DynVerPlugin.autoImport.*

object VersionPlugin extends AutoPlugin {

  override def requires: Plugins = DynVerPlugin

  override def trigger = allRequirements

  override def buildSettings: Seq[Def.Setting[?]] = List(
    Keys.version := versionSetting.value,
    dynver := versionSetting.toTaskable.toTask.value,
    autoImport.implementationVersion := implementationVersionSetting.value
  )

  object autoImport {
    val implementationVersion: SettingKey[String] = settingKey[String]("Implementation version")
  }

  private def baseVersionSetting(appendMetadata: Boolean): Def.Initialize[String] = {
    def baseVersionFormatter(in: sbtdynver.GitDescribeOutput) = {
      def meta =
        if (appendMetadata) s"+${in.commitSuffix.distance}.${in.commitSuffix.sha}"
        else ""

      if (!in.isSnapshot()) in.ref.dropPrefix
      else {
        val parts = {
          def current = in.ref.dropPrefix.split("\\.").map(_.toInt)
          current.updated(current.length - 1, current.last + 1)
        }
        s"${parts.mkString(".")}-SNAPSHOT$meta"
      }
    }

    Def.setting(
      dynverGitDescribeOutput.value.mkVersion(
        baseVersionFormatter,
        "HEAD-SNAPSHOT"
      )
    )
  }

  private def versionSetting = baseVersionSetting(appendMetadata = false)

  private def implementationVersionSetting = baseVersionSetting(appendMetadata = true)

}
