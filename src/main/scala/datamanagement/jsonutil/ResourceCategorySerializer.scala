package datamanagement.jsonutil

import net.liftweb.json.JsonAST.JString
import net.liftweb.json._
import traits.ResourceCategory
import traits.ResourceCategory._

class ResourceCategorySerializer extends Serializer[ResourceCategory] {

  private val ResourceCategoryClass = classOf[ResourceCategory]

  def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), ResourceCategory] = {
    case (TypeInfo(ResourceCategoryClass, _), json) => json match {
      case JString(cat) => {
        val category = ResourceCategory.fromstring(cat)
        category match {
          case UNKNOWN_CATEGORY => throw new MappingException("No resource category exists for " + cat + "!")
          case _ => category
        }
      }
      case x => throw new MappingException("Can't convert " + x + " to ResourceCategory!")
    }
  }

  def serialize(implicit format: Formats): PartialFunction[Any, JValue] = {
    case cat: ResourceCategory =>
      JString(cat.toString)
  }
}
