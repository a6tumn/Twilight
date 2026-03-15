package io.autumn.twilight.providers

import io.autumn.carminite.datagen.providers.CarminiteRecipeProvider
import io.autumn.carminite.datagen.providers.sub.CarminiteRecipeSubProvider
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.item.TwilightItems
import io.autumn.twilight.lists.TwilightItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.CookingBookCategory
import java.util.concurrent.CompletableFuture

class RecipeProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : CarminiteRecipeProvider(output, registriesFuture) {
    override fun createRecipeProvider(registryLookup: HolderLookup.Provider, exporter: RecipeOutput): RecipeProvider {
        return object : CarminiteRecipeSubProvider(registryLookup, exporter, this) {
            override fun buildRecipes() {
                createWoodSetRecipes(TwilightBlocks.TWILIGHT_OAK_SET, TwilightItemTags.TWILIGHT_OAK_LOGS_ITEM_TAG, TwilightBlocks.TWILIGHT_OAK_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST)
                createWoodSetRecipes(TwilightBlocks.CANOPY_SET, TwilightItemTags.CANOPY_LOGS_ITEM_TAG, TwilightBlocks.CANOPY_CHEST, TwilightBlocks.TRAPPED_CANOPY_CHEST)
                createWoodSetRecipes(TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightItemTags.TWILIGHT_MANGROVE_LOGS_ITEM_TAG, TwilightBlocks.TWILIGHT_MANGROVE_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST)
                createWoodSetRecipes(TwilightBlocks.DARKWOOD_SET, TwilightItemTags.DARKWOOD_LOGS_ITEM_TAG, TwilightBlocks.DARKWOOD_CHEST, TwilightBlocks.TRAPPED_DARKWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.TIMEWOOD_SET, TwilightItemTags.TIMEWOOD_LOGS_ITEM_TAG, TwilightBlocks.TIMEWOOD_CHEST, TwilightBlocks.TRAPPED_TIMEWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.TRANSWOOD_SET, TwilightItemTags.TRANSWOOD_LOGS_ITEM_TAG, TwilightBlocks.TRANSWOOD_CHEST, TwilightBlocks.TRAPPED_TRANSWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.MINEWOOD_SET, TwilightItemTags.MINEWOOD_LOGS_ITEM_TAG, TwilightBlocks.MINEWOOD_CHEST, TwilightBlocks.TRAPPED_MINEWOOD_CHEST)
                createWoodSetRecipes(TwilightBlocks.SORTWOOD_SET, TwilightItemTags.SORTWOOD_LOGS_ITEM_TAG, TwilightBlocks.SORTWOOD_CHEST, TwilightBlocks.TRAPPED_SORTWOOD_CHEST)
                createToolSetRecipes(TwilightItems.IRONWOOD_SET, TwilightItemTags.IRONWOOD_TOOL_MATERIALS)

                shaped(RecipeCategory.MISC, TwilightItems.RAW_IRONWOOD)
                    .pattern("lg")
                    .pattern("r ")
                    .define('l', TwilightItems.LIVEROOT)
                    .define('g', Items.GOLD_NUGGET)
                    .define('r', Items.RAW_IRON)
                    .unlockedBy("has_liveroot", has(TwilightItems.LIVEROOT))
                    .save(exporter)
                oreSmelting(listOf(TwilightItems.RAW_IRONWOOD), RecipeCategory.MISC, CookingBookCategory.MISC, TwilightItems.IRONWOOD_INGOT, 0.7f, 200, "ironwood_ingot")
                oreBlasting(listOf(TwilightItems.RAW_IRONWOOD), RecipeCategory.MISC, CookingBookCategory.MISC, TwilightItems.IRONWOOD_INGOT, 0.7f, 100, "ironwood_ingot")

                shaped(RecipeCategory.MISC, TwilightItems.FIERY_INGOT)
                    .pattern("fi")
                    .define('f', TwilightItemTags.FIERY_VIALS)
                    .define('i', Items.IRON_INGOT)
                    .unlockedBy("has_fiery_blood", has(TwilightItems.FIERY_BLOOD))
                    .save(exporter)


                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, TwilightItems.ARMOR_SHARD, RecipeCategory.MISC, TwilightItems.ARMOR_SHARD_CLUSTER, "armor_shard_cluster_from_nuggets", "armor_shard_cluster")
            }
        }
    }

    override fun getName(): String = "RecipeProvider"
}