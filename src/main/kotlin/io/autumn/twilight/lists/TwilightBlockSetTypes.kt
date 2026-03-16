package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.fabricmc.fabric.api.`object`.builder.v1.block.type.BlockSetTypeBuilder
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.state.properties.BlockSetType

enum class TwilightBlockSetTypes(
    val blockSetType: BlockSetType,
) {
    TWILIGHT_OAK(createBlockSetType("twilight_oak")),
    CANOPY(createBlockSetType("canopy")),
    TWILIGHT_MANGROVE(createBlockSetType("twilight_mangrove")),
    DARKWOOD(createBlockSetType("darkwood")),
    TIMEWOOD(createBlockSetType("timewood")),
    TRANSWOOD(createBlockSetType("transwood")),
    MINEWOOD(createBlockSetType("minewood")),
    SORTWOOD(createBlockSetType("sortwood"));
}

private fun createBlockSetType(path: String): BlockSetType = BlockSetTypeBuilder.copyOf(BlockSetType.OAK).register(Identifier.fromNamespaceAndPath(Twilight.NAMESPACE, path))