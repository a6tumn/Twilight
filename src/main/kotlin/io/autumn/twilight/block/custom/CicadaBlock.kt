package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import io.autumn.twilight.sound.TwilightSounds
import net.minecraft.core.BlockPos
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import kotlin.math.abs

class CicadaBlock(properties: Properties) : CritterBlock(properties) {
    companion object {
        val CODEC = simpleCodec(::CicadaBlock)
    }

    override fun codec(): MapCodec<out Block?> = CODEC

    override fun randomTick(state: BlockState, level: ServerLevel, pos: BlockPos, random: RandomSource) {
        val worldTime = level.gameTime

        val baseDelay = 100 + Math.floorMod(pos.asLong(), 100)

        val offset = abs(pos.asLong()) % 400
        val cycleTick = (worldTime + offset) % 400

        if (cycleTick >= baseDelay && cycleTick <= baseDelay + 50) {
            playSounds(level, pos)
        }
    }

    override fun animateTick(state: BlockState, level: Level, pos: BlockPos, random: RandomSource) {
        if(level.isClientSide) {
            if(anyPlayerInRange(level, pos) && random.nextInt(15) == 0) {
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

        level.addParticle(ParticleTypes.NOTE, rx.toDouble(), ry.toDouble(), rz.toDouble(), 0.0, 0.0, 0.0)
    }

    private fun playSounds(level: Level, pos: BlockPos) {
        level.playSound(null, pos, TwilightSounds.CICADA_AMBIENT, SoundSource.AMBIENT, 1.0f, level.random.nextFloat() - level.random.nextFloat()* 0.2f + 1.0f)
    }
}