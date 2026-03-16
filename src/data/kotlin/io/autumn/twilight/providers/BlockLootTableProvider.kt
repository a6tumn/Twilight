package io.autumn.twilight.providers

import io.autumn.carminite.datagen.createWoodSetDrops
import io.autumn.twilight.block.TwilightBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricBlockLootSubProvider(output, registriesFuture) {
    override fun generate() {
        createWoodSetDrops(TwilightBlocks.TWILIGHT_OAK_SET)
        createLeavesDrops(TwilightBlocks.RAINBOW_OAK_LEAVES, TwilightBlocks.RAINBOW_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES[0])
        dropSelf(TwilightBlocks.RAINBOW_OAK_SAPLING)
        createWoodSetDrops(TwilightBlocks.CANOPY_SET)
        createWoodSetDrops(TwilightBlocks.TWILIGHT_MANGROVE_SET)
        dropSelf(TwilightBlocks.TWILIGHT_MANGROVE_ROOT)
        createWoodSetDrops(TwilightBlocks.DARKWOOD_SET)
        createWoodSetDrops(TwilightBlocks.TIMEWOOD_SET)
        dropOther(TwilightBlocks.TIMEWOOD_CORE, TwilightBlocks.TIMEWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.TRANSWOOD_SET)
        dropOther(TwilightBlocks.TRANSWOOD_CORE, TwilightBlocks.TRANSWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.MINEWOOD_SET)
        dropOther(TwilightBlocks.MINEWOOD_CORE, TwilightBlocks.MINEWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.SORTWOOD_SET)
        dropOther(TwilightBlocks.SORTWOOD_CORE, TwilightBlocks.SORTWOOD_SET.log)

        dropSelf(TwilightBlocks.CORONATION_CARPET_CRUDE)
        dropSelf(TwilightBlocks.HEDGE)
        dropSelf(TwilightBlocks.FIDDLEHEAD)
        dropSelf(TwilightBlocks.MUSHGLOOM)
        dropSelf(TwilightBlocks.MAYAPPLE)
        dropSelf(TwilightBlocks.FIREFLY)
        dropSelf(TwilightBlocks.CICADA)
    }
}