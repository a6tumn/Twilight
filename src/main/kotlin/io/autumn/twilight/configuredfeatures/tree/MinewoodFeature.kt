package io.autumn.twilight.configuredfeatures.tree

import com.mojang.serialization.Codec
import io.autumn.carminite.feature.RootPlacer
import io.autumn.carminite.feature.hasAirAround
import io.autumn.carminite.feature.placeIfValidTreePos
import io.autumn.carminite.feature.placeBranchWithLeaves
import io.autumn.carminite.feature.placeIfValidRootPos
import io.autumn.carminite.feature.placeNonExposedRoot
import io.autumn.carminite.tree.config.CarminiteTreeFeatureConfig
import io.autumn.carminite.tree.feature.CarminiteTreeFeature
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

class MinewoodFeature(config: Codec<CarminiteTreeFeatureConfig>) :
    CarminiteTreeFeature(config) {

    override fun generate(
        world: WorldGenLevel,
        random: RandomSource,
        pos: BlockPos,
        trunkPlacer: BiConsumer<BlockPos, BlockState>,
        leavesPlacer: BiConsumer<BlockPos, BlockState>,
        decorationPlacer: RootPlacer,
        config: CarminiteTreeFeatureConfig
    ): Boolean {

        if (world.isOutsideBuildHeight(pos.y + 12)) {
            return false
        }

        for (dy in 0..9) {
            placeIfValidTreePos(
                world,
                trunkPlacer,
                random,
                pos.above(dy),
                config.trunkProvider
            )
        }

        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 9, 1), true, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 9, 2), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 8, 3), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 7, 4), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 6, 5), false, config)

        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 9, -1), true, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 9, -2), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 8, -3), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 7, -4), false, config)
        placeBranchWithLeaves(world, trunkPlacer, leavesPlacer, random, pos.offset(0, 6, -5), false, config)

        val stateAtCorePos = world.getBlockState(pos.above())
        if (stateAtCorePos.`is`(BlockTags.LOGS) || stateAtCorePos.canBeReplaced()) {
            world.setBlock(
                pos.above(),
                TwilightBlocks.MINEWOOD_CORE.defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y),
                Block.UPDATE_ALL
            )
            world.scheduleTick(pos.above(), TwilightBlocks.MINEWOOD_CORE, 20)
        }

        if (hasAirAround(world, pos.below())) {
            placeIfValidTreePos(
                world,
                trunkPlacer,
                random,
                pos.below(),
                config.trunkProvider
            )
        } else {
            placeIfValidRootPos(
                world,
                decorationPlacer,
                random,
                pos.below(),
                config.rootsProvider
            )
        }

        val numRoots = 3 + random.nextInt(2)
        val offset = random.nextFloat()

        for (b in 0 until numRoots) {
            placeNonExposedRoot(
                world,
                decorationPlacer,
                random,
                pos,
                offset.toDouble(),
                b,
                config.rootsProvider
            )
        }

        return true
    }
}