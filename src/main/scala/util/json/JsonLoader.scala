package util.json

import net.liftweb.json._

import scala.io.Source

object JsonLoader {

  def jsonToMap[T,V](filepath: String, f: JValue => Map[T,V]): Map[T,V] = {
    f(parse(Source.fromFile(filepath).mkString))
  }


}
