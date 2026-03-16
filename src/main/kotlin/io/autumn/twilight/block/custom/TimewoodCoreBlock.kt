package io.autumn.twilight.block.custom

import io.autumn.twilight.lists.TwilightBlockTags
import io.autumn.twilight.sound.TwilightSounds
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState

class TimewoodCoreBlock(properties: Properties) : MagicLogCoreBlock(properties) {

    @Suppress("UNCHECKED_CAST")
    override fun performTreeEffect(level: ServerLevel, pos: BlockPos, rand: RandomSource) {
        val numTicks = 480

        for (i in 0 until numTicks) {
            val dPos = randomOffset(rand, pos, 16)
            val state: BlockState = level.getBlockState(dPos)

            if (!state.`is`(TwilightBlockTags.TIMEWOOD_CORE_EXCLUDED.tagKey)) {

                if (state.isRandomlyTicking) {
                    state.randomTick(level, dPos, rand)
                }

                val entity: BlockEntity? = level.getBlockEntity(dPos)

                if (entity != null) {
                    val ticker = state.getTicker(
                        level,
                        entity.type as BlockEntityType<BlockEntity>
                    )

                    ticker?.tick(level, dPos, state, entity)
                }
            }
        }
    }

    override fun doesCoreFunction(): Boolean = true

    override fun playSound(level: Level, pos: BlockPos, rand: RandomSource) {
        level.playSound(
            null,
            pos,
            TwilightSounds.TIMEWOOD_CORE_ACTIVE,
            SoundSource.BLOCKS,
            0.35f,
            0.5f
        )
    }

    private fun randomOffset(random: RandomSource, pos: BlockPos, rx: Int, ry: Int, rz: Int): BlockPos {
        val dx = random.nextInt(rx * 2 + 1) - rx
        val dy = random.nextInt(ry * 2 + 1) - ry
        val dz = random.nextInt(rz * 2 + 1) - rz
        return pos.offset(dx, dy, dz)
    }

    private fun randomOffset(random: RandomSource, pos: BlockPos, range: Int): BlockPos = randomOffset(random, pos, range, range, range)
}