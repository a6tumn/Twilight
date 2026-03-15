package io.autumn.twilight.providers

import io.autumn.carminite.tool.ToolSet
import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.lists.TwilightItemTags
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.item.TwilightItems
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import java.util.concurrent.CompletableFuture

class ItemTagsProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricTagsProvider.ItemTagsProvider(output, registriesFuture) {
    override fun addTags(p0: HolderLookup.Provider) {
        createWoodSetItemTags(TwilightBlocks.TWILIGHT_OAK_SET)
        createWoodSetItemTags(TwilightBlocks.CANOPY_SET)
        createWoodSetItemTags(TwilightBlocks.TWILIGHT_MANGROVE_SET)
        createWoodSetItemTags(TwilightBlocks.DARKWOOD_SET)
        createWoodSetItemTags(TwilightBlocks.TIMEWOOD_SET)
        createWoodSetItemTags(TwilightBlocks.TRANSWOOD_SET)
        createWoodSetItemTags(TwilightBlocks.MINEWOOD_SET)
        createWoodSetItemTags(TwilightBlocks.SORTWOOD_SET)

        valueLookupBuilder(TwilightItemTags.TWILIGHT_OAK_LOGS_ITEM_TAG)
            .add(TwilightBlocks.TWILIGHT_OAK_SET.log.asItem())
            .add(TwilightBlocks.TWILIGHT_OAK_SET.strippedLog.asItem())
            .add(TwilightBlocks.TWILIGHT_OAK_SET.wood.asItem())
            .add(TwilightBlocks.TWILIGHT_OAK_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.CANOPY_LOGS_ITEM_TAG)
            .add(TwilightBlocks.CANOPY_SET.log.asItem())
            .add(TwilightBlocks.CANOPY_SET.strippedLog.asItem())
            .add(TwilightBlocks.CANOPY_SET.wood.asItem())
            .add(TwilightBlocks.CANOPY_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.TWILIGHT_MANGROVE_LOGS_ITEM_TAG)
            .add(TwilightBlocks.TWILIGHT_MANGROVE_SET.log.asItem())
            .add(TwilightBlocks.TWILIGHT_MANGROVE_SET.strippedLog.asItem())
            .add(TwilightBlocks.TWILIGHT_MANGROVE_SET.wood.asItem())
            .add(TwilightBlocks.TWILIGHT_MANGROVE_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.DARKWOOD_LOGS_ITEM_TAG)
            .add(TwilightBlocks.DARKWOOD_SET.log.asItem())
            .add(TwilightBlocks.DARKWOOD_SET.strippedLog.asItem())
            .add(TwilightBlocks.DARKWOOD_SET.wood.asItem())
            .add(TwilightBlocks.DARKWOOD_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.TIMEWOOD_LOGS_ITEM_TAG)
            .add(TwilightBlocks.TIMEWOOD_SET.log.asItem())
            .add(TwilightBlocks.TIMEWOOD_SET.strippedLog.asItem())
            .add(TwilightBlocks.TIMEWOOD_SET.wood.asItem())
            .add(TwilightBlocks.TIMEWOOD_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.TRANSWOOD_LOGS_ITEM_TAG)
            .add(TwilightBlocks.TRANSWOOD_SET.log.asItem())
            .add(TwilightBlocks.TRANSWOOD_SET.strippedLog.asItem())
            .add(TwilightBlocks.TRANSWOOD_SET.wood.asItem())
            .add(TwilightBlocks.TRANSWOOD_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.MINEWOOD_LOGS_ITEM_TAG)
            .add(TwilightBlocks.MINEWOOD_SET.log.asItem())
            .add(TwilightBlocks.MINEWOOD_SET.strippedLog.asItem())
            .add(TwilightBlocks.MINEWOOD_SET.wood.asItem())
            .add(TwilightBlocks.MINEWOOD_SET.strippedWood.asItem())

        valueLookupBuilder(TwilightItemTags.SORTWOOD_LOGS_ITEM_TAG)
            .add(TwilightBlocks.SORTWOOD_SET.log.asItem())
            .add(TwilightBlocks.SORTWOOD_SET.strippedLog.asItem())
            .add(TwilightBlocks.SORTWOOD_SET.wood.asItem())
            .add(TwilightBlocks.SORTWOOD_SET.strippedWood.asItem())
        

        valueLookupBuilder(ItemTags.LEAVES)
            .add(TwilightBlocks.RAINBOW_OAK_LEAVES.asItem())

        valueLookupBuilder(ItemTags.SAPLINGS)
            .add(TwilightBlocks.RAINBOW_OAK_SAPLING.asItem())

        createToolSetItemTags(TwilightItems.IRONWOOD_TOOL_SET, TwilightItemTags.IRONWOOD_TOOL_MATERIALS, listOf(TwilightItems.IRONWOOD_INGOT))
        createToolSetItemTags(TwilightItems.STEELEAF_TOOL_SET, TwilightItemTags.STEELEAF_TOOL_MATERIALS, listOf(TwilightItems.STEELEAF_INGOT))
        createToolSetItemTags(TwilightItems.KNIGHTMETAL_TOOL_SET, TwilightItemTags.KNIGHTMETAL_TOOL_MATERIALS, listOf(TwilightItems.KNIGHTMETAL_INGOT))
        createToolSetItemTags(TwilightItems.FIERY_TOOL_SET, TwilightItemTags.FIERY_TOOL_MATERIALS, listOf(TwilightItems.FIERY_INGOT))

        valueLookupBuilder(TwilightItemTags.FIERY_VIALS)
            .add(TwilightItems.FIERY_BLOOD, TwilightItems.FIERY_TEARS)
    }

