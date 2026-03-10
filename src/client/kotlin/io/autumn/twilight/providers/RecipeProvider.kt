package io.autumn.twilight.providers

import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.lists.TwilightItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.tags.TagKey
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import java.util.concurrent.CompletableFuture

class RecipeProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(output, registriesFuture) {
    override fun createRecipeProvider(registryLookup: HolderLookup.Provider, exporter: RecipeOutput): RecipeProvider {
        return object : RecipeProvider(registryLookup, exporter) {
            override fun buildRecipes() {
                val itemLookup: HolderLookup.RegistryLookup<Item> = registries.lookupOrThrow(Registries.ITEM)

                createWoodSetRecipes(TwilightBlocks.TWILIGHT_OAK_SET, TwilightItemTags.TWILIGHT_OAK_LOGS_ITEM_TAG, TwilightBlocks.TWILIGHT_OAK_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST)
                createWoodSetRecipes(TwilightBlocks.CANOPY_SET, TwilightItemTags.CANOPY_LOGS_ITEM_TAG, TwilightBlocks.CANOPY_CHEST, TwilightBlocks.TRAPPED_CANOPY_CHEST)
                createWoodSetRecipes(TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightItemTags.TWILIGHT_MANGROVE_LOGS_ITEM_TAG, TwilightBlocks.TWILIGHT_MANGROVE_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST)
                createWoodSetRecipes(TwilightBlocks.DARKWOOD_SET, TwilightItemTags.DARKWOOD_LOGS_ITEM_TAG, TwilightBlocks.DARKWOOD_CHEST, TwilightBlocks.TRAPPED_DARKWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.TIMEWOOD_SET, TwilightItemTags.TIMEWOOD_LOGS_ITEM_TAG, TwilightBlocks.TIMEWOOD_CHEST, TwilightBlocks.TRAPPED_TIMEWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.TRANSWOOD_SET, TwilightItemTags.TRANSWOOD_LOGS_ITEM_TAG, TwilightBlocks.TRANSWOOD_CHEST, TwilightBlocks.TRAPPED_TRANSWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.MINEWOOD_SET, TwilightItemTags.MINEWOOD_LOGS_ITEM_TAG, TwilightBlocks.MINEWOOD_CHEST, TwilightBlocks.TRAPPED_MINEWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.SORTWOOD_SET, TwilightItemTags.SORTWOOD_LOGS_ITEM_TAG, TwilightBlocks.SORTWOOD_CHEST, TwilightBlocks.TRAPPED_SORTWOOD_CHEST)
            }

            private fun createWoodSetRecipes(woodSet: WoodSet, logTag: TagKey<Item>, chestBlock: Block, trappedChestBlock: Block) {
                planksFromLog(woodSet.planks, logTag, 4)
                woodFromLogs(woodSet.wood, woodSet.log)
                woodFromLogs(woodSet.strippedWood, woodSet.strippedLog)
                hangingSign(woodSet.hangingSignItem, woodSet.strippedLog)
                generateRecipes(woodSet.blockFamily, FeatureFlags.REGISTRY.allFlags())
                shaped(RecipeCategory.DECORATIONS, chestBlock)
                    .pattern("ppp")
                    .pattern("pcp")
                    .pattern("ppp")
                    .define('p', woodSet.planks)
                    .define('c', Blocks.CHEST)
                    .unlockedBy(getHasName(woodSet.planks), has(woodSet.planks))
                    .save(exporter)
                shaped(RecipeCategory.REDSTONE, trappedChestBlock)
                    .pattern("ppp")
                    .pattern("ptp")
                    .pattern("ppp")
                    .define('p', woodSet.planks)
                    .define('t', Blocks.TRAPPED_CHEST)
                    .unlockedBy(getHasName(woodSet.planks), has(woodSet.planks))
            }
        }
    }

    override fun getName(): String = "RecipeProvider"
}