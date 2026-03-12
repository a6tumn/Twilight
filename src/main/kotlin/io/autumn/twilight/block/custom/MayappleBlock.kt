package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.block.BushBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class MayappleBlock(properties: Properties) : BushBlock(properties) {
    companion object {
        private val boundingBox = box(3.5, 0.0, 3.5, 12.5, 6.0, 12.5)
        val CODEC = simpleCodec(::MayappleBlock)
    }

    override fun getShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = boundingBox

    @Suppress("UNCHECKED_CAST")
    override fun codec(): MapCodec<BushBlock> = CODEC as MapCodec<BushBlock>
}