    private fun createToolSetItemTags(toolSet: ToolSet, repairTag: TagKey<Item>, repairMaterials: List<Item>) {
        toolSet.mapOfToolsToTypes.forEach { (type, item) ->
            item?.let {
                toolSet.mapOfTypesToItemTags[type]?.let { tag ->
                    valueLookupBuilder(tag).add(item)
                }
            }
        }
        for (material in repairMaterials) {
            valueLookupBuilder(repairTag).add(material)
        }
    }

    private fun createWoodSetItemTags(woodSet: WoodSet) {
        valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
            .add(woodSet.log.asItem())
            .add(woodSet.strippedLog.asItem())
            .add(woodSet.wood.asItem())
            .add(woodSet.strippedWood.asItem())

        valueLookupBuilder(ItemTags.LEAVES)
            .add(woodSet.leaves.asItem())

        valueLookupBuilder(ItemTags.SAPLINGS)
            .add(woodSet.sapling.asItem())

        valueLookupBuilder(ItemTags.PLANKS)
            .add(woodSet.planks.asItem())

        valueLookupBuilder(ItemTags.WOODEN_DOORS)
            .add(woodSet.door.asItem())

        valueLookupBuilder(ItemTags.WOODEN_TRAPDOORS)
            .add(woodSet.trapdoor.asItem())

        valueLookupBuilder(ItemTags.WOODEN_FENCES)
            .add(woodSet.fence.asItem())

        valueLookupBuilder(ItemTags.WOODEN_STAIRS)
            .add(woodSet.stairs.asItem())

        valueLookupBuilder(ItemTags.WOODEN_SLABS)
            .add(woodSet.slab.asItem())

        valueLookupBuilder(ItemTags.WOODEN_BUTTONS)
            .add(woodSet.button.asItem())

        valueLookupBuilder(ItemTags.WOODEN_PRESSURE_PLATES)
            .add(woodSet.pressurePlate.asItem())

        valueLookupBuilder(ItemTags.SIGNS)
            .add(woodSet.signItem)

        valueLookupBuilder(ItemTags.HANGING_SIGNS)
            .add(woodSet.hangingSignItem)
    }
}