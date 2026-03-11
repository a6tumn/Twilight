package io.autumn.twilight.lists

import io.autumn.twilight.Twilight
import net.minecraft.core.registries.Registries
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block

object TwilightBlockTags {
    val TIMEWOOD_CORE_EXCLUDED: TagKey<Block> = TagKey.create(Registries.BLOCK, Twilight.namespaceAndPath("timewood_core_excluded"))
    val ORE_MAGNET_SAFE_REPLACE_BLOCK: TagKey<Block> = TagKey.create(Registries.BLOCK, Twilight.namespaceAndPath("ore_magnet_safe_replace_block"))
}