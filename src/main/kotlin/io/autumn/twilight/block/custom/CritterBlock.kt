package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.util.RandomSource
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.ScheduledTickAccess
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DirectionalBlock
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.Rotation
import net.minecraft.world.level.block.SimpleWaterloggedBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.level.material.FluidState
import net.minecraft.world.level.material.Fluids
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.Shapes
import net.minecraft.world.phys.shapes.VoxelShape

abstract class CritterBlock(properties: Properties) : Block(properties), SimpleWaterloggedBlock {
    companion object {
        val FACING: EnumProperty<Direction> = DirectionalBlock.FACING
        val WATERLOGGED: BooleanProperty = BlockStateProperties.WATERLOGGED

        private val downBoundingBox = Shapes.create(AABB(0.2, 0.85, 0.2, 0.8, 1.0, 0.8))
        private val upBoundingBox = Shapes.create(AABB(0.2, 0.0, 0.2, 0.8, 0.15, 0.8))
        private val northBoundingBox = Shapes.create(AABB(0.2, 0.2, 0.85, 0.8, 0.8, 1.0))
        private val southBoundingBox = Shapes.create(AABB(0.2, 0.2, 0.0, 0.8, 0.8, 0.15))
        private val westBoundingBox = Shapes.create(AABB(0.85, 0.2, 0.2, 1.0, 0.8, 0.8))
        private val eastBoundingBox = Shapes.create(AABB(0.0, 0.2, 0.2, 0.15, 0.8, 0.8))
    }

    override fun getVisualShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape =
        when (state.getValue(FACING)) {
            Direction.DOWN -> downBoundingBox
            Direction.NORTH -> northBoundingBox
            Direction.SOUTH -> southBoundingBox
            Direction.WEST -> westBoundingBox
            Direction.EAST -> eastBoundingBox
            else -> upBoundingBox
        }

    override fun getFluidState(state: BlockState): FluidState {
        return if (state.getValue(WATERLOGGED))
            Fluids.WATER.getSource(false)
        else
            super.getFluidState(state)
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
        val clicked = context.clickedFace
        val fluid = context.level.getFluidState(context.clickedPos)

        var state = defaultBlockState()
            .setValue(FACING, clicked)
            .setValue(WATERLOGGED, fluid.type == Fluids.WATER)

        if (canSurvive(state, context.level, context.clickedPos)) {
            return state
        }

        for (dir in context.nearestLookingDirections) {
            state = defaultBlockState().setValue(FACING, dir.opposite)
            if (canSurvive(state, context.level, context.clickedPos)) {
                return state
            }
        }

        return null
    }

    override fun updateShape(state: BlockState, reader: LevelReader, access: ScheduledTickAccess, pos: BlockPos, direction: Direction, facingPos: BlockPos, facingState: BlockState, random: RandomSource): BlockState {
        if (state.getValue(WATERLOGGED)) {
            access.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(reader))
        }

        return if (state.getValue(FACING).opposite == direction && !state.canSurvive(reader, pos)) {
            Blocks.AIR.defaultBlockState()
        } else {
            super.updateShape(state, reader, access, pos, direction, facingPos, facingState, random)
        }
    }

    override fun canSurvive(state: BlockState, level: LevelReader, pos: BlockPos): Boolean {
        val belowPos = pos.relative(state.getValue(FACING).opposite)
        return canSupportCenter(level, belowPos, state.getValue(FACING)) || level.getBlockState(belowPos).block is LeavesBlock
    }

    override fun getCollisionShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = getVisualShape(state, level, pos, context)
    override fun rotate(state: BlockState, rotation: Rotation): BlockState = state.setValue(FACING, rotation.rotate(state.getValue(FACING)))
    abstract override fun codec(): MapCodec<out BaseEntityBlock?>

    init {
        registerDefaultState(
            stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(WATERLOGGED, false)
        )
    }
}