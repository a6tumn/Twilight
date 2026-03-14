package io.autumn.twilight.providers

import io.autumn.carminite.tool.ToolSet
import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.lists.TwilightItemTags
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.item.TwilightItems
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider
import net.minecraft.core.HolderLookup
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class EnglishLangProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricLanguageProvider(output, "en_us", registriesFuture) {
    override fun generateTranslations(registryLookup: HolderLookup.Provider, translationBuilder: TranslationBuilder) {
        translationBuilder.add(TwilightBlocks.ROOT_BLOCK, "Root Block")
        translationBuilder.add(TwilightBlocks.LIVEROOT_BLOCK, "Liveroot Block")
        translationBuilder.add(TwilightBlocks.CORONATION_CARPET_CRUDE, "Coronation Carpet")
        translationBuilder.add(TwilightBlocks.HEDGE, "Hedge")
        translationBuilder.add(TwilightBlocks.FIDDLEHEAD, "Fiddlehead")
        translationBuilder.add(TwilightBlocks.POTTED_FIDDLEHEAD, "Potted Fiddlehead")
        translationBuilder.add(TwilightBlocks.MUSHGLOOM, "Mushgloom")
        translationBuilder.add(TwilightBlocks.POTTED_MUSHGLOOM, "Potted Mushgloom")
        translationBuilder.add(TwilightBlocks.MAYAPPLE, "Mayapple")
        translationBuilder.add(TwilightBlocks.POTTED_MAYAPPLE, "Potted Mayapple")
        translationBuilder.add(TwilightBlocks.FIREFLY, "Firefly")
        translationBuilder.add(TwilightBlocks.CICADA, "Cicada")

        createWoodSetTranslations(translationBuilder,  TwilightBlocks.TWILIGHT_OAK_SET, TwilightBlocks.TWILIGHT_OAK_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST)
        translationBuilder.add(TwilightBlocks.RAINBOW_OAK_LEAVES, "Rainbow Oak Leaves")
        translationBuilder.add(TwilightBlocks.RAINBOW_OAK_SAPLING, "Rainbow Oak Sapling")
        createWoodSetTranslations(translationBuilder,  TwilightBlocks.CANOPY_SET, TwilightBlocks.CANOPY_CHEST, TwilightBlocks.TRAPPED_CANOPY_CHEST)
        createWoodSetTranslations(translationBuilder, TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightBlocks.TWILIGHT_MANGROVE_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST)
        translationBuilder.add(TwilightBlocks.TWILIGHT_MANGROVE_ROOT, "Twilight Mangrove Root")
        createWoodSetTranslations(translationBuilder,  TwilightBlocks.DARKWOOD_SET, TwilightBlocks.DARKWOOD_CHEST, TwilightBlocks.TRAPPED_DARKWOOD_CHEST)
        createWoodSetTranslations(translationBuilder, TwilightBlocks.TIMEWOOD_SET, TwilightBlocks.TIMEWOOD_CHEST, TwilightBlocks.TRAPPED_TIMEWOOD_CHEST)
        translationBuilder.add(TwilightBlocks.TIMEWOOD_CORE, "Timewood Core")
        createWoodSetTranslations(translationBuilder,  TwilightBlocks.TRANSWOOD_SET, TwilightBlocks.TRANSWOOD_CHEST, TwilightBlocks.TRAPPED_TRANSWOOD_CHEST)
        translationBuilder.add(TwilightBlocks.TRANSWOOD_CORE, "Transwood Core")
        createWoodSetTranslations(translationBuilder,  TwilightBlocks.MINEWOOD_SET, TwilightBlocks.MINEWOOD_CHEST, TwilightBlocks.TRAPPED_MINEWOOD_CHEST)
        translationBuilder.add(TwilightBlocks.MINEWOOD_CORE, "Minewood Core")
        createWoodSetTranslations(translationBuilder,  TwilightBlocks.SORTWOOD_SET, TwilightBlocks.SORTWOOD_CHEST, TwilightBlocks.TRAPPED_SORTWOOD_CHEST)
        translationBuilder.add(TwilightBlocks.SORTWOOD_CORE, "Sortwood Core")

        translationBuilder.add(TwilightItems.RAVEN_FEATHER, "Raven Feather")
        translationBuilder.add(TwilightItems.TOWER_KEY, "Tower Key")
        translationBuilder.add(TwilightItems.BORER_ESSENCE, "Borer Essence")
        translationBuilder.add(TwilightItems.CARMINITE, "Carminite")
        translationBuilder.add(TwilightItems.NAGA_SCALE, "Naga Scale")
        translationBuilder.add(TwilightItems.LIVEROOT, "Liveroot")
        translationBuilder.add(TwilightItems.RAW_IRONWOOD, "Raw Ironwood")
        translationBuilder.add(TwilightItems.IRONWOOD_INGOT, "Ironwood Ingot")
        translationBuilder.add(TwilightItems.STEELEAF_INGOT, "Steeleaf Ingot")
        translationBuilder.add(TwilightItems.FIERY_BLOOD, "Fiery Blood")
        translationBuilder.add(TwilightItems.FIERY_TEARS, "Fiery Tears")
        translationBuilder.add(TwilightItems.FIERY_INGOT, "Fiery Ingot")
        translationBuilder.add(TwilightItems.ARMOR_SHARD, "Armor Shard")
        translationBuilder.add(TwilightItems.ARMOR_SHARD_CLUSTER, "Armor Shard Cluster")
        translationBuilder.add(TwilightItems.KNIGHTMETAL_INGOT, "Knightmetal Ingot")
        translationBuilder.add(TwilightItems.ARCTIC_FUR, "Arctic Fur")
        translationBuilder.add(TwilightItems.ALPHA_YETI_FUR, "Alpha Yeti Fur")
        createToolSetTranslations(translationBuilder, TwilightItems.IRONWOOD_SET)

        translationBuilder.add(TwilightItemTags.TWILIGHT_OAK_LOGS_ITEM_TAG, "Twilight Oak Logs")
        translationBuilder.add(TwilightItemTags.CANOPY_LOGS_ITEM_TAG, "Canopy Logs")
        translationBuilder.add(TwilightItemTags.TWILIGHT_MANGROVE_LOGS_ITEM_TAG, "Twilight Mangrove Logs")
        translationBuilder.add(TwilightItemTags.DARKWOOD_LOGS_ITEM_TAG, "Darkwood Logs")
        translationBuilder.add(TwilightItemTags.TIMEWOOD_LOGS_ITEM_TAG, "Timewood Logs")
        translationBuilder.add(TwilightItemTags.TRANSWOOD_LOGS_ITEM_TAG, "Transwood Logs")
        translationBuilder.add(TwilightItemTags.MINEWOOD_LOGS_ITEM_TAG, "Minewood Logs")
        translationBuilder.add(TwilightItemTags.SORTWOOD_LOGS_ITEM_TAG, "Sortwood Logs")
        translationBuilder.add(TwilightItemTags.IRONWOOD_TOOL_MATERIALS, "Ironwood Tool Materials")
    }

    private fun createToolSetTranslations(translationBuilder: TranslationBuilder, toolSet: ToolSet) {
        toolSet.mapOfToolsToTypes.forEach { (type, item) ->
            item?.let { it: Item ->
                val displayName = "${toolSet.setName} ${type.langSuffix}"
                translationBuilder.add(it, displayName)
            }
        }
    }

    private fun createWoodSetTranslations(translationBuilder: TranslationBuilder, woodSet: WoodSet, chestBlock: Block, trappedChestBlock: Block) {
        translationBuilder.add(woodSet.log, "${woodSet.woodName} Log")
        translationBuilder.add(woodSet.strippedLog, "Stripped ${woodSet.woodName} Log")
        translationBuilder.add(woodSet.wood, "${woodSet.woodName} Wood")
        translationBuilder.add(woodSet.strippedWood, "Stripped ${woodSet.woodName} Wood")
        translationBuilder.add(woodSet.leaves, "${woodSet.woodName} Leaves")
        translationBuilder.add(woodSet.sapling, "${woodSet.woodName} Sapling")
        translationBuilder.add(woodSet.planks, "${woodSet.woodName} Planks")
        translationBuilder.add(woodSet.door, "${woodSet.woodName} Door")
        translationBuilder.add(woodSet.trapdoor, "${woodSet.woodName} Trapdoor")
        translationBuilder.add(woodSet.fence, "${woodSet.woodName} Fence")
        translationBuilder.add(woodSet.fenceGate, "${woodSet.woodName} Fence Gate")
        translationBuilder.add(woodSet.stairs, "${woodSet.woodName} Stairs")
        translationBuilder.add(woodSet.slab, "${woodSet.woodName} Slab")
        translationBuilder.add(woodSet.button, "${woodSet.woodName} Button")
        translationBuilder.add(woodSet.pressurePlate, "${woodSet.woodName} Pressure Plate")
        translationBuilder.add(woodSet.signItem, "${woodSet.woodName} Sign")
        translationBuilder.add(woodSet.hangingSignItem, "${woodSet.woodName} Hanging Sign")
        translationBuilder.add(chestBlock, "${woodSet.woodName} Chest")
        translationBuilder.add(trappedChestBlock, "Trapped ${woodSet.woodName} Chest")
    }
}