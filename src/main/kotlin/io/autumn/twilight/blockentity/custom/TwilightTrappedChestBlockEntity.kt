package io.autumn.twilight.blockentity.custom

import io.autumn.twilight.blockentity.TwilightBlockEntityTypes
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.TrappedChestBlock
import net.minecraft.world.level.block.entity.ChestBlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.redstone.ExperimentalRedstoneUtils

class TwilightTrappedChestBlockEntity(pos: BlockPos, state: BlockState) : ChestBlockEntity(TwilightBlockEntityTypes.TWILIGHT_TRAPPED_CHEST, pos, state) {
    override fun signalOpenCount(level: Level, pos: BlockPos, blockState: BlockState, previous: Int, current: Int) {
        super.signalOpenCount(level, pos, blockState, previous, current)

        if (previous != current) {
            val orientation = ExperimentalRedstoneUtils.initialOrientation(
                level,
                blockState.getValue(TrappedChestBlock.FACING).opposite,
                Direction.UP
            )

            val block = blockState.block
            level.updateNeighborsAt(pos, block, orientation)
            level.updateNeighborsAt(pos.below(), block, orientation)
        }
    }
}