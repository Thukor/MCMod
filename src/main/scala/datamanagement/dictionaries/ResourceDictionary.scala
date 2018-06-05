package datamanagement.dictionaries

import datamanagement.ResourceBlockData
import implicits.BlockImplicits._
import net.liftweb.json._
import net.minecraft.block.state.IBlockState
import util.VanillaRegistryNameCorrector

import scala.io.Source

//
//class ResourceDictionary(val dictionary: Map[String, ResourceBlockData]) extends MinecraftCategoryDictionary[IBlockState, ResourceBlockData] {
//
//  /*
//    Constructor
//  */
//
//  def hasMember(element: IBlockState): Boolean = dictionary contains VanillaRegistryNameCorrector.rename(element.registryName)
//  def extractDataPack(element: IBlockState): Option[ResourceBlockData] = {
//    if (hasMember(element)) Some(dictionary(VanillaRegistryNameCorrector.rename(element.registryName)))
//    else None
//  }
//  def allMembers: List[ResourceBlockData] = dictionary.values.toList
//  def filterMembers(f: ResourceBlockData => Boolean): List[ResourceBlockData] = allMembers.filter(f)
//
//
//}