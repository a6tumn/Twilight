package io.autumn.twilight.blockentityrenderer.custom.state

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState
import net.minecraft.core.Direction
import net.minecraft.world.level.block.state.properties.ChestType

class TwilightChestRenderState: BlockEntityRenderState() {
    var type: ChestType = ChestType.SINGLE
    var open: Float = 0.0f
    var facing: Direction = Direction.SOUTH
    var material: TwilightChestMaterialType = TwilightChestMaterialType.TWILIGHT_OAK

    enum class TwilightChestMaterialType {
        TWILIGHT_OAK,
        TRAPPED_TWILIGHT_OAK,
        CANOPY,
        TRAPPED_CANOPY,
        TWILIGHT_MANGROVE,
        TRAPPED_TWILIGHT_MANGROVE,
        DARKWOOD,
        TRAPPED_DARKWOOD,
        TIMEWOOD,
        TRAPPED_TIMEWOOD,
        TRANSWOOD,
        TRAPPED_TRANSWOOD,
        MINEWOOD,
        TRAPPED_MINEWOOD,
        SORTWOOD,
        TRAPPED_SORTWOOD
    }
}