package io.autumn.twilight.block.custom

import io.autumn.twilight.sound.TwilightSounds
import net.fabricmc.fabric.api.transfer.v1.item.ContainerStorage
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant
import net.fabricmc.fabric.api.transfer.v1.item.PlayerInventoryStorage
import net.fabricmc.fabric.api.transfer.v1.storage.SlottedStorage
import net.fabricmc.fabric.api.transfer.v1.storage.StorageUtil
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.npc.InventoryCarrier
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.Level
import net.minecraft.world.phys.AABB
import net.minecraft.world.phys.Vec3
import kotlin.math.pow

class SortwoodCoreBlock(properties: Properties) : MagicLogCoreBlock(properties) {

    override fun performTreeEffect(level: ServerLevel, pos: BlockPos, rand: RandomSource) {
        val inputStorages = mutableListOf<Pair<SlottedStorage<ItemVariant>, Vec3>>()
        val outputStorages = mutableListOf<Pair<SlottedStorage<ItemVariant>, Vec3>>()

        val coreVec = Vec3.atCenterOf(pos)
        val innerRadiusSq = 2.0.pow(2)
        val outerRadiusSq = 16.0.pow(2)

        for (x in (pos.x - 16.0.toInt())..(pos.x + 16.0.toInt())) {
            for (y in (pos.y - 16.0.toInt())..(pos.y + 16.0.toInt())) {
                for (z in (pos.z - 16.0.toInt())..(pos.z + 16.0.toInt())) {
                    val checkPos = BlockPos(x, y, z)
                    val checkVec = Vec3.atCenterOf(checkPos)
                    val distanceSq = coreVec.distanceToSqr(checkVec)

                    if (distanceSq > outerRadiusSq) continue

                    val storage = getBlockStorage(level, checkPos) ?: continue
                    assignStorage(storage, checkVec, inputStorages, outputStorages, innerRadiusSq, distanceSq)
                }
            }
        }

        val entities = level.getEntities(null, AABB(pos).inflate(16.0)) { it.isAlive && it.hasInventoryCapability() }

        for (entity in entities) {
            val storage = entity.getItemStorage() ?: continue
            val distanceSq = coreVec.distanceToSqr(entity.position())
            assignStorage(storage, entity.position(), inputStorages, outputStorages, innerRadiusSq, distanceSq)
        }

        for ((input, _) in inputStorages) {
            if (input.slotCount == 0) continue

            Transaction.openOuter().use { tx ->
                repeat(input.slotCount) { slotIndex ->
                    val slot = input.getSlot(slotIndex)
                    if (slot.amount == 0L) return@repeat

                    val variant = slot.resource
                    var remaining = slot.amount

                    val sortedOutputs = outputStorages.sortedByDescending { (storage, _) ->
                        countExistingInStorage(storage, variant)
                    }

                    for ((output, _) in sortedOutputs) {
                        val moved = StorageUtil.move(input, output, { it == variant }, remaining, tx)
                        remaining -= moved
                        if (remaining <= 0) break
                    }
                }
                tx.commit()
            }
        }
    }

    override fun doesCoreFunction(): Boolean = true

    override fun playSound(level: Level, pos: BlockPos, rand: RandomSource) {
        level.playSound(null, pos, TwilightSounds.SORTWOOD_CORE_ACTIVE, SoundSource.BLOCKS, 0.35f, 0.5f)
    }

    private fun assignStorage(storage: SlottedStorage<ItemVariant>, pos: Vec3, inputList: MutableList<Pair<SlottedStorage<ItemVariant>, Vec3>>, outputList: MutableList<Pair<SlottedStorage<ItemVariant>, Vec3>>, innerRadiusSq: Double, distanceSq: Double) {
        if (distanceSq <= innerRadiusSq) inputList.add(storage to pos)
        else outputList.add(storage to pos)
    }

    private fun getBlockStorage(level: ServerLevel, blockPos: BlockPos): SlottedStorage<ItemVariant>? {
        for (side in Direction.entries) {
            val found = ItemStorage.SIDED.find(level, blockPos, side)
            if (found is SlottedStorage<ItemVariant>) return found
        }
        return ItemStorage.SIDED.find(level, blockPos, null) as? SlottedStorage<ItemVariant>
    }

    private fun countExistingInStorage(storage: SlottedStorage<ItemVariant>, variant: ItemVariant): Long {
        var count = 0L
        repeat(storage.slotCount) { i ->
            val slot = storage.getSlot(i)
            if (slot.resource == variant) count += slot.amount
        }
        return count
    }

    private fun Entity.hasInventoryCapability(): Boolean = this.getItemStorage() != null

    private fun Entity.getItemStorage(): SlottedStorage<ItemVariant>? = when (this) {
        is Player -> PlayerInventoryStorage.of(this) as? SlottedStorage<ItemVariant>
        is InventoryCarrier -> {
            val inv = this.inventory
            ContainerStorage.of(inv, null) as? SlottedStorage<ItemVariant>
        }
        else -> null
    }
}