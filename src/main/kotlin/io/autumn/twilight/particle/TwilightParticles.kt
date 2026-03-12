package io.autumn.twilight.particle

import io.autumn.carminite.registry.registerGenericParticle
import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes

object TwilightParticles{
    val FIREFLY_PARTICLE =
        registerGenericParticle(Twilight.namespaceAndPath("firefly_particle"), FabricParticleTypes.simple())

    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering particles for ${Twilight.NAMESPACE}.")
    }
}