package traits

sealed trait ResourceCategory

object ResourceCategory {

  case object LOG extends ResourceCategory
  case object ORE extends ResourceCategory
  case object GEM extends ResourceCategory
  case object CRYSTAL extends ResourceCategory
  case object STONE extends ResourceCategory
  case object ENERUM extends ResourceCategory
  case object CROP extends ResourceCategory
  case object FRUIT extends ResourceCategory
  case object PLANT extends ResourceCategory
  case object FOSSILFUEL extends ResourceCategory
  case object GAS extends ResourceCategory
  case object FLUID extends ResourceCategory
  case object UNKNOWN_CATEGORY extends ResourceCategory

  def fromstring(s: String): ResourceCategory = s.toUpperCase() match {
    case "LOG" => LOG
    case "ORE" => ORE
    case "GEM" => GEM
    case "CRYSTAL" => CRYSTAL
    case "STONE" => STONE
    case "ENERUM" => ENERUM
    case "CROP" => CROP
    case "FRUIT" => FRUIT
    case "PLANT" => PLANT
    case "FOSSILFUEL" => FOSSILFUEL
    case "GAS" => GAS
    case "FLUID" => FLUID
    case _ => UNKNOWN_CATEGORY
  }

}

