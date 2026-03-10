package io.autumn.twilight.item

import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight

object TwilightItems {

    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering items for ${Twilight.NAMESPACE}.")
    }
}