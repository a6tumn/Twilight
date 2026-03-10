package io.autumn.twilight.block.custom

import io.autumn.twilight.blockentity.custom.TwilightChestBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.level.block.ChestBlock
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.entity.ChestBlockEntity
import net.minecraft.world.level.block.state.BlockState
import java.util.function.Supplier

class TwilightChestBlock(blockEntityType: Supplier<BlockEntityType<out ChestBlockEntity>>, openSound: SoundEvent, closeSound: SoundEvent, properties: Properties) : ChestBlock(blockEntityType, openSound, closeSound, properties) {
    override fun newBlockEntity(pos: BlockPos, state: BlockState): BlockEntity = TwilightChestBlockEntity(pos, state)
}