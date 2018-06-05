package util

import net.liftweb.json._

import scala.io.Source

object VanillaRegistryNameCorrector {

  /* Build rename map */
  private val VanillaNameMapper: Map[String, String] = {
    val jsonParse = parse(Source.fromFile("vanilla_name_remap.json").mkString)
    (for {
      JObject(root) <- jsonParse
      JField(vanillaName, JString(newName)) <- root
    } yield (vanillaName -> newName)).toMap
  }


  /* Methods */

  /* Determines if string is a vanilla name to be renamed */
  def canRename(s: String): Boolean = VanillaNameMapper contains s

  /* Renames vanilla string if necessary.  If unnecessary simply returns the original string */
  def rename(s: String): String = if (canRename(s)) VanillaNameMapper(s) else s


}
