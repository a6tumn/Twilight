package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.BushBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class FiddleheadBlock(properties: Properties) : BushBlock(properties) {
    companion object {
        private val boundingBox = box(3.0, 0.0, 3.0, 13.0, 14.0, 13.0)
        val CODEC = simpleCodec(::FiddleheadBlock)
    }

    override fun getVisualShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = boundingBox

    @Suppress("UNCHECKED_CAST")
    override fun codec(): MapCodec<BushBlock> = CODEC as MapCodec<BushBlock>
}