import net.minecraft.init.Blocks
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent}
import java.util.Random

import traits.HarvestableBlock

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
    println(Blocks.COAL_ORE.getRegistryName.getResourcePath)
    println("TEST")
  }

}