package io.autumn.twilight.lists

import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.block.TwilightBlocks
import net.minecraft.data.BlockFamily

enum class TwilightBlockFamilies(
    val blockFamily: BlockFamily
) {
    TWILIGHT_OAK(createGenericWoodenBlockFamily(TwilightBlocks.TWILIGHT_OAK_SET)),
    CANOPY(createGenericWoodenBlockFamily(TwilightBlocks.CANOPY_SET)),
    TWILIGHT_MANGROVE(createGenericWoodenBlockFamily(TwilightBlocks.TWILIGHT_MANGROVE_SET)),
    DARKWOOD(createGenericWoodenBlockFamily(TwilightBlocks.DARKWOOD_SET)),
    TIMEWOOD(createGenericWoodenBlockFamily(TwilightBlocks.TIMEWOOD_SET)),
    TRANSWOOD(createGenericWoodenBlockFamily(TwilightBlocks.TRANSWOOD_SET)),
    MINEWOOD(createGenericWoodenBlockFamily(TwilightBlocks.MINEWOOD_SET)),
    SORTWOOD(createGenericWoodenBlockFamily(TwilightBlocks.SORTWOOD_SET));
}

private fun createGenericWoodenBlockFamily(woodSet: WoodSet): BlockFamily {
    return BlockFamily.Builder(woodSet.planks)
        .door(woodSet.door)
        .trapdoor(woodSet.trapdoor)
        .fence(woodSet.fence)
        .fenceGate(woodSet.fenceGate)
        .stairs(woodSet.stairs)
        .slab(woodSet.slab)
        .button(woodSet.button)
        .pressurePlate(woodSet.pressurePlate)
        .sign(woodSet.standingSign, woodSet.wallSign)
        .recipeGroupPrefix("wooden")
        .recipeUnlockedBy("has_planks")
        .family
}