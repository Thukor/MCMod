package datamanagement

import datamanagement.datapacks.ResourceDataPack
import datamanagement.jsonutil.{ItemSerializer, ResourceCategorySerializer}
import net.liftweb.json._
import util.json.JsonLoader._

/*
  ALL DICTIONARY INSTANCES TO BE INSTANTIATED HERE
 */
package object dictionaries {

  val RESOURCEPATH = "..\\src\\main\\scala\\datamanagement\\data\\resource_blocks.json"

  val RESOURCEDICT: Map[String, ResourceDataPack] = {
    implicit val resource_formats = Serialization.formats(NoTypeHints) + new ItemSerializer + new ResourceCategorySerializer
    jsonToMap[String, ResourceDataPack](RESOURCEPATH)
  }

}
