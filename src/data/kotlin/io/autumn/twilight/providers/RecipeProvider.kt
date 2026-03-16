package io.autumn.twilight.providers

import io.autumn.carminite.datagen.createToolSetRecipes
import io.autumn.carminite.datagen.createWoodSetRecipes
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.item.TwilightItems
import io.autumn.twilight.lists.TwilightBlockFamilies
import io.autumn.twilight.lists.TwilightItemTags
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.CookingBookCategory
import java.util.concurrent.CompletableFuture

class RecipeProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(output, registriesFuture) {
    override fun createRecipeProvider(registryLookup: HolderLookup.Provider, exporter: RecipeOutput): RecipeProvider {
        return object : RecipeProvider(registryLookup, exporter) {
            override fun buildRecipes() {
                createWoodSetRecipes(TwilightBlocks.TWILIGHT_OAK_SET, TwilightBlockFamilies.TWILIGHT_OAK.blockFamily, TwilightItemTags.TWILIGHT_OAK_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.CANOPY_SET,TwilightBlockFamilies.CANOPY.blockFamily, TwilightItemTags.CANOPY_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightBlockFamilies.TWILIGHT_MANGROVE.blockFamily,TwilightItemTags.TWILIGHT_MANGROVE_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.DARKWOOD_SET, TwilightBlockFamilies.DARKWOOD.blockFamily,TwilightItemTags.DARKWOOD_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.TIMEWOOD_SET, TwilightBlockFamilies.TIMEWOOD.blockFamily,TwilightItemTags.TIMEWOOD_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.TRANSWOOD_SET,TwilightBlockFamilies.TRANSWOOD.blockFamily, TwilightItemTags.TRANSWOOD_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.MINEWOOD_SET, TwilightBlockFamilies.MINEWOOD.blockFamily,TwilightItemTags.MINEWOOD_LOGS_ITEM_TAG.tagKey)
                createWoodSetRecipes(TwilightBlocks.SORTWOOD_SET, TwilightBlockFamilies.SORTWOOD.blockFamily,TwilightItemTags.SORTWOOD_LOGS_ITEM_TAG.tagKey)
                createToolSetRecipes(TwilightItems.IRONWOOD_TOOL_SET, TwilightItemTags.IRONWOOD_TOOL_MATERIALS.tagKey, exporter)
                createToolSetRecipes(TwilightItems.STEELEAF_TOOL_SET, TwilightItemTags.STEELEAF_TOOL_MATERIALS.tagKey, exporter)
                createToolSetRecipes(TwilightItems.KNIGHTMETAL_TOOL_SET, TwilightItemTags.KNIGHTMETAL_TOOL_MATERIALS.tagKey, exporter)
                createToolSetRecipes(TwilightItems.FIERY_TOOL_SET, TwilightItemTags.FIERY_TOOL_MATERIALS.tagKey, exporter)

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
                    .define('f', TwilightItemTags.FIERY_VIALS.tagKey)
                    .define('i', Items.IRON_INGOT)
                    .unlockedBy("has_fiery_blood", has(TwilightItems.FIERY_BLOOD))
                    .save(exporter)

                nineBlockStorageRecipesWithCustomPacking(RecipeCategory.MISC, TwilightItems.ARMOR_SHARD, RecipeCategory.MISC, TwilightItems.ARMOR_SHARD_CLUSTER, "armor_shard_cluster_from_nuggets", "armor_shard_cluster")
            }
        }
    }

    override fun getName(): String = "RecipeProvider"
}