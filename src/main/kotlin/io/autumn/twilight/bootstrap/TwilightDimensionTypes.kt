package io.autumn.twilight.bootstrap

import io.autumn.twilight.Twilight
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BlockTags
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.attribute.EnvironmentAttributeMap
import net.minecraft.world.level.CardinalLighting
import net.minecraft.world.level.dimension.DimensionType
import java.util.Optional

object TwilightDimensionTypes {
    val TWILIGHT_FOREST_TYPE: ResourceKey<DimensionType> = createKey("twilight_forest_type")

    fun createTwilightForest(): DimensionType = DimensionType(
        true,
        true,
        false,
        false,
        0.125,
        -32,
        288,
        288,
        BlockTags.INFINIBURN_OVERWORLD,
        0.01f,
        DimensionType.MonsterSettings(
            UniformInt.of(0, 7),
            7
        ),
        DimensionType.Skybox.OVERWORLD,
        CardinalLighting.Type.DEFAULT,
        EnvironmentAttributeMap.EMPTY,
        HolderSet.empty(),
        Optional.empty()
    )

    private fun createKey(name: String): ResourceKey<DimensionType> = ResourceKey.create(
        Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(
            Twilight.NAMESPACE, name))

    fun bootstrap(context: BootstrapContext<DimensionType>) {
        context.register(TWILIGHT_FOREST_TYPE, createTwilightForest())
    }
}