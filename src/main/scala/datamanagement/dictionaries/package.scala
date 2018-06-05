package datamanagement

import datamanagement.datapacks.ResourceDataPack
import datamanagement.jsonutil.{ItemSerializer, ResourceCategorySerializer}
import net.liftweb.json._
import net.liftweb.json.Serialization.{read, write}
import util.json.JsonLoader
import implicits.DictionaryImplicits._
import net.liftweb.json.JsonAST.JObject
import traits.ResourceCategory

import scala.io.Source


/*
  ALL DICTIONARY INSTANCES TO BE INSTANTIATED HERE
 */
package object dictionaries {

  val RESOURCEDICT: Map[String, ResourceDataPack] = {
    val jsonString = Source.fromFile("..\\src\\main\\scala\\datamanagement\\data\\resource_blocks.json").mkString
    implicit val formats = Serialization.formats(NoTypeHints) +
      new ItemSerializer + new ResourceCategorySerializer
    read[Map[String,ResourceDataPack]](jsonString)
  }

}
