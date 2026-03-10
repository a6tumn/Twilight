package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import io.autumn.twilight.blockentity.TwilightBlockEntityTypes
import io.autumn.twilight.blockentity.custom.TwilightTrappedChestBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.resources.Identifier
import net.minecraft.sounds.SoundEvents
import net.minecraft.stats.Stat
import net.minecraft.stats.Stats
import net.minecraft.util.Mth
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.ChestBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.ChestBlockEntity
import net.minecraft.world.level.block.state.BlockState

class TwilightTrappedChestBlock(properties: Properties) : ChestBlock({ TwilightBlockEntityTypes.TWILIGHT_TRAPPED_CHEST }, SoundEvents.CHEST_OPEN, SoundEvents.CHEST_CLOSE, properties) {
    companion object {
        val CODEC: MapCodec<TwilightTrappedChestBlock> = simpleCodec(::TwilightTrappedChestBlock)
    }

    override fun codec(): MapCodec<TwilightTrappedChestBlock> = CODEC

    override fun newBlockEntity(worldPosition: BlockPos, blockState: BlockState): BlockEntity = TwilightTrappedChestBlockEntity(worldPosition, blockState)

    override fun getOpenChestStat(): Stat<Identifier> = Stats.CUSTOM.get(Stats.TRIGGER_TRAPPED_CHEST)

    override fun isSignalSource(state: BlockState): Boolean = true

    override fun getSignal(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction): Int = Mth.clamp(ChestBlockEntity.getOpenCount(level, pos), 0, 15)

    override fun getDirectSignal(state: BlockState, level: BlockGetter, pos: BlockPos, direction: Direction): Int = if (direction == Direction.UP) state.getSignal(level, pos, direction) else 0
}