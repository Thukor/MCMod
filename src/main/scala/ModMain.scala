import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.{FMLPostInitializationEvent, FMLPreInitializationEvent}

@Mod(name = "RoadToSelyx", modid = "rts", version = ".01", acceptableRemoteVersions = "*", acceptedMinecraftVersions = "*", modLanguageAdapter = "io.github.illyohs.scorg.ScalaAdapter")
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
  }

}