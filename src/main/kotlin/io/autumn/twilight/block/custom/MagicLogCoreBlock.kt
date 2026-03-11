package io.autumn.twilight.block.custom

import net.minecraft.ChatFormatting
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.phys.BlockHitResult

abstract class MagicLogCoreBlock(properties: Properties) : RotatedPillarBlock(
    properties
        .strength(2.0f)
        .sound(SoundType.WOOD)
        .lightLevel { state -> if (state.getValue(ACTIVE)) 15 else 0 }
) {

    init {
        registerDefaultState(stateDefinition.any().setValue(ACTIVE, false))
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        super.createBlockStateDefinition(builder.add(ACTIVE))
    }

    override fun onPlace(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        oldState: BlockState,
        isMoving: Boolean
    ) {
        level.scheduleTick(pos, this, 20)
    }

    override fun tick(state: BlockState, level: ServerLevel, pos: BlockPos, rand: RandomSource) {
        if (!state.getValue(ACTIVE) || !doesCoreFunction()) return

        playSound(level, pos, rand)
        performTreeEffect(level, pos, rand)

        level.scheduleTick(pos, this, 20)
    }

    override fun useWithoutItem(
        state: BlockState,
        level: Level,
        pos: BlockPos,
        player: Player,
        result: BlockHitResult
    ): InteractionResult {

        if (!doesCoreFunction()) {
            level.setBlockAndUpdate(pos, state.setValue(ACTIVE, false))
            player.sendOverlayMessage(
                Component.literal("Core disabled.").withStyle(ChatFormatting.RED),
            )
            return InteractionResult.SUCCESS
        }

        if (!state.getValue(ACTIVE)) {
            level.setBlockAndUpdate(pos, state.setValue(ACTIVE, true))
            level.scheduleTick(pos, this, 20)
            return InteractionResult.SUCCESS
        } else if (state.getValue(ACTIVE)) {
            level.setBlockAndUpdate(pos, state.setValue(ACTIVE, false))
            return InteractionResult.SUCCESS
        }

        return InteractionResult.PASS
    }

    abstract fun performTreeEffect(level: ServerLevel, pos: BlockPos, rand: RandomSource)

    abstract fun doesCoreFunction(): Boolean

    protected open fun playSound(level: Level, pos: BlockPos, rand: RandomSource) {}

    companion object {
        val ACTIVE = BooleanProperty.create("active")
    }
}