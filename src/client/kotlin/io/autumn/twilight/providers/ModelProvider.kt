package io.autumn.twilight.providers

import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.Twilight
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.specialrenderer.custom.LocklessChestSpecialRenderer
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.model.ItemModelUtils
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TextureMapping
import net.minecraft.client.data.models.model.TexturedModel
import net.minecraft.client.renderer.item.ItemModel
import net.minecraft.resources.Identifier
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class ModelProvider(output: FabricPackOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModelGenerators: BlockModelGenerators) {
        blockModelGenerators.createTrivialCube(TwilightBlocks.ROOT_BLOCK)
        blockModelGenerators.createTrivialCube(TwilightBlocks.LIVEROOT_BLOCK)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.TWILIGHT_OAK_SET, -12012264,  TwilightBlocks.TWILIGHT_OAK_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST, false)
        blockModelGenerators.createTintedLeaves(TwilightBlocks.RAINBOW_OAK_LEAVES, TexturedModel.LEAVES, 0xFFAA88CC.toInt())
        blockModelGenerators.createPlantWithDefaultItem(TwilightBlocks.RAINBOW_OAK_SAPLING, TwilightBlocks.POTTED_RAINBOW_OAK_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.CANOPY_SET, -10380959,  TwilightBlocks.CANOPY_CHEST, TwilightBlocks.TRAPPED_CANOPY_CHEST, true)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.TWILIGHT_MANGROVE_SET, -8345771,  TwilightBlocks.TWILIGHT_MANGROVE_CHEST, TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST, true)
        blockModelGenerators.createTrivialCube(TwilightBlocks.TWILIGHT_MANGROVE_ROOT)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.DARKWOOD_SET, -12012264,  TwilightBlocks.DARKWOOD_CHEST, TwilightBlocks.TRAPPED_DARKWOOD_CHEST, false)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.TIMEWOOD_SET, 6986775,  TwilightBlocks.TIMEWOOD_CHEST, TwilightBlocks.TRAPPED_TIMEWOOD_CHEST, true)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.TRANSWOOD_SET, 7130346,  TwilightBlocks.TRANSWOOD_CHEST, TwilightBlocks.TRAPPED_TRANSWOOD_CHEST, false)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.MINEWOOD_SET, 16576836,  TwilightBlocks.MINEWOOD_CHEST, TwilightBlocks.TRAPPED_MINEWOOD_CHEST, true)

        createWoodSetModels(blockModelGenerators, TwilightBlocks.SORTWOOD_SET, 3558403,  TwilightBlocks.SORTWOOD_CHEST, TwilightBlocks.TRAPPED_SORTWOOD_CHEST, true)
    }

    private fun createWoodSetModels(blockModelGenerators: BlockModelGenerators, woodSet: WoodSet, leavesTintColor: Int, chestBlock: Block, trappedChestBlock: Block, lockless: Boolean) {
        blockModelGenerators.woodProvider(woodSet.log).logWithHorizontal(woodSet.log).wood(woodSet.wood)
        blockModelGenerators.woodProvider(woodSet.strippedLog).logWithHorizontal(woodSet.strippedLog).wood(woodSet.strippedWood)
        blockModelGenerators.createTintedLeaves(woodSet.leaves, TexturedModel.LEAVES, leavesTintColor)
        blockModelGenerators.createPlantWithDefaultItem(woodSet.sapling, woodSet.pottedSapling, BlockModelGenerators.PlantType.NOT_TINTED)
        blockModelGenerators.createHangingSign(woodSet.strippedLog, woodSet.hangingSign, woodSet.wallHangingSign)
        blockModelGenerators.family(woodSet.planks).generateFor(woodSet.blockFamily)
        if(lockless) {
            createLocklessChest(chestBlock, woodSet.planks, Twilight.namespaceAndPath(woodSet.woodName), blockModelGenerators)
            createLocklessChest(trappedChestBlock, woodSet.planks, Twilight.namespaceAndPath("trapped_${woodSet.woodName}"), blockModelGenerators)
        } else {
            blockModelGenerators.createChest(chestBlock, woodSet.planks, Twilight.namespaceAndPath(woodSet.woodName), false)
            blockModelGenerators.createChest(trappedChestBlock, woodSet.planks, Twilight.namespaceAndPath("trapped_${woodSet.woodName}"), false)
        }
    }

    private fun createLocklessChest(block: Block, particle: Block, texture: Identifier, blockModelGenerators: BlockModelGenerators) {
        blockModelGenerators.createParticleOnlyBlock(block, particle)

        val chestItem: Item = block.asItem()
        val itemModelBase: Identifier = ModelTemplates.CHEST_INVENTORY.create(chestItem, TextureMapping.particle(particle), blockModelGenerators.modelOutput)
        val plainModel: ItemModel.Unbaked = ItemModelUtils.specialModel(itemModelBase, LocklessChestSpecialRenderer.Unbaked(texture))

        blockModelGenerators.itemModelOutput.accept(chestItem, plainModel)
    }

    override fun generateItemModels(itemModelGenerators: ItemModelGenerators) {}
}