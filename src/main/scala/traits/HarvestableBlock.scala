package traits

import java.util.Random

import datamanagement.{HarvestableBlockDataManager, ResourceBlockData}
import net.minecraft.block.Block
import net.minecraft.item.Item

sealed trait HarvestableBlock {

  type NaturalResourceData = (Int, List[Item], ResourceCategory, Boolean)

  def map(f: NaturalResourceData => NaturalResourceData): HarvestableBlock
  def flatMap(f: NaturalResourceData => HarvestableBlock): HarvestableBlock

}

case class Resource(harvestLevel: Int,
                    drops: List[Item],
                    resourceClass: ResourceCategory,
                    isSelfDropping: Boolean
                    ) extends HarvestableBlock {

  def map(f: NaturalResourceData => NaturalResourceData): HarvestableBlock = {
    Resource.tupled(f((harvestLevel, drops, resourceClass, isSelfDropping)))
  }

  def flatMap(f: NaturalResourceData => HarvestableBlock): HarvestableBlock = {
    f((harvestLevel, drops, resourceClass, isSelfDropping))
  }
}

case object NotAResource extends HarvestableBlock {
  def map(f: NaturalResourceData => NaturalResourceData): HarvestableBlock = NotAResource
  def flatMap(f: NaturalResourceData => HarvestableBlock): HarvestableBlock = NotAResource
}

object HarvestableBlock {

  private val resources: Map[String, ResourceBlockData] = HarvestableBlockDataManager.resources
  private val randomNumberGenerator = new Random()
  def apply(block: Block): HarvestableBlock = {
    if (resources.contains(block.getRegistryName.getResourcePath)) {
      val data = resources(block.getRegistryName.getResourcePath)
      val drops = List.fill[Item](block.quantityDropped(randomNumberGenerator))(block.getItemDropped(block.getDefaultState, randomNumberGenerator, 0))
      val isSelfDropping = block.getRegistryName.getResourcePath == block.getItemDropped(block.getDefaultState, randomNumberGenerator, 0).getRegistryName.getResourcePath
      Resource(data.harvestLevel, drops, ResourceCategory.fromstring(data.resourceType), isSelfDropping)
    } else NotAResource
  }


}