package io.autumn.twilight.sound

import io.autumn.carminite.registry.registerGenericSoundEvent
import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight

object TwilightSounds {
    val TIMEWOOD_CORE_ACTIVE = registerGenericSoundEvent(Twilight.namespaceAndPath("timewood_core_active"))
    val TRANSWOOD_CORE_ACTIVE = registerGenericSoundEvent(Twilight.namespaceAndPath("transwood_core_active"))
    val MINEWOOD_CORE_ACTIVE = registerGenericSoundEvent(Twilight.namespaceAndPath("minewood_core_active"))
    val SORTWOOD_CORE_ACTIVE = registerGenericSoundEvent(Twilight.namespaceAndPath("sortwood_core_active"))

    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering sounds for ${Twilight.NAMESPACE}.")
    }
}