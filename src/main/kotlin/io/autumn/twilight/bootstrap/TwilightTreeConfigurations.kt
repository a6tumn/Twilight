package io.autumn.twilight.bootstrap

import io.autumn.twilight.Twilight
import io.autumn.carminite.tree.decorators.TreeRootsDecorator
import io.autumn.carminite.tree.trunkplacers.*
import io.autumn.carminite.tree.trunkplacers.config.*
import io.autumn.carminite.tree.foliageplacers.*
import io.autumn.twilight.block.TwilightBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.data.worldgen.features.FeatureUtils
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.util.random.WeightedList
import net.minecraft.util.valueproviders.ConstantInt
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer
import java.util.OptionalInt
import kotlin.math.pow
import kotlin.math.sqrt

object TwilightTreeConfigurations {
    val TWILIGHT_OAK: ResourceKey<ConfiguredFeature<*, *>> = createKey("twilight_oak")
    val FANCY_TWILIGHT_OAK: ResourceKey<ConfiguredFeature<*, *>> = createKey("fancy_twilight_oak")
    val RAINBOW_OAK: ResourceKey<ConfiguredFeature<*, *>> = createKey("rainbow_oak")
    val FANCY_RAINBOW_OAK: ResourceKey<ConfiguredFeature<*, *>> = createKey("fancy_rainbow_oak")
    val CANOPY: ResourceKey<ConfiguredFeature<*, *>> = createKey("canopy")
    val TWILIGHT_MANGROVE: ResourceKey<ConfiguredFeature<*, *>> = createKey("twilight_mangrove")
    val DARKWOOD: ResourceKey<ConfiguredFeature<*, *>> = createKey("darkwood")
    val TIMEWOOD: ResourceKey<ConfiguredFeature<*, *>> = createKey("timewood")

