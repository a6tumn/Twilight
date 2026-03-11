package io.autumn.twilight.providers

import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.block.TwilightBlocks
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider
import net.minecraft.core.HolderLookup
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class BlockLootTableProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricBlockLootSubProvider(output, registriesFuture) {
    override fun generate() {

        createWoodSetDrops(TwilightBlocks.TWILIGHT_OAK_SET, TwilightBlocks.TWILIGHT_OAK_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST)
        createLeavesDrops(TwilightBlocks.RAINBOW_OAK_LEAVES, TwilightBlocks.RAINBOW_OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES[0])
        dropSelf(TwilightBlocks.RAINBOW_OAK_SAPLING)
        createWoodSetDrops(TwilightBlocks.CANOPY_SET, TwilightBlocks.CANOPY_CHEST, TwilightBlocks.TRAPPED_CANOPY_CHEST)
        createWoodSetDrops(TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightBlocks.TWILIGHT_MANGROVE_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST)
        dropSelf(TwilightBlocks.TWILIGHT_MANGROVE_ROOT)
        createWoodSetDrops(TwilightBlocks.DARKWOOD_SET, TwilightBlocks.DARKWOOD_CHEST, TwilightBlocks.TRAPPED_DARKWOOD_CHEST)
        createWoodSetDrops(TwilightBlocks.TIMEWOOD_SET, TwilightBlocks.TIMEWOOD_CHEST, TwilightBlocks.TRAPPED_TIMEWOOD_CHEST)
        dropOther(TwilightBlocks.TIMEWOOD_CORE, TwilightBlocks.TIMEWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.TRANSWOOD_SET, TwilightBlocks.TRANSWOOD_CHEST, TwilightBlocks.TRAPPED_TRANSWOOD_CHEST)
        dropOther(TwilightBlocks.TRANSWOOD_CORE, TwilightBlocks.TRANSWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.MINEWOOD_SET, TwilightBlocks.MINEWOOD_CHEST, TwilightBlocks.TRAPPED_MINEWOOD_CHEST)
        dropOther(TwilightBlocks.MINEWOOD_CORE, TwilightBlocks.MINEWOOD_SET.log)
        createWoodSetDrops(TwilightBlocks.SORTWOOD_SET, TwilightBlocks.SORTWOOD_CHEST, TwilightBlocks.TRAPPED_SORTWOOD_CHEST)
        dropOther(TwilightBlocks.SORTWOOD_CORE, TwilightBlocks.SORTWOOD_SET.log)
    }

    private fun createWoodSetDrops(woodSet: WoodSet, chestBlock: Block, trappedChestBlock: Block) {
        dropSelf(woodSet.log)
        dropSelf(woodSet.strippedLog)
        dropSelf(woodSet.wood)
        dropSelf(woodSet.strippedWood)
        createLeavesDrops(woodSet.leaves, woodSet.sapling, NORMAL_LEAVES_SAPLING_CHANCES[0])
        dropSelf(woodSet.sapling)
        dropSelf(woodSet.planks)
        dropSelf(woodSet.door)
        dropSelf(woodSet.trapdoor)
        dropSelf(woodSet.fence)
        dropSelf(woodSet.fenceGate)
        dropSelf(woodSet.stairs)
        dropSelf(woodSet.slab)
        dropSelf(woodSet.button)
        dropSelf(woodSet.pressurePlate)
        dropSelf(woodSet.standingSign)
        dropSelf(woodSet.wallSign)
        dropSelf(woodSet.hangingSign)
        dropSelf(woodSet.wallHangingSign)
        dropSelf(chestBlock)
        dropSelf(trappedChestBlock)
    }
}