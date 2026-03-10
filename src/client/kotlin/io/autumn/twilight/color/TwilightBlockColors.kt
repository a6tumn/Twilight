package io.autumn.twilight.color

import io.autumn.carminite.registry.registerGenericBlockColor
import io.autumn.torchberry.annotations.OnInitializeClient
import io.autumn.twilight.Twilight
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.color.blocktintsource.TwilightBlockTintSources
import net.minecraft.client.color.block.BlockTintSources

object TwilightBlockColors {
    init {
        registerGenericBlockColor(listOf(TwilightBlockTintSources.rainbowFoliage()), TwilightBlocks.RAINBOW_OAK_LEAVES)
        registerGenericBlockColor(listOf(BlockTintSources.foliage()), TwilightBlocks.TWILIGHT_OAK_SET.leaves, TwilightBlocks.DARKWOOD_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.canopyFoliage()), TwilightBlocks.CANOPY_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.mangroveFoliage()), TwilightBlocks.TWILIGHT_MANGROVE_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.timewoodFoliage()), TwilightBlocks.TIMEWOOD_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.transwoodFoliage()), TwilightBlocks.TRANSWOOD_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.minewoodFoliage()), TwilightBlocks.MINEWOOD_SET.leaves)
        registerGenericBlockColor(listOf(TwilightBlockTintSources.sortwoodFoliage()), TwilightBlocks.SORTWOOD_SET.leaves)
    }

    @OnInitializeClient
    fun initialize() {
        Twilight.LOGGER?.info("Registering block colors for ${Twilight.NAMESPACE}.")
    }
}