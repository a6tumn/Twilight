package io.autumn.twilight.blockentity

import io.autumn.carminite.registry.registerGenericBlockEntityType
import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.blockentity.custom.TwilightChestBlockEntity
import io.autumn.twilight.blockentity.custom.TwilightTrappedChestBlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType

object TwilightBlockEntityTypes {

    val TWILIGHT_CHEST: BlockEntityType<TwilightChestBlockEntity> = registerGenericBlockEntityType(Twilight.namespaceAndPath("twilight_chest"), ::TwilightChestBlockEntity,
        TwilightBlocks.TWILIGHT_OAK_CHEST,
        TwilightBlocks.CANOPY_CHEST,
        TwilightBlocks.TWILIGHT_MANGROVE_CHEST,
        TwilightBlocks.DARKWOOD_CHEST,
        TwilightBlocks.TIMEWOOD_CHEST,
        TwilightBlocks.TRANSWOOD_CHEST,
        TwilightBlocks.MINEWOOD_CHEST,
        TwilightBlocks.SORTWOOD_CHEST
    )

    val TWILIGHT_TRAPPED_CHEST: BlockEntityType<TwilightTrappedChestBlockEntity> = registerGenericBlockEntityType(Twilight.namespaceAndPath("trapped_twilight_chest"), ::TwilightTrappedChestBlockEntity,
        TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST,
        TwilightBlocks.TRAPPED_CANOPY_CHEST,
        TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST,
        TwilightBlocks.TRAPPED_DARKWOOD_CHEST,
        TwilightBlocks.TRAPPED_TIMEWOOD_CHEST,
        TwilightBlocks.TRAPPED_TRANSWOOD_CHEST,
        TwilightBlocks.TRAPPED_MINEWOOD_CHEST,
        TwilightBlocks.TRAPPED_SORTWOOD_CHEST
    )

    private fun addValidBlocks() {
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.TWILIGHT_OAK_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.CANOPY_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_CANOPY_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.TWILIGHT_MANGROVE_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.DARKWOOD_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_DARKWOOD_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.TIMEWOOD_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_TIMEWOOD_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.TRANSWOOD_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_TRANSWOOD_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.MINEWOOD_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_MINEWOOD_CHEST)
        TWILIGHT_CHEST.addValidBlock(TwilightBlocks.SORTWOOD_CHEST)
        TWILIGHT_TRAPPED_CHEST.addValidBlock(TwilightBlocks.TRAPPED_SORTWOOD_CHEST)
    }

    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering block entity types for ${Twilight.NAMESPACE}.")
        addValidBlocks()
    }
}