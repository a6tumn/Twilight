package io.autumn.twilight.bootstrap

import io.autumn.twilight.Twilight
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import java.util.Optional

object TwilightBiomes {
    val CLEARING: ResourceKey<Biome> = createKey("clearing")
    val DARK_FOREST: ResourceKey<Biome> = createKey("dark_forest")
    val DARK_FOREST_CENTER: ResourceKey<Biome> = createKey("dark_forest_center")
    val DENSE_FOREST: ResourceKey<Biome> = createKey("dense_forest")
    val DENSE_MUSHROOM_FOREST: ResourceKey<Biome> = createKey("dense_mushroom_forest")
    val ENCHANTED_FOREST: ResourceKey<Biome> = createKey("enchanted_forest")
    val FINAL_PLATEAU: ResourceKey<Biome> = createKey("final_plateau")
    val FIRE_SWAMP: ResourceKey<Biome> = createKey("fire_swamp")
    val FIREFLY_FOREST: ResourceKey<Biome> = createKey("firefly_forest")
    val FOREST: ResourceKey<Biome> = createKey("forest")
    val GLACIER: ResourceKey<Biome> = createKey("glacier")
    val HIGHLANDS: ResourceKey<Biome> = createKey("highlands")
    val HIGHLANDS_UNDERGROUND: ResourceKey<Biome> = createKey("highlands_underground")
    val LAKE: ResourceKey<Biome> = createKey("lake")
    val MUSHROOM_FOREST: ResourceKey<Biome> = createKey("mushroom_forest")
    val OAK_SAVANNAH: ResourceKey<Biome> = createKey("oak_savannah")
    val SNOWY_FOREST: ResourceKey<Biome> = createKey("snowy_forest")
    val SPOOKY_FOREST: ResourceKey<Biome> = createKey("spooky_forest")
    val STREAM: ResourceKey<Biome> = createKey("stream")
    val SWAMP: ResourceKey<Biome> = createKey("swamp")
    val THORNLANDS: ResourceKey<Biome> = createKey("thornlands")
    val UNDERGROUND: ResourceKey<Biome> = createKey("underground")

    private fun createClearing(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.8f)
            .downfall(0.4f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createDarkForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.7f)
            .downfall(0.8f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.05f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.of(3890751),
                    Optional.empty(),
                    Optional.of(4941652),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createDarkForestCenter(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.5f)
            .downfall(0.5f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.05f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.of(16351774),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createDenseForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.7f)
            .downfall(0.8f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    21794,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createDenseMushroomForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.8f)
            .downfall(1f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createEnchantedForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.5f)
            .downfall(0.5f)
            .hasPrecipitation(false)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.of(65535),
                    Optional.empty(),
                    Optional.of(65535),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createFinalPlateau(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(1f)
            .downfall(0.2f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.3f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createFireSwamp(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(1f)
            .downfall(0.4f)
            .hasPrecipitation(false)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    7089196,
                    Optional.of(6563343),
                    Optional.empty(),
                    Optional.of(5713443),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createFireflyForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.5f)
            .downfall(1f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.5f)
            .downfall(0.5f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createGlacier(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.08f)
            .downfall(0.1f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createHighlands(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.4f)
            .downfall(0.7f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createHighlandsUnderground(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.35f)
            .downfall(0f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createLake(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.66f)
            .downfall(1f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createMushroomForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.8f)
            .downfall(0.8f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createOakSavannah(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.9f)
            .downfall(0f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createSnowyForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.09f)
            .downfall(0.9f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.FROZEN)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.of(16777215),
                    Optional.empty(),
                    Optional.of(16777215),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createSpookyForest(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.09f)
            .downfall(0.9f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    12355671,
                    Optional.of(116745729),
                    Optional.empty(),
                    Optional.of(112865827),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createStream(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.5f)
            .downfall(0.1f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createSwamp(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.8f)
            .downfall(0.9f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    9811295,
                    Optional.of(4809015),
                    Optional.empty(),
                    Optional.of(6056270),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createThornlands(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.3f)
            .downfall(0.2f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())

    private fun createUnderground(placedFeatures: HolderGetter<PlacedFeature>, carvers: HolderGetter<ConfiguredWorldCarver<*>>): Biome.BiomeBuilder =
        Biome.BiomeBuilder()
            .temperature(0.7f)
            .downfall(0f)
            .hasPrecipitation(true)
            .temperatureAdjustment(Biome.TemperatureModifier.NONE)
            .mobSpawnSettings(
                MobSpawnSettings.Builder()
                .creatureGenerationProbability(0.15f)
                .build())
            .specialEffects(
                BiomeSpecialEffects(
                    4159204,
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    BiomeSpecialEffects.GrassColorModifier.NONE
                )
            )
            .generationSettings(
                BiomeGenerationSettings.Builder(placedFeatures, carvers)
                .build())


    private fun createKey(name: String): ResourceKey<Biome> = ResourceKey.create(
        Registries.BIOME, Identifier.fromNamespaceAndPath(
            Twilight.NAMESPACE, name))

    fun bootstrap(context: BootstrapContext<Biome>) {
        val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
        val carvers = context.lookup(Registries.CONFIGURED_CARVER)

        context.register(CLEARING, createClearing(placedFeatures, carvers).build())
        context.register(DARK_FOREST, createDarkForest(placedFeatures, carvers).build())
        context.register(DARK_FOREST_CENTER, createDarkForestCenter(placedFeatures, carvers).build())
        context.register(DENSE_FOREST, createDenseForest(placedFeatures, carvers).build())
        context.register(DENSE_MUSHROOM_FOREST, createDenseMushroomForest(placedFeatures, carvers).build())
        context.register(ENCHANTED_FOREST, createEnchantedForest(placedFeatures, carvers).build())
        context.register(FINAL_PLATEAU, createFinalPlateau(placedFeatures, carvers).build())
        context.register(FIRE_SWAMP, createFireSwamp(placedFeatures, carvers).build())
        context.register(FIREFLY_FOREST, createFireflyForest(placedFeatures, carvers).build())
        context.register(FOREST, createForest(placedFeatures, carvers).build())
        context.register(GLACIER, createGlacier(placedFeatures, carvers).build())
        context.register(HIGHLANDS, createHighlands(placedFeatures, carvers).build())
        context.register(HIGHLANDS_UNDERGROUND, createHighlandsUnderground(placedFeatures, carvers).build())
        context.register(LAKE, createLake(placedFeatures, carvers).build())
        context.register(MUSHROOM_FOREST, createMushroomForest(placedFeatures, carvers).build())
        context.register(OAK_SAVANNAH, createOakSavannah(placedFeatures, carvers).build())
        context.register(SNOWY_FOREST, createSnowyForest(placedFeatures, carvers).build())
        context.register(SPOOKY_FOREST, createSpookyForest(placedFeatures, carvers).build())
        context.register(STREAM, createStream(placedFeatures, carvers).build())
        context.register(SWAMP, createSwamp(placedFeatures, carvers).build())
        context.register(THORNLANDS, createThornlands(placedFeatures, carvers).build())
        context.register(UNDERGROUND, createUnderground(placedFeatures, carvers).build())
    }
}