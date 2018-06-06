package handlers

import net.liftweb.json.{NoTypeHints, Serialization}
import net.minecraft.world.storage.loot.LootPool
import net.minecraftforge.event.LootTableLoadEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import net.liftweb.json.Serialization.read

import scala.io.Source


@EventBusSubscriber
object VanillaLootTableModifierHandler {

  private val RESOURCEPATH = "..\\src\\main\\scala\\datamanagement\\data\\vanilla_items_to_remove_from_loot_tables.json"
  private implicit val format = Serialization.formats(NoTypeHints)
  private val vanillaItemsToRemove: List[String] = read[List[String]](Source.fromFile(RESOURCEPATH).mkString)

  private def buildStreamOfNames(number: Int): Stream[String] = {
    ("pool" + number.toString) #:: buildStreamOfNames(number + 1)
  }
  @SubscribeEvent
  def removeVanillaToolsAndArmor(event: LootTableLoadEvent): Unit = {
    // Get the loot table
    val table = event.getTable

    //Construct a stream that'll lazily compute possible vanilla loot table names
    val poolNames: Stream[String] = "main" #:: buildStreamOfNames(1)

    //Get all the lootpools by taking the head of the stream and
    //mapping it to a pool until we hit a null value
    val poolList: List[LootPool] = poolNames.takeWhile(poolName => {
      Option(table.getPool(poolName)) match {
        case Some(pool) => true
        case None => false
      }
    }).toList.map(name => table.getPool(name))

    //Remove each item from every loot table
    poolList.foreach(pool => vanillaItemsToRemove.foreach(name => pool.removeEntry(name)))

  }

}
