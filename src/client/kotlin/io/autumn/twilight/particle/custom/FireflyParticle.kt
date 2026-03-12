package io.autumn.twilight.particle.custom

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

        if (!level.getBlockState(BlockPos.containing(x, y, z)).isAir) {
            remove()
        } else {
            setAlpha(getFadeAmount(getLifetimeProgress(age.toFloat()), 0.3f, 0.5f))

            if (random.nextFloat() > 0.95f || age == 1) {
                setParticleSpeed(
                    (-0.05f + 0.1f * random.nextFloat()).toDouble(),
                    (-0.05f + 0.1f * random.nextFloat()).toDouble(),
                    (-0.05f + 0.1f * random.nextFloat()).toDouble()
                )
            }
        }
    }

    private fun getLifetimeProgress(currentAge: Float): Float = Mth.clamp(currentAge / lifetime.toFloat(), 0.0f, 1.0f)

    private fun getFadeAmount(lifetimeProgress: Float, fadeInTime: Float, fadeOutTime: Float): Float {
        return if (lifetimeProgress >= 1.0f - fadeInTime) {
            (1.0f - lifetimeProgress) / fadeInTime
        } else {
            if (lifetimeProgress <= fadeOutTime) lifetimeProgress / fadeOutTime else 1.0f
        }
    }

    class StationaryProvider(private val sprite: SpriteSet): ParticleProvider<SimpleParticleType> {
        override fun createParticle(options: SimpleParticleType, level: ClientLevel, x: Double, y: Double, z: Double, xAux: Double, yAux: Double, zAux: Double, random: RandomSource): Particle? {
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
            val particle = FireflyParticle(level, x, y, z, 0.1, 0.1, 0.1, tex)
            val rand = level.random

            particle.xd += rand.nextFloat() * (if (rand.nextBoolean()) -3.9 else 3.9) * rand.nextFloat() * 0.1
            particle.yd += rand.nextFloat() * -0.25 * rand.nextFloat() * 0.1
            particle.zd += rand.nextFloat() * (if (rand.nextBoolean()) -3.9 else 3.9) * rand.nextFloat() * 0.1

            particle.setSprite(tex)
            particle.setLifetime(rand.nextInt(200, 300))
            return particle
        }
    }

    class ParticleSpawnerProvider(private val sprite: SpriteSet) : ParticleProvider<SimpleParticleType> {
        override fun createParticle(type: SimpleParticleType, level: ClientLevel, x: Double, y: Double, z: Double, xSpeed: Double, ySpeed: Double, zSpeed: Double, random: RandomSource): Particle {
            val tex = sprite[random]
            val particle = FireflyParticle(level, x, y, z, 0.1, 0.1, 0.1, tex)
            val rand = level.random

            particle.xd += rand.nextFloat() * (if (rand.nextBoolean()) -3.9 else 3.9) * rand.nextFloat() * 0.1
            particle.yd += rand.nextFloat() * -0.25 * rand.nextFloat() * 0.1
            particle.zd += rand.nextFloat() * (if (rand.nextBoolean()) -3.9 else 3.9) * rand.nextFloat() * 0.1

            particle.setSprite(tex)
            particle.setLifetime(rand.nextInt(200, 300))
            return particle
        }
    }
}