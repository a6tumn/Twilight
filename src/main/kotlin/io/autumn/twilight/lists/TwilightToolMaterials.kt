package io.autumn.twilight.lists

import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.ToolMaterial
import net.minecraft.world.level.block.Block

enum class TwilightToolMaterials(
    val toolMaterial: ToolMaterial
) {
    IRONWOOD(createToolMaterial(TwilightBlockTags.INCORRECT_FOR_IRONWOOD_TOOL.tagKey, 512, 6.0f, 2.0f, 25,TwilightItemTags.IRONWOOD_TOOL_MATERIALS.tagKey)),
    STEELEAF(createToolMaterial(TwilightBlockTags.INCORRECT_FOR_STEELEAF_TOOL.tagKey, 131, 8.0f, 3.0f, 9,TwilightItemTags.STEELEAF_TOOL_MATERIALS.tagKey)),
    KNIGHTMETAL(createToolMaterial(TwilightBlockTags.INCORRECT_FOR_KNIGHTMETAL_TOOL.tagKey, 512, 8.0f, 3.0f, 8,TwilightItemTags.KNIGHTMETAL_TOOL_MATERIALS.tagKey)),
    FIERY(createToolMaterial(TwilightBlockTags.INCORRECT_FOR_FIERY_TOOL.tagKey, 1024, 9.0f, 4.0f, 10,TwilightItemTags.FIERY_TOOL_MATERIALS.tagKey));
}

private fun createToolMaterial(incorrectForTag: TagKey<Block>, durability: Int, speed: Float, attackDamageBonus: Float, enchantmentValue: Int, repairWithTag: TagKey<Item>): ToolMaterial =
    ToolMaterial(incorrectForTag, durability, speed, attackDamageBonus, enchantmentValue, repairWithTag)
