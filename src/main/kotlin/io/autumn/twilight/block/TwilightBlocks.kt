package io.autumn.twilight.block

import io.autumn.carminite.property.*
import io.autumn.carminite.registry.*
import io.autumn.carminite.wood.WoodSet
import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight
import io.autumn.twilight.block.custom.ConnectedCarpetBlock
import io.autumn.twilight.block.custom.MinewoodCoreBlock
import io.autumn.twilight.block.custom.SortwoodCoreBlock
import io.autumn.twilight.block.custom.TimewoodCoreBlock
import io.autumn.twilight.block.custom.TranswoodCoreBlock
import io.autumn.twilight.block.custom.TwilightChestBlock
import io.autumn.twilight.block.custom.TwilightTrappedChestBlock
import io.autumn.twilight.blockentity.TwilightBlockEntityTypes
import io.autumn.twilight.lists.TwilightTreeGrowers
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.FlowerPotBlock
import net.minecraft.world.level.block.SaplingBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.TintedParticleLeavesBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.BlockSetType
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.block.state.properties.WoodType
import net.minecraft.world.level.material.MapColor

object TwilightBlocks {

    val ROOT_BLOCK = registerGenericBlock(Twilight.namespaceAndPath("root_block"), ::Block, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(2.0F, 3.0F))
    val LIVEROOT_BLOCK = registerGenericBlock(Twilight.namespaceAndPath("liveroot_block"), ::Block, BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.WOOD).strength(2.0F, 3.0F))

    val TWILIGHT_OAK_SET = WoodSet(Twilight.namespaceAndPath("twilight_oak"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.TWILIGHT_OAK, MapColor.WOOD, MapColor.PODZOL)
    val RAINBOW_OAK_LEAVES = registerGenericBlock(Twilight.namespaceAndPath("rainbow_oak_leaves"), { p -> TintedParticleLeavesBlock(0.01f, p) }, Blocks.leavesProperties(SoundType.GRASS))
    val RAINBOW_OAK_SAPLING = registerGenericBlock(Twilight.namespaceAndPath("rainbow_oak_sapling"), { p -> SaplingBlock(TwilightTreeGrowers.RAINBOW_OAK, p) }, saplingProperties())
    val POTTED_RAINBOW_OAK_SAPLING = registerGenericBlock(Twilight.namespaceAndPath("potted_rainbow_oak_sapling"),  { p -> FlowerPotBlock(RAINBOW_OAK_SAPLING, p) }, Blocks.flowerPotProperties())
    val TWILIGHT_OAK_CHEST = registerGenericBlock(Twilight.namespaceAndPath("twilight_oak_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(TWILIGHT_OAK_SET.strippedWood))
    val TRAPPED_TWILIGHT_OAK_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_twilight_oak_chest"), ::TwilightTrappedChestBlock, chestProperties(TWILIGHT_OAK_SET.strippedWood))

    val CANOPY_SET = WoodSet(Twilight.namespaceAndPath("canopy"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.CANOPY, MapColor.PODZOL, MapColor.COLOR_BROWN)
    val CANOPY_CHEST = registerGenericBlock(Twilight.namespaceAndPath("canopy_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(CANOPY_SET.strippedWood))
    val TRAPPED_CANOPY_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_canopy_chest"), ::TwilightTrappedChestBlock, chestProperties(CANOPY_SET.strippedWood))

    val TWILIGHT_MANGROVE_SET = WoodSet(Twilight.namespaceAndPath("twilight_mangrove"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.TWILIGHT_MANGROVE, MapColor.DIRT, MapColor.PODZOL)
    val TWILIGHT_MANGROVE_ROOT = registerGenericBlock(Twilight.namespaceAndPath("twilight_mangrove_root"), ::Block, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).mapColor(MapColor.STONE).sound(SoundType.WOOD).strength(2.0F))
    val TWILIGHT_MANGROVE_CHEST = registerGenericBlock(Twilight.namespaceAndPath("twilight_mangrove_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(TWILIGHT_MANGROVE_SET.strippedWood))
    val TRAPPED_TWILIGHT_MANGROVE_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_twilight_mangrove_chest"), ::TwilightTrappedChestBlock, chestProperties(TWILIGHT_MANGROVE_SET.strippedWood))

    val DARKWOOD_SET = WoodSet(Twilight.namespaceAndPath("darkwood"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.DARKWOOD, MapColor.COLOR_BROWN, MapColor.STONE)
    val DARKWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("darkwood_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(DARKWOOD_SET.strippedWood))
    val TRAPPED_DARKWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_darkwood_chest"), ::TwilightTrappedChestBlock, chestProperties(DARKWOOD_SET.strippedWood))

    val TIMEWOOD_SET = WoodSet(Twilight.namespaceAndPath("timewood"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.TIMEWOOD, MapColor.DIRT, MapColor.PODZOL)
    val TIMEWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("timewood_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(TIMEWOOD_SET.strippedWood))
    val TRAPPED_TIMEWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_timewood_chest"), ::TwilightTrappedChestBlock, chestProperties(TIMEWOOD_SET.strippedWood))
    val TIMEWOOD_CORE = registerGenericBlock(Twilight.namespaceAndPath("timewood_core"), ::TimewoodCoreBlock, Blocks.logProperties(MapColor.DIRT, MapColor.PODZOL, SoundType.WOOD))

    val TRANSWOOD_SET = WoodSet(Twilight.namespaceAndPath("transwood"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.TRANSWOOD, MapColor.WOOD, MapColor.PODZOL)
    val TRANSWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("transwood_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(TRANSWOOD_SET.strippedWood))
    val TRAPPED_TRANSWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_transwood_chest"), ::TwilightTrappedChestBlock, chestProperties(TRANSWOOD_SET.strippedWood))
    val TRANSWOOD_CORE = registerGenericBlock(Twilight.namespaceAndPath("transwood_core"), ::TranswoodCoreBlock, Blocks.logProperties(MapColor.WOOD, MapColor.PODZOL, SoundType.WOOD))

    val MINEWOOD_SET = WoodSet(Twilight.namespaceAndPath("minewood"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.MINEWOOD, MapColor.SAND, MapColor.QUARTZ)
    val MINEWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("minewood_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(MINEWOOD_SET.strippedWood))
    val TRAPPED_MINEWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_minewood_chest"), ::TwilightTrappedChestBlock, chestProperties(MINEWOOD_SET.strippedWood))
    val MINEWOOD_CORE = registerGenericBlock(Twilight.namespaceAndPath("minewood_core"), ::MinewoodCoreBlock, Blocks.logProperties(MapColor.SAND, MapColor.QUARTZ, SoundType.WOOD))

    val SORTWOOD_SET = WoodSet(Twilight.namespaceAndPath("sortwood"), BlockSetType.OAK, WoodType.OAK, TwilightTreeGrowers.SORTWOOD, MapColor.PODZOL, MapColor.COLOR_BROWN)
    val SORTWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("sortwood_chest"), { p -> TwilightChestBlock({ TwilightBlockEntityTypes.TWILIGHT_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, p) }, chestProperties(SORTWOOD_SET.strippedWood))
    val TRAPPED_SORTWOOD_CHEST = registerGenericBlock(Twilight.namespaceAndPath("trapped_sortwood_chest"), ::TwilightTrappedChestBlock, chestProperties(SORTWOOD_SET.strippedWood))
    val SORTWOOD_CORE = registerGenericBlock(Twilight.namespaceAndPath("sortwood_core"), ::SortwoodCoreBlock, Blocks.logProperties(MapColor.PODZOL, MapColor.COLOR_BROWN, SoundType.WOOD))

    val CORONATION_CARPET_CRUDE = registerGenericBlock(Twilight.namespaceAndPath("coronation_carpet"), ::ConnectedCarpetBlock, carpetProperties(MapColor.COLOR_RED))

    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering blocks for ${Twilight.NAMESPACE}.")
    }
}