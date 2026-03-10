package io.autumn.twilight.blockentityrenderer

import io.autumn.carminite.registry.registerGenericBlockEntityRenderer
import io.autumn.torchberry.annotations.OnInitializeClient
import io.autumn.twilight.Twilight
import io.autumn.twilight.blockentity.TwilightBlockEntityTypes
import io.autumn.twilight.blockentityrenderer.custom.TwilightChestRenderer

object TwilightBlockEntityRenderers {
    init {
        registerGenericBlockEntityRenderer(TwilightBlockEntityTypes.TWILIGHT_CHEST, ::TwilightChestRenderer)
        registerGenericBlockEntityRenderer(TwilightBlockEntityTypes.TWILIGHT_TRAPPED_CHEST, ::TwilightChestRenderer)
    }

    @OnInitializeClient
    fun initialize() {
        Twilight.LOGGER?.info("Registering block entity renderers for ${Twilight.NAMESPACE}.")
    }
}