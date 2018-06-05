package datamanagement.datapacks

import traits.ResourceCategory

case class ResourceDataPack(resourceName: String,
                            resourceCategory: ResourceCategory,
                            harvestLevel: Int,
                            experienceOnHarvest: Int,
                            drops: List[Drop],
                            toolRequired: String) extends MinecraftCategoryDataPack
