package implicits

import net.minecraft.item.{Item, ItemTool}


/*

  Implicit conversions for dealing with items during events
  where it's crucial to know whether or not an item
  is an instance of an ItemTool

 */

object ToolImplicits {

  implicit class itemToToolCheckable(item: Item) {
    def isTool: Boolean = item match {
      case _ : ItemTool => true
      case _ => false
    }
  }


}
