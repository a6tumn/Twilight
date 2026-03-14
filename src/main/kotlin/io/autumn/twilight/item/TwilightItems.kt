package io.autumn.twilight.item

import io.autumn.carminite.registry.registerGenericItem
import io.autumn.carminite.tool.ToolSet
import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight
import io.autumn.twilight.lists.TwilightBlockTags
import io.autumn.twilight.lists.TwilightItemTags
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity

object TwilightItems {

    val RAVEN_FEATHER: Item = registerGenericItem(Twilight.namespaceAndPath("raven_feather"), ::Item, Item.Properties())
    val TOWER_KEY = registerGenericItem(Twilight.namespaceAndPath("tower_key"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON).fireResistant())
    val BORER_ESSENCE = registerGenericItem(Twilight.namespaceAndPath("borer_essence"), ::Item, Item.Properties())
    val CARMINITE = registerGenericItem(Twilight.namespaceAndPath("carminite"), ::Item, Item.Properties())

    val NAGA_SCALE = registerGenericItem(Twilight.namespaceAndPath("naga_scale"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val LIVEROOT = registerGenericItem(Twilight.namespaceAndPath("liveroot"), ::Item, Item.Properties())
    val RAW_IRONWOOD = registerGenericItem(Twilight.namespaceAndPath("raw_ironwood"), ::Item, Item.Properties())
    val IRONWOOD_INGOT = registerGenericItem(Twilight.namespaceAndPath("ironwood_ingot"), ::Item, Item.Properties())
    val STEELEAF_INGOT = registerGenericItem(Twilight.namespaceAndPath("steeleaf_ingot"), ::Item, Item.Properties())
    val FIERY_BLOOD = registerGenericItem(Twilight.namespaceAndPath("fiery_blood"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val FIERY_TEARS = registerGenericItem(Twilight.namespaceAndPath("fiery_tears"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val FIERY_INGOT = registerGenericItem(Twilight.namespaceAndPath("fiery_ingot"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON).fireResistant())
    val ARMOR_SHARD = registerGenericItem(Twilight.namespaceAndPath("armor_shard"), ::Item, Item.Properties())
    val ARMOR_SHARD_CLUSTER = registerGenericItem(Twilight.namespaceAndPath("armor_shard_cluster"), ::Item, Item.Properties())
    val KNIGHTMETAL_INGOT = registerGenericItem(Twilight.namespaceAndPath("knightmetal_ingot"), ::Item, Item.Properties())
    val ARCTIC_FUR = registerGenericItem(Twilight.namespaceAndPath("arctic_fur"), ::Item, Item.Properties())
    val ALPHA_YETI_FUR = registerGenericItem(Twilight.namespaceAndPath("alpha_yeti_fur"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))

    val IRONWOOD_SET = ToolSet(
        Twilight.namespaceAndPath("ironwood"),
        TwilightBlockTags.INCORRECT_FOR_IRONWOOD_TOOL,
        TwilightItemTags.IRONWOOD_TOOL_MATERIALS,
        512,
        6.5f,
        2.0f,
        25,
        0.0f,
        0.0f
    )
    
    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("registerGenericIteming items for ${Twilight.NAMESPACE}.")
    }
}