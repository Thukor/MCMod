package datamanagement.jsonutil

import datamanagement.datapacks.Drop
import net.liftweb.json._
import net.liftweb.json.{Formats, JValue, Serializer, TypeInfo}
import implicits.ItemImplicits._
import net.minecraft.item.Item
import util.ItemRegistryQuerier

class ItemSerializer extends Serializer[Item] {
  private val ItemClass = classOf[Item]

  def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Item] = {
    case (TypeInfo(ItemClass, _), json) => json match {
      case JString(item) => {
        val splitName = item.split(":")
        val (domain, name) = (splitName(0), splitName(1))
        ItemRegistryQuerier.getItemByName(domain, name) match {
          case Some(regItem) => regItem
          case None => throw new MappingException("Item " + item + " does not exist in registry!")
        }
      }
      case x => throw new MappingException("Can't convert " + x + " to Item!")
    }
  }

  def serialize(implicit format: Formats): PartialFunction[Any, JValue] = {
    case item: Item =>
      JString(item.getRegistryName.toString)
  }
}
