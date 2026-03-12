package io.autumn.twilight.particle

import io.autumn.torchberry.annotations.OnInitializeClient
import io.autumn.twilight.Twilight
import io.autumn.twilight.particle.custom.FireflyParticle
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry

object TwilightParticlesClient {
    @OnInitializeClient
    fun initialize() {
        Twilight.LOGGER?.info("Registering particle providers for ${Twilight.NAMESPACE}.")
        ParticleProviderRegistry.getInstance().register(TwilightParticles.FIREFLY_PARTICLE, FireflyParticle::StationaryProvider)
    }
}