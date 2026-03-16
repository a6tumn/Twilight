package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item

enum class TwilightItemTags(
    val tagKey: TagKey<Item>
) {
    TWILIGHT_OAK_LOGS_ITEM_TAG(createTagKey("twilight_oak_logs_item_tag")),
    CANOPY_LOGS_ITEM_TAG (createTagKey("canopy_logs_item_tag")),
    TWILIGHT_MANGROVE_LOGS_ITEM_TAG(createTagKey("twilight_mangrove_logs_item_tag")),
    DARKWOOD_LOGS_ITEM_TAG(createTagKey("darkwood_logs_item_tag")),
    TIMEWOOD_LOGS_ITEM_TAG(createTagKey("timewood_logs_item_tag")),
    TRANSWOOD_LOGS_ITEM_TAG(createTagKey("transwood_logs_item_tag")),
    MINEWOOD_LOGS_ITEM_TAG(createTagKey("minewood_logs_item_tag")),
    SORTWOOD_LOGS_ITEM_TAG(createTagKey("sortwood_logs_item_tag")),
    IRONWOOD_TOOL_MATERIALS(createTagKey("ironwood_tool_materials")),
    STEELEAF_TOOL_MATERIALS(createTagKey("steeleaf_tool_materials")),
    KNIGHTMETAL_TOOL_MATERIALS(createTagKey("knightmetal_tool_materials")),
    FIERY_TOOL_MATERIALS(createTagKey("fiery_tool_materials")),
    FIERY_VIALS(createTagKey("fiery_vials"));
}

private fun createTagKey(path: String): TagKey<Item> = TagKey.create(Registries.ITEM, Twilight.namespaceAndPath(path))