package io.autumn.twilight.providers

import io.autumn.carminite.feature.CarminiteBlockTags
import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.lists.TwilightBlockTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import java.util.concurrent.CompletableFuture

class BlockTagsProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) :  FabricTagsProvider.BlockTagsProvider(output, registriesFuture){
    override fun addTags(p0: HolderLookup.Provider) {
        valueLookupBuilder(CarminiteBlockTags.ROOT_TRACE_SKIP)
            .addOptionalTag(BlockTags.LOGS)
            .add(TwilightBlocks.ROOT_BLOCK, TwilightBlocks.LIVEROOT_BLOCK, TwilightBlocks.TWILIGHT_MANGROVE_ROOT)
            .addOptionalTag(BlockTags.FEATURES_CANNOT_REPLACE)

        valueLookupBuilder(CarminiteBlockTags.WORLDGEN_REPLACEABLES)
            .addOptionalTag(BlockTags.LUSH_GROUND_REPLACEABLE)
            .addOptionalTag(BlockTags.REPLACEABLE_BY_TREES)

        valueLookupBuilder(TwilightBlockTags.TIMEWOOD_CORE_EXCLUDED)
            .add(Blocks.NETHER_PORTAL)

        valueLookupBuilder(TwilightBlockTags.ORE_MAGNET_SAFE_REPLACE_BLOCK)
            .addOptionalTag(BlockTags.DIRT)
            .addOptionalTag(BlockTags.SAND)
            .addOptionalTag(BlockTags.NYLIUM)
            .addOptionalTag(BlockTags.BASE_STONE_OVERWORLD)
            .addOptionalTag(BlockTags.BASE_STONE_NETHER)
            .addOptionalTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            .addOptionalTag(BlockTags.STONE_ORE_REPLACEABLES)
            .add(TwilightBlocks.ROOT_BLOCK)
            .add(TwilightBlocks.LIVEROOT_BLOCK)

        createWoodSetBlockTags(TwilightBlocks.TWILIGHT_OAK_SET)
        createWoodSetBlockTags(TwilightBlocks.CANOPY_SET)
        createWoodSetBlockTags(TwilightBlocks.TWILIGHT_MANGROVE_SET)
        createWoodSetBlockTags(TwilightBlocks.DARKWOOD_SET)
        createWoodSetBlockTags(TwilightBlocks.TIMEWOOD_SET)
        createWoodSetBlockTags(TwilightBlocks.TRANSWOOD_SET)
        createWoodSetBlockTags(TwilightBlocks.MINEWOOD_SET)
        createWoodSetBlockTags(TwilightBlocks.SORTWOOD_SET)

        valueLookupBuilder(BlockTags.LEAVES)
            .add(TwilightBlocks.RAINBOW_OAK_LEAVES)

        valueLookupBuilder(BlockTags.SAPLINGS)
            .add(TwilightBlocks.RAINBOW_OAK_SAPLING)

        valueLookupBuilder(TwilightBlockTags.INCORRECT_FOR_IRONWOOD_TOOL)
            .addOptionalTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
    }

    private fun createWoodSetBlockTags(woodSet: WoodSet) {
        valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
            .add(woodSet.log)
            .add(woodSet.strippedLog)
            .add(woodSet.wood)
            .add(woodSet.strippedWood)

        valueLookupBuilder(BlockTags.LEAVES)
            .add(woodSet.leaves)

        valueLookupBuilder(BlockTags.SAPLINGS)
            .add(woodSet.sapling)

        valueLookupBuilder(BlockTags.PLANKS)
            .add(woodSet.planks)

        valueLookupBuilder(BlockTags.WOODEN_DOORS)
            .add(woodSet.door)

        valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
            .add(woodSet.trapdoor)

        valueLookupBuilder(BlockTags.WOODEN_FENCES)
            .add(woodSet.fence)

        valueLookupBuilder(BlockTags.WOODEN_STAIRS)
            .add(woodSet.stairs)

        valueLookupBuilder(BlockTags.WOODEN_SLABS)
            .add(woodSet.slab)

        valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
            .add(woodSet.button)

        valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
            .add(woodSet.pressurePlate)

        valueLookupBuilder(BlockTags.STANDING_SIGNS)
            .add(woodSet.standingSign)

        valueLookupBuilder(BlockTags.WALL_SIGNS)
            .add(woodSet.wallSign)

        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
            .add(woodSet.hangingSign)

        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
            .add(woodSet.wallHangingSign)
    }
}