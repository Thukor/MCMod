package traits

import net.minecraft.item.Item

sealed trait HarvestAttempt

case class Success(drops: List[Item]) extends HarvestAttempt
case object Failure extends HarvestAttempt