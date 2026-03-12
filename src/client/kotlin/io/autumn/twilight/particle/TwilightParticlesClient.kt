package io.autumn.twilight.particle

import io.autumn.carminite.registry.registerGenericParticleProvider
import io.autumn.torchberry.annotations.OnInitializeClient
import io.autumn.twilight.Twilight
import io.autumn.twilight.particle.custom.FireflyParticle

object TwilightParticlesClient {
    @OnInitializeClient
    fun initialize() {
        Twilight.LOGGER?.info("Registering particle providers for ${Twilight.NAMESPACE}.")
        registerGenericParticleProvider(TwilightParticles.FIREFLY_PARTICLE, FireflyParticle::WanderingProvider)
    }
}