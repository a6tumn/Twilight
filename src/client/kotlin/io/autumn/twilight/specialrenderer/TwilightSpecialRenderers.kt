package io.autumn.twilight.specialrenderer

import io.autumn.torchberry.annotations.OnInitializeClient
import io.autumn.twilight.Twilight
import io.autumn.twilight.specialrenderer.custom.LocklessChestSpecialRenderer
import net.minecraft.client.renderer.special.SpecialModelRenderers

object TwilightSpecialRenderers {
    init {
        SpecialModelRenderers.ID_MAPPER.put(Twilight.namespaceAndPath("lockless_chest"), LocklessChestSpecialRenderer.Unbaked.MAP_CODEC)
    }

    @OnInitializeClient
    fun initialize() {
        Twilight.LOGGER?.info("Registering special renderers for ${Twilight.NAMESPACE}.")
    }
}