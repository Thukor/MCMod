package util.json

import net.liftweb.json._
import net.liftweb.json.Serialization.read
import scala.io.Source

object JsonLoader {
  def jsonToMap[T,V](filepath: String)(implicit format: Formats, manifest: Manifest[Map[T,V]]): Map[T,V] = {
    val jsonString = Source.fromFile(filepath).mkString
    read[Map[T,V]](jsonString)
  }
}
