import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent}
import java.util.Random

import net.liftweb.json.Serialization.{read, write}
import datamanagement.datapacks.{Drop, ResourceDataPack}
import net.liftweb.json.{NoTypeHints, Serialization}
import net.minecraft.block.BlockStone
import traits.{HarvestableBlock, Resource, ResourceCategory}
import util.ItemRegistryQuerier
import datamanagement.jsonutil.{ItemSerializer, ResourceCategorySerializer}

@Mod(name = Reference.MODNAME, modid = Reference.MODID, version = Reference.VERSION, acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", modLanguageAdapter = "io.github.illyohs.scorg.ScalaAdapter")
object ModMain {

  @EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    println("Pre-Initialization!")
  }

  @EventHandler
  def init(event: FMLPreInitializationEvent): Unit = {
    println("Initialization!")
  }

  @EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = {
    println("Post-Initialization!")

    implicit val formats = Serialization.formats(NoTypeHints) + new ItemSerializer + new ResourceCategorySerializer
    val test = ResourceDataPack("oreIron", ResourceCategory.ORE, 1, 100, List(Drop(ItemRegistryQuerier.getItemByName("minecraft", "iron_ore").get, 1, 1.0), Drop(ItemRegistryQuerier.getItemByName("minecraft", "iron_ore").get, 1, 1.0)), "PICKAXE")
//    println(prettyRender(write(test)))
    println(datamanagement.dictionaries.RESOURCEDICT)
  }


}