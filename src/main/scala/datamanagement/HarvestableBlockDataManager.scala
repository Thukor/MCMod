package datamanagement

import net.liftweb.json._
import traits.Resource

import scala.collection.mutable.HashMap
import scala.io.Source


case class ResourceBlockData(harvestLevel: Int, resourceType: String, experienceOnHarvest: Int, toolType: String)

object HarvestableBlockDataManager {
  def resources: Map[String, ResourceBlockData] = {
    (for {
      JObject(root) <- parse(Source.fromFile("\\Users\\chris\\Desktop\\MCMod\\src\\main\\scala\\datamanagement\\resource_blocks.json").mkString)
      JField("resource_name", JString(name)) <- root
      JField("resource_type", JString(resourceType)) <- root
      JField("harvest_level", JInt(level)) <- root
      JField("experience_on_harvest", JInt(exp)) <- root
      JField("tool_required", JString(tool)) <- root
    } yield (name -> ResourceBlockData(level.toInt, resourceType, exp.toInt, tool))).toMap
  }
}
