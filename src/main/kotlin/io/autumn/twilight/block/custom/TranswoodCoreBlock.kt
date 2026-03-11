package io.autumn.twilight.block.custom

import io.autumn.twilight.bootstrap.TwilightBiomes
import io.autumn.twilight.sound.TwilightSounds
import net.minecraft.core.BlockPos
import net.minecraft.core.Holder
import net.minecraft.core.QuartPos
import net.minecraft.resources.ResourceKey
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.util.Mth
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.chunk.LevelChunk
import net.minecraft.world.level.chunk.PalettedContainer

class TranswoodCoreBlock(properties: Properties) : MagicLogCoreBlock(properties) {

    override fun performTreeEffect(level: ServerLevel, pos: BlockPos, rand: RandomSource) {
        val target: ResourceKey<Biome> = TwilightBiomes.ENCHANTED_FOREST
        val biome: Holder<Biome> = level.registryAccess().getOrThrow(target)
        val range = 16

        repeat(16) {
            val dPos = randomOffset(rand, pos, range, 0, range)
            if (dPos.distSqr(pos) > 256.0) return@repeat
            if (level.getBiome(dPos).`is`(target)) return@repeat

            val minY = QuartPos.fromBlock(level.minY)
            val maxY = minY + QuartPos.fromBlock(level.height) - 1

            val x = QuartPos.fromBlock(dPos.x)
            val z = QuartPos.fromBlock(dPos.z)

            val chunkAt: LevelChunk = level.getChunk(dPos.x shr 4, dPos.z shr 4)
            for (section in chunkAt.sections) {
                for (sy in 0 until 16 step 4) {
                    val y = Mth.clamp(QuartPos.fromBlock(chunkAt.minY + sy), minY, maxY)
                    if (section.biomes.get(x and 3, y and 3, z and 3).`is`(target)) continue
                    if (section.biomes is PalettedContainer<*>) {
                        val container = section.biomes as PalettedContainer<Holder<Biome>>
                        container.set(x and 3, y and 3, z and 3, biome)
                    }
                }
            }

            chunkAt.markUnsaved()
            level.chunkSource.chunkMap.resendBiomesForChunks(listOf(chunkAt))
            return
        }
    }

    override fun doesCoreFunction(): Boolean = true

    override fun playSound(level: Level, pos: BlockPos, rand: RandomSource) {
        level.playSound(
            null,
            pos,
            TwilightSounds.TRANSWOOD_CORE_ACTIVE,
            SoundSource.BLOCKS,
            0.1F,
            rand.nextFloat() * 2.0F
        )
    }

    private fun randomOffset(random: RandomSource, pos: BlockPos, rx: Int, ry: Int, rz: Int): BlockPos {
        val dx = random.nextInt(rx * 2 + 1) - rx
        val dy = random.nextInt(ry * 2 + 1) - ry
        val dz = random.nextInt(rz * 2 + 1) - rz
        return pos.offset(dx, dy, dz)
    }
}