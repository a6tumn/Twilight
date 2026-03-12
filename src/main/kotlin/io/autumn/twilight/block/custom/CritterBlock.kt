package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.util.RandomSource
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.ScheduledTickAccess
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DirectionalBlock
import net.minecraft.world.level.block.LeavesBlock
import net.minecraft.world.level.block.Rotation
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.EnumProperty
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

abstract class CritterBlock(properties: Properties) : Block(properties) {
    companion object {
        val FACING: EnumProperty<Direction> = DirectionalBlock.FACING
        val ORIENTATION = EnumProperty.create("orientation", Direction::class.java)

        private val downBoundingBox = box(3.2, 13.6, 3.2, 12.8, 16.0, 12.8)
        private val upBoundingBox = box(3.2, 0.0, 3.2, 12.8, 2.4, 12.8)
        private val northBoundingBox = box(3.2, 3.2, 13.6, 12.8, 12.8, 16.0)
        private val southBoundingBox = box(3.2, 3.2, 0.0, 12.8, 12.8, 2.4)
        private val westBoundingBox = box(13.6, 3.2, 3.2, 16.0, 12.8, 12.8)
        private val eastBoundingBox = box(0.0, 3.2, 3.2, 2.4, 12.8, 12.8)
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(FACING, ORIENTATION)
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

    override fun getShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape =
        when (state.getValue(FACING)) {
            Direction.DOWN -> downBoundingBox
            Direction.NORTH -> northBoundingBox
            Direction.SOUTH -> southBoundingBox
            Direction.WEST -> westBoundingBox
            Direction.EAST -> eastBoundingBox
            else -> upBoundingBox
        }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
        val clicked = context.clickedFace
        val pos = context.clickedPos
        val level = context.level

        val orientation = if (clicked.axis == Direction.Axis.Y) {
            context.player?.let { Direction.fromYRot(it.yRot.toDouble()).opposite } ?: Direction.NORTH
        } else {
            if (context.clickLocation.y - pos.y > 0.5) Direction.UP else Direction.DOWN
        }

        if (orientation == clicked) return null

        val state = defaultBlockState()
            .setValue(FACING, clicked)
            .setValue(ORIENTATION, orientation)

        return if (canSurvive(state, level, pos)) state else null
    }

    override fun updateShape(state: BlockState, reader: LevelReader, access: ScheduledTickAccess, pos: BlockPos, direction: Direction, facingPos: BlockPos, facingState: BlockState, random: RandomSource): BlockState {
        return if (state.getValue(FACING).opposite == direction && !state.canSurvive(reader, pos)) {
            Blocks.AIR.defaultBlockState()
        } else {
            super.updateShape(state, reader, access, pos, direction, facingPos, facingState, random)
        }
    }

    override fun canSurvive(state: BlockState, level: LevelReader, pos: BlockPos): Boolean {
        val supportPos = pos.relative(state.getValue(FACING).opposite)
        val supportBlock = level.getBlockState(supportPos).block

        if (supportBlock is CritterBlock) return false

        return canSupportCenter(level, supportPos, state.getValue(FACING)) || supportBlock is LeavesBlock
    }

    override fun rotate(state: BlockState, rotation: Rotation): BlockState = state.setValue(FACING, rotation.rotate(state.getValue(FACING)))
    abstract override fun codec(): MapCodec<out Block?>

    init {
        registerDefaultState(
            stateDefinition.any()
                .setValue(FACING, Direction.UP)
                .setValue(ORIENTATION, Direction.NORTH)
        )
    }
}