    private fun createStraightBlobTree(oakLog: Block, oakLeaves: Block, baseHeight: Int, heightRandA: Int, heightRandB: Int, blobRadius: Int): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(oakLog),
            StraightTrunkPlacer(baseHeight, heightRandA, heightRandB),
            BlockStateProvider.simple(oakLeaves),
            BlobFoliagePlacer(
                ConstantInt.of(blobRadius),
                ConstantInt.of(0),
                3
            ),
            TwoLayersFeatureSize(1, 0, 1)
        )

    private fun createTwilightOak(): TreeConfiguration.TreeConfigurationBuilder =
        createStraightBlobTree(
            TwilightBlocks.TWILIGHT_OAK_SET.log,
            TwilightBlocks.TWILIGHT_OAK_SET.leaves,
            4, 2, 0, 2
        ).ignoreVines()

    private fun createFancyTwilightOak(): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.TWILIGHT_OAK_SET.log),
            FancyTrunkPlacer(3, 11, 0),
            BlockStateProvider.simple(TwilightBlocks.TWILIGHT_OAK_SET.leaves),
            FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
            TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).ignoreVines()

    private fun createRainbowOak(): TreeConfiguration.TreeConfigurationBuilder =
        createStraightBlobTree(
            TwilightBlocks.TWILIGHT_OAK_SET.log,
            TwilightBlocks.RAINBOW_OAK_LEAVES,
            4, 2, 0, 2
        ).ignoreVines()

    private fun createFancyRainbowOak(): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.TWILIGHT_OAK_SET.log),
            FancyTrunkPlacer(3, 11, 0),
            BlockStateProvider.simple(TwilightBlocks.RAINBOW_OAK_LEAVES),
            FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
            TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).ignoreVines()

    private fun createCanopy(): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.CANOPY_SET.log),
            BranchingTrunkPlacer(
                20, 5, 5, 12,
                BranchesConfig(BlockStateProvider.simple(TwilightBlocks.CANOPY_SET.wood), 3, 1, 10.0, 1.0, 0.3, 0.2),
                perpendicularBranches = false,
                preventExposedRoot = true
            ),
            BlockStateProvider.simple(TwilightBlocks.CANOPY_SET.leaves),
            LeafSpheroidFoliagePlacer(
                sqrt(4.0.pow(2) + 1.0.pow(2)).toFloat(),
                1.5f,
                ConstantInt.of(0),
                0,
                0,
                -0.2f,
                24
            ),
            TwoLayersFeatureSize(20, 0, 5)
        ).decorators(listOf(
            TreeRootsDecorator(
                3,
                1,
                5,
                WeightedStateProvider(
                    WeightedList.builder<BlockState>().add(TwilightBlocks.ROOT_BLOCK.defaultBlockState(), 6)
                        .add(TwilightBlocks.LIVEROOT_BLOCK.defaultBlockState(), 1).build()
                ),
                1
            )
        )
        ).ignoreVines()

    private fun createTwilightMangrove(): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.TWILIGHT_MANGROVE_SET.log),
            TrunkRiser(
                4, 7, 4, 0, BranchingTrunkPlacer(
                    7, 4, 0, 6,
                    BranchesConfig(
                        BlockStateProvider.simple(TwilightBlocks.TWILIGHT_MANGROVE_SET.wood),
                        0,
                        3,
                        6.0,
                        2.0,
                        0.3,
                        0.25
                    ),
                    perpendicularBranches = false,
                    preventExposedRoot = false
                )
            ),
            BlockStateProvider.simple(TwilightBlocks.TWILIGHT_MANGROVE_SET.leaves),
            LeafSpheroidFoliagePlacer(2.5f, 1.5f, ConstantInt.of(0), 2, 0, -0.25f, (24 * 0.666f).toInt()),
            TwoLayersFeatureSize(4, 1, 1)
        ).decorators(
            listOf(
                TreeRootsDecorator(
                    3,
                    1,
                    12,
                    0,
                    BlockStateProvider.simple(TwilightBlocks.TWILIGHT_MANGROVE_ROOT.defaultBlockState()),
                    WeightedStateProvider(
                        WeightedList.builder<BlockState>().add(TwilightBlocks.ROOT_BLOCK.defaultBlockState(), 4)
                            .add(TwilightBlocks.LIVEROOT_BLOCK.defaultBlockState(), 1).build()
                    ),
                    1
                ), LeaveVineDecorator(0.125F)
            )
        )

    private fun createDarkWood(): TreeConfiguration.TreeConfigurationBuilder =
        TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.DARKWOOD_SET.log),
            BranchingTrunkPlacer(
                9,
                1,
                1,
                6,
                BranchesConfig(
                    BlockStateProvider.simple(TwilightBlocks.DARKWOOD_SET.wood),
                    4,
                    0,
                    8.0,
                    2.0,
                    0.23,
                    0.23
                ),
                perpendicularBranches = false,
                preventExposedRoot = false
            ),
            BlockStateProvider.simple(TwilightBlocks.DARKWOOD_SET.leaves),
            LeafSpheroidFoliagePlacer(4.5f, 2.25f, ConstantInt.of(0), 1, 0, 0.45f, (24 * 1.5f).toInt()),
            TwoLayersFeatureSize(4, 1, 1)
        ).decorators(
            listOf(
                TreeRootsDecorator(
                    3,
                    1,
                    5,
                    WeightedStateProvider(
                        WeightedList.builder<BlockState>().add(TwilightBlocks.ROOT_BLOCK.defaultBlockState(), 6)
                            .add(TwilightBlocks.LIVEROOT_BLOCK.defaultBlockState(), 1).build()
                    ),
                    1
                )
            )
        )

    //Try creating smaller and more distinct leaf clusters
    private fun createTimeWood(): TreeConfiguration.TreeConfigurationBuilder {
        return TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(TwilightBlocks.TIMEWOOD_SET.log),
            MegaTrunkPlacer(
                10,
                1,
                1,
                7,
                BranchesConfig(
                    BlockStateProvider.simple(TwilightBlocks.TIMEWOOD_SET.wood),
                    6,
                    1,
                    5.0,
                    1.0,
                    0.3,
                    0.2
                ),
                perpendicularBranches = false,
                preventExposedRoot = false
            ),
            BlockStateProvider.simple(TwilightBlocks.TIMEWOOD_SET.leaves),
            LeafSpheroidFoliagePlacer(2.5f, 2.5f, ConstantInt.of(0), 2, 4, 0f, (24 * 1.5f).toInt()),
            TwoLayersFeatureSize(4, 1, 1)
        ).decorators(
            listOf(
                TreeRootsDecorator(
                    3,
                    1,
                    3,
                    BlockStateProvider.simple(TwilightBlocks.ROOT_BLOCK.defaultBlockState()),
                    1
                )
            )
        )
    }

    private fun createKey(name: String): ResourceKey<ConfiguredFeature<*, *>> = ResourceKey.create(
        Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(
            Twilight.NAMESPACE, name))

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
        FeatureUtils.register(context, TWILIGHT_OAK, Feature.TREE, createTwilightOak().build())
        FeatureUtils.register(context, FANCY_TWILIGHT_OAK, Feature.TREE, createFancyTwilightOak().build())
        FeatureUtils.register(context, RAINBOW_OAK, Feature.TREE, createRainbowOak().build())
        FeatureUtils.register(context, FANCY_RAINBOW_OAK, Feature.TREE, createFancyRainbowOak().build())
        FeatureUtils.register(context, CANOPY, Feature.TREE, createCanopy().build())
        FeatureUtils.register(context, TWILIGHT_MANGROVE, Feature.TREE, createTwilightMangrove().build())
        FeatureUtils.register(context, DARKWOOD, Feature.TREE, createDarkWood().build())
        FeatureUtils.register(context, TIMEWOOD, Feature.TREE, createTimeWood().build())
    }
}