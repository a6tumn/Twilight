package io.autumn.twilight.configuredfeatures.tree

import com.mojang.serialization.Codec
import io.autumn.carminite.feature.RootPlacer
import io.autumn.carminite.tree.config.CarminiteTreeFeatureConfig
import io.autumn.carminite.tree.feature.HollowTreeFeature
import io.autumn.twilight.block.TwilightBlocks
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.tags.BlockTags
import net.minecraft.util.RandomSource
import net.minecraft.world.level.WorldGenLevel
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.state.BlockState
import java.util.function.BiConsumer

class TimewoodFeature(config: Codec<CarminiteTreeFeatureConfig>) : HollowTreeFeature(config) {

    override fun generate(world: WorldGenLevel, random: RandomSource, pos: BlockPos, trunkPlacer: BiConsumer<BlockPos, BlockState>, leavesPlacer: BiConsumer<BlockPos, BlockState>, decorationPlacer: RootPlacer, config: CarminiteTreeFeatureConfig): Boolean {
        val height = 8
        val radius = 1

        if (world.isOutsideBuildHeight(pos.y + height + radius)) {
            return false
        }

        buildBranchRing(
            world, trunkPlacer, leavesPlacer, random,
            pos, radius, 1, 0, 12, 0.75, 3, 5, 3, false, config
        )

        buildBranchRing(
            world, trunkPlacer, leavesPlacer, random,
            pos, radius, 1, 2, 18, 0.9, 3, 5, 3, false, config
        )

        buildTrunk(world, trunkPlacer, decorationPlacer, random, pos, radius, height, config)
        buildTinyCrown(world, trunkPlacer, leavesPlacer, random, pos, radius, height, config)


        val corePos = pos.offset(-1, 2, 0)
        val stateAtCorePos = world.getBlockState(pos.above())
        if (stateAtCorePos.`is`(BlockTags.LOGS) || stateAtCorePos.canBeReplaced()) {
            world.setBlock(corePos, TwilightBlocks.TIMEWOOD_CORE.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), Block.UPDATE_ALL)
            world.scheduleTick(corePos, TwilightBlocks.TIMEWOOD_CORE, 20)
        }

        return true
    }

    private fun buildTinyCrown(world: WorldGenLevel, trunkPlacer: BiConsumer<BlockPos, BlockState>, leavesPlacer: BiConsumer<BlockPos, BlockState>, random: RandomSource, pos: BlockPos, radius: Int, height: Int, config: CarminiteTreeFeatureConfig) {
        val crownRadius = 4
        val bvar = 1

        buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, height - crownRadius, 0, crownRadius, 0.35, bvar, bvar + 2, 1, true, config)
        buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, height - (crownRadius shr 1), 0, crownRadius, 0.28, bvar, bvar + 2, 1, true, config)
        buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, height, 0, crownRadius, 0.15, 2, 4, 0, true, config)
        buildBranchRing(world, trunkPlacer, leavesPlacer, random, pos, radius, height, 0, crownRadius shr 1, 0.05, bvar, bvar + 2, 0, true, config)
    }
}