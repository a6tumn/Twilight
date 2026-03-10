package io.autumn.twilight.blockentity.custom

import io.autumn.twilight.blockentity.TwilightBlockEntityTypes
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.entity.ChestBlockEntity
import net.minecraft.world.level.block.state.BlockState

class TwilightChestBlockEntity(pos: BlockPos, state: BlockState) : ChestBlockEntity(TwilightBlockEntityTypes.TWILIGHT_CHEST, pos, state)