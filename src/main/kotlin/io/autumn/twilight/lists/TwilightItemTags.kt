package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey

object TwilightItemTags {
    val TWILIGHT_OAK_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("twilight_oak_logs_item_tag"))
    val CANOPY_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("canopy_logs_item_tag"))
    val TWILIGHT_MANGROVE_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("twilight_mangrove_logs_item_tag"))
    val DARKWOOD_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("darkwood_logs_item_tag"))
    val TIMEWOOD_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("timewood_logs_item_tag"))
    val TRANSWOOD_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("transwood_logs_item_tag"))
    val MINEWOOD_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("minewood_logs_item_tag"))
    val SORTWOOD_LOGS_ITEM_TAG = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("sortwood_logs_item_tag"))

    val IRONWOOD_TOOL_MATERIALS = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("ironwood_tool_materials"))
    val FIERY_VIALS = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath("fiery_vials"))
}