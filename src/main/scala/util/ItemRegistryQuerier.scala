package util

import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation

object ItemRegistryQuerier {

  def getItemByName(domainName: String, registryName: String): Option[Item] = {
    val registry = Item.REGISTRY
    Option(registry.getObject(new ResourceLocation(domainName, registryName)))
  }

}
