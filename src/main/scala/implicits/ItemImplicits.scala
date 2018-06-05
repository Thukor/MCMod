package implicits

import net.minecraft.item.Item

object ItemImplicits {

  implicit class itemWithRegistryNAme(item: Item) {
    def registryName: String = item.getRegistryName.getResourcePath
  }

}
