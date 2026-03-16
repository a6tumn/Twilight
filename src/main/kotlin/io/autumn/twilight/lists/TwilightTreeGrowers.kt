package io.autumn.twilight.lists

import io.autumn.twilight.bootstrap.TwilightTreeConfigurations
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.grower.TreeGrower
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import java.util.Optional

enum class TwilightTreeGrowers(
    val treeGrower: TreeGrower
) {
    TWILIGHT_OAK(createTreeGrower("twilight_oak", tree = Optional.of(TwilightTreeConfigurations.TWILIGHT_OAK), secondaryTree = Optional.of(TwilightTreeConfigurations.FANCY_TWILIGHT_OAK))),
    RAINBOW_OAK(createTreeGrower("rainbow_oak", tree = Optional.of(TwilightTreeConfigurations.RAINBOW_OAK), secondaryTree = Optional.of(TwilightTreeConfigurations.FANCY_RAINBOW_OAK))),
    CANOPY(createTreeGrower("canopy", tree = Optional.of(TwilightTreeConfigurations.CANOPY))),
    TWILIGHT_MANGROVE(createTreeGrower("twilight_mangrove", tree = Optional.of(TwilightTreeConfigurations.TWILIGHT_MANGROVE))),
    DARKWOOD(createTreeGrower("darkwood", tree = Optional.of(TwilightTreeConfigurations.DARKWOOD))),
    TIMEWOOD(createTreeGrower("timewood", tree = Optional.of(TwilightTreeConfigurations.TIMEWOOD))),
    TRANSWOOD(createTreeGrower("transwood", tree = Optional.of(TwilightTreeConfigurations.TRANSWOOD))),
    MINEWOOD(createTreeGrower("minewood", tree = Optional.of(TwilightTreeConfigurations.MINEWOOD))),
    SORTWOOD(createTreeGrower("sortwood", tree = Optional.of(TwilightTreeConfigurations.SORTWOOD)));
}

private fun createTreeGrower(
    name: String,
    secondaryChance: Float = 0.1f,
    megaTree: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty(),
    secondaryMegaTree: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty(),
    tree: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty(),
    secondaryTree: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty(),
    flowers: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty(),
    secondaryFlowers: Optional<ResourceKey<ConfiguredFeature<*, *>>> = Optional.empty()
): TreeGrower =
    TreeGrower(name, secondaryChance, megaTree, secondaryMegaTree, tree, secondaryTree, flowers, secondaryFlowers)
