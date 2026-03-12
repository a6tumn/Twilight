package io.autumn.twilight.block.custom

import com.mojang.serialization.MapCodec
import net.minecraft.world.level.block.BushBlock

class FiddleheadBlock(properties: Properties) : BushBlock(properties) {
    companion object {
        val CODEC = simpleCodec(::FiddleheadBlock)
    }

    @Suppress("UNCHECKED_CAST")
    override fun codec(): MapCodec<BushBlock> = CODEC as MapCodec<BushBlock>
}