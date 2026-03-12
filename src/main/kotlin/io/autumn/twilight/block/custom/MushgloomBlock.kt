package io.autumn.twilight.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.block.MushroomBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class MushgloomBlock(feature: ResourceKey<ConfiguredFeature<*, *>>, properties: Properties) : MushroomBlock(feature, properties) {
    companion object {
        private val boundingBox = box(2.0, 0.0, 2.0, 14.0, 8.0, 14.0)
    }

    override fun isValidBonemealTarget(level: LevelReader, pos: BlockPos, state: BlockState): Boolean = false
    override fun getShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = boundingBox
}