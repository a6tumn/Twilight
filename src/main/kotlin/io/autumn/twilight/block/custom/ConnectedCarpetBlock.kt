package io.autumn.twilight.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.CarpetBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BlockStateProperties
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.redstone.Orientation

class ConnectedCarpetBlock(properties: Properties) : CarpetBlock(properties) {
    companion object {
        val NORTH_EAST = BooleanProperty.create("north_east")
        val NORTH_WEST = BooleanProperty.create("north_west")
        val SOUTH_EAST = BooleanProperty.create("south_east")
        val SOUTH_WEST = BooleanProperty.create("south_west")

        val HORIZONTAL_FACING_PROPERTIES = mapOf(
            Direction.NORTH to BlockStateProperties.NORTH,
            Direction.EAST to BlockStateProperties.EAST,
            Direction.SOUTH to BlockStateProperties.SOUTH,
            Direction.WEST to BlockStateProperties.WEST
        )
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(
            BlockStateProperties.NORTH,
            BlockStateProperties.EAST,
            BlockStateProperties.SOUTH,
            BlockStateProperties.WEST,
            NORTH_EAST,
            NORTH_WEST,
            SOUTH_EAST,
            SOUTH_WEST
        )
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState {
        val world = context.level
        val pos = context.clickedPos
        val baseState = stateDefinition.any()

        return baseState
            .setValue(BlockStateProperties.NORTH, canConnect(world.getBlockState(pos.north())))
            .setValue(BlockStateProperties.EAST, canConnect(world.getBlockState(pos.east())))
            .setValue(BlockStateProperties.SOUTH, canConnect(world.getBlockState(pos.south())))
            .setValue(BlockStateProperties.WEST, canConnect(world.getBlockState(pos.west())))
            .setValue(NORTH_EAST, canConnect(world.getBlockState(pos.north().east())))
            .setValue(NORTH_WEST, canConnect(world.getBlockState(pos.north().west())))
            .setValue(SOUTH_EAST, canConnect(world.getBlockState(pos.south().east())))
            .setValue(SOUTH_WEST, canConnect(world.getBlockState(pos.south().west())))
    }

    override fun neighborChanged(state: BlockState, level: Level, pos: BlockPos, block: Block, orientation: Orientation?, movedByPiston: Boolean) {
        val north = canConnect(level.getBlockState(pos.north()))
        val east = canConnect(level.getBlockState(pos.east()))
        val south = canConnect(level.getBlockState(pos.south()))
        val west = canConnect(level.getBlockState(pos.west()))

        val northEast = canConnect(level.getBlockState(pos.north().east()))
        val northWest = canConnect(level.getBlockState(pos.north().west()))
        val southEast = canConnect(level.getBlockState(pos.south().east()))
        val southWest = canConnect(level.getBlockState(pos.south().west()))

        val newState = state
            .setValue(BlockStateProperties.NORTH, north)
            .setValue(BlockStateProperties.EAST, east)
            .setValue(BlockStateProperties.SOUTH, south)
            .setValue(BlockStateProperties.WEST, west)
            .setValue(NORTH_EAST, northEast)
            .setValue(NORTH_WEST, northWest)
            .setValue(SOUTH_EAST, southEast)
            .setValue(SOUTH_WEST, southWest)

        if (newState != state) {
            level.setBlock(pos, newState, 3)
        }
    }

    private fun canConnect(state: BlockState) : Boolean {
        return state.`is`(this)
    }
}