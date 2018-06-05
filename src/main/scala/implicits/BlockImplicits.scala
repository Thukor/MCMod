package implicits

import net.minecraft.block.Block
import net.minecraft.block.state.IBlockState
import util.VanillaRegistryNameCorrector

/*

  Implicit Conversions for Blocks

*/

object BlockImplicits {
  implicit class blockUtil(block: Block) {
    def registryName: String = VanillaRegistryNameCorrector.rename(block.getRegistryName.getResourcePath)
    def unlocalizedName: String = block.getUnlocalizedName
  }

  implicit class blockStateUtil(state: IBlockState) {
    def registryName: String = state.getBlock.registryName
    def unlocalizedName: String = state.getBlock.unlocalizedName
  }
}
