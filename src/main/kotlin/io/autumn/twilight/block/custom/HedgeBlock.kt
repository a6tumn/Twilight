package io.autumn.twilight.block.custom

import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.InsideBlockEffectApplier
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.monster.spider.Spider
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition
import net.minecraft.world.level.block.state.properties.BooleanProperty
import net.minecraft.world.level.pathfinder.PathComputationType
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape

class HedgeBlock(properties: Properties) : Block(properties) {
    companion object {
        private val boundingBox = box(1.0, 0.0, 1.0, 15.0, 15.0, 15.0)
        val ROSE = BooleanProperty.create("rose")
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        super.createBlockStateDefinition(builder.add(ROSE))
    }

    override fun onPlace(state: BlockState, level: Level, pos: BlockPos, oldState: BlockState, movedByPiston: Boolean) {
        if (!level.isClientSide && level.random.nextFloat() < 0.25f) {
            val newState = state.setValue(ROSE, true)
            level.setBlock(pos, newState, 3)
        }
    }

    override fun entityInside(state: BlockState, level: Level, pos: BlockPos, entity: Entity, effectApplier: InsideBlockEffectApplier, isPrecise: Boolean) {
        applyDamage(level, entity)
    }

    override fun playerDestroy(level: Level, player: Player, pos: BlockPos, state: BlockState, blockEntity: BlockEntity?, destroyedWith: ItemStack) {
        applyDamage(level, player)
    }

    override fun getCollisionShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = boundingBox
    override fun getVisualShape(state: BlockState, level: BlockGetter, pos: BlockPos, context: CollisionContext): VoxelShape = boundingBox
    override fun isPathfindable(state: BlockState, type: PathComputationType): Boolean = false

    private fun shouldDamage(entity: Entity): Boolean = entity !is Spider && entity !is ItemEntity && !entity.isSpectator && !entity.isCrouching

    private fun applyDamage(level: Level, entity: Entity) {
        if (shouldDamage(entity) && level is ServerLevel) {
            entity.hurtServer(level, level.damageSources().cactus(), 3.0f)
        }
    }

    init {
        registerDefaultState(stateDefinition.any().setValue(ROSE, false))
    }
}