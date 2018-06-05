package implicits

import datamanagement.datapacks.{MinecraftCategoryDataPack, ResourceDataPack}
import util.json.JsonLoader

object DictionaryImplicits {

  implicit class dictionary[T <: MinecraftCategoryDataPack](map: Map[String, T]) {


  }


}
