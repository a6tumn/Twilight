package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.fabricmc.fabric.api.`object`.builder.v1.block.type.WoodTypeBuilder
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.state.properties.BlockSetType
import net.minecraft.world.level.block.state.properties.WoodType

enum class TwilightWoodTypes(
    val woodType: WoodType
) {
    TWILIGHT_OAK(createWoodType1("twilight_oak", TwilightBlockSetTypes.entries[0].blockSetType)),
    CANOPY(createWoodType("canopy", TwilightBlockSetTypes.entries[1].blockSetType)),
    TWILIGHT_MANGROVE(createWoodType("twilight_mangrove", TwilightBlockSetTypes.entries[2].blockSetType)),
    DARKWOOD(createWoodType("darkwood", TwilightBlockSetTypes.entries[3].blockSetType)),
    TIMEWOOD(createWoodType("timewood", TwilightBlockSetTypes.entries[4].blockSetType)),
    TRANSWOOD(createWoodType("transwood", TwilightBlockSetTypes.entries[5].blockSetType)),
    MINEWOOD(createWoodType("minewood", TwilightBlockSetTypes.entries[6].blockSetType)),
    SORTWOOD(createWoodType("sortwood", TwilightBlockSetTypes.entries[7].blockSetType));
}

private fun createWoodType(path: String, blockSetType: BlockSetType): WoodType = WoodTypeBuilder.copyOf(WoodType.OAK).build(Identifier.fromNamespaceAndPath(Twilight.NAMESPACE, path), blockSetType)

private fun createWoodType1(path: String, blockSetType: BlockSetType): WoodType = WoodTypeBuilder.copyOf(WoodType.OAK).register(Identifier.fromNamespaceAndPath(Twilight.NAMESPACE, path), blockSetType)
