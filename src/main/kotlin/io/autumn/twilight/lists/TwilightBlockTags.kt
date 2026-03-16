package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

enum class TwilightBlockTags(
    val tagKey: TagKey<Block>
) {
    TIMEWOOD_CORE_EXCLUDED(createTagKey("timewood_core_excluded")),
    ORE_MAGNET_SAFE_REPLACE_BLOCK(createTagKey("ore_magnet_safe_replace_block")),
    INCORRECT_FOR_IRONWOOD_TOOL(createTagKey("incorrect_for_ironwood_tool")),
    INCORRECT_FOR_STEELEAF_TOOL(createTagKey("incorrect_for_steeleaf_tool")),
    INCORRECT_FOR_KNIGHTMETAL_TOOL(createTagKey("incorrect_for_knightmetal_tool")),
    INCORRECT_FOR_FIERY_TOOL(createTagKey("incorrect_for_fiery_tool"));
}

private fun createTagKey(path: String): TagKey<Block> = TagKey.create(Registries.BLOCK, Twilight.namespaceAndPath(path))