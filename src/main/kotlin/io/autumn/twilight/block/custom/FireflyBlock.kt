package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import io.autumn.twilight.particle.TwilightParticles
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.IntegerProperty

class FireflyBlock(properties: Properties) : CritterBlock(properties) {
    companion object {
        val LIGHT: IntegerProperty = IntegerProperty.create("light", 0, 15)
        val PATTERN = intArrayOf(1, 8, 12, 8, 1, 8, 12, 8)
        val CODEC = simpleCodec(::FireflyBlock)
    }

    override fun codec(): MapCodec<out Block?> = CODEC

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        super.createBlockStateDefinition(builder)
        builder.add(LIGHT)
    }

    override fun onPlace(state: BlockState, level: Level, pos: BlockPos, oldState: BlockState, movedByPiston: Boolean) {
        super.onPlace(state, level, pos, oldState, movedByPiston)
        level.scheduleTick(pos, this, 5)
    }

    override fun tick(state: BlockState, level: ServerLevel, pos: BlockPos, random: RandomSource) {
        val frameIndex = ((level.gameTime / 5) % PATTERN.size).toInt()
        val targetLight = PATTERN[frameIndex]
        val currentLight = state.getValue(LIGHT)
        val newLight = (currentLight + ((targetLight - currentLight) / 2)).coerceIn(0, 15)

        if (state.getValue(LIGHT) != newLight) {
            level.setBlock(pos, state.setValue(LIGHT, newLight), UPDATE_CLIENTS)
        }

        level.scheduleTick(pos, this, 5)
    }

    override fun animateTick(state: BlockState, level: Level, pos: BlockPos, random: RandomSource) {
        if(level.isClientSide) {
            if(anyPlayerInRange(level, pos) && random.nextInt(20) == 0) {
                spawnParticles(level, pos)
            }
        }
    }

    private fun anyPlayerInRange(level: Level, pos: BlockPos): Boolean {
        return level.hasNearbyAlivePlayer(
            pos.x + 0.5,
            pos.y + 0.5,
            pos.z + 0.5,
            16.0
        )
    }

    private fun spawnParticles(level: Level, pos: BlockPos) {
        val rx = pos.x + level.random.nextFloat()
        val ry = pos.y + level.random.nextFloat()
        val rz = pos.z + level.random.nextFloat()

        level.addParticle(TwilightParticles.FIREFLY_PARTICLE, rx.toDouble(), ry.toDouble(), rz.toDouble(), 0.0, 0.0, 0.0)
    }

    init {
        registerDefaultState(stateDefinition.any()
            .setValue(LIGHT, 0)
        )
    }
}