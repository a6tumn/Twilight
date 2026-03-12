package io.autumn.twilight.particle.custom

import io.autumn.twilight.block.custom.FireflyBlock
import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.Particle
import net.minecraft.client.particle.ParticleProvider
import net.minecraft.client.particle.SingleQuadParticle
import net.minecraft.client.particle.SpriteSet
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.core.BlockPos
import net.minecraft.core.particles.SimpleParticleType
import net.minecraft.util.Mth
import net.minecraft.util.RandomSource

class FireflyParticle(level: ClientLevel, x: Double, y: Double, z: Double, xa: Double, ya: Double, za: Double, sprite: TextureAtlasSprite) : SingleQuadParticle(level, x, y, z, xa, ya, za, sprite) {
    override fun getLayer(): Layer = Layer.TRANSLUCENT

    override fun tick() {
        super.tick()

        val blockState = level.getBlockState(BlockPos.containing(x, y, z))
        if (!blockState.isAir && blockState.block !is FireflyBlock) {
            remove()
            return
        }

        setAlpha(getFadeAmount(getLifetimeProgress(age.toFloat()), 0.2f, 0.5f))

        if (random.nextFloat() > 0.95f || age == 1) {
            xd += (-0.02..0.02).random(random)
            yd += (-0.01..0.02).random(random) // gentle upward bias
            zd += (-0.02..0.02).random(random)
        }

        xd = xd.coerceIn(-0.05, 0.05)
        yd = yd.coerceIn(-0.03, 0.05)
        zd = zd.coerceIn(-0.05, 0.05)
    }

    private fun getLifetimeProgress(currentAge: Float): Float = Mth.clamp(currentAge / lifetime.toFloat(), 0.0f, 1.0f)

    private fun getFadeAmount(lifetimeProgress: Float, fadeInTime: Float, fadeOutTime: Float): Float {
        return when {
            lifetimeProgress < fadeInTime -> lifetimeProgress / fadeInTime
            lifetimeProgress > 1.0f - fadeOutTime -> (1.0f - lifetimeProgress) / fadeOutTime
            else -> 1.0f
        }
    }

    class StationaryProvider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(options: SimpleParticleType, level: ClientLevel, x: Double, y: Double, z: Double, xAux: Double, yAux: Double, zAux: Double, random: RandomSource): Particle {
            val tex = sprite[random]
            val particle = FireflyParticle(level, x, y, z, 0.0, 0.0, 0.0, tex)
            particle.setSprite(tex)
            particle.setLifetime(random.nextInt(200, 300))
            return particle
        }
    }

    class WanderingProvider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(type: SimpleParticleType, level: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double, random: RandomSource): Particle {
            val tex = sprite[random]
            val particle = FireflyParticle(level, x, y, z, 0.0, 0.01, 0.0, tex)
            particle.setSprite(tex)
            particle.setLifetime(random.nextInt(200, 300))
            return particle
        }
    }

    class ParticleSpawnerProvider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(type: SimpleParticleType, level: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double, random: RandomSource): Particle {
            val tex = sprite[random]
            val particle = FireflyParticle(level, x, y, z, 0.0, 0.01, 0.0, tex)
            particle.setSprite(tex)
            particle.setLifetime(random.nextInt(200, 300))
            return particle
        }
    }
}

private fun ClosedFloatingPointRange<Double>.random(random: RandomSource): Double = start + (endInclusive - start) * random.nextDouble()