package io.autumn.twilight.providers

import io.autumn.carminite.datagen.createFlatItemModels
import io.autumn.carminite.datagen.createPlantWithAltPotted
import io.autumn.carminite.datagen.createToolSetModels
import io.autumn.carminite.datagen.createWoodSetModels
import io.autumn.carminite.wood.WoodSet
import io.autumn.twilight.Twilight
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.block.custom.HedgeBlock
import io.autumn.twilight.block.custom.MagicLogCoreBlock
import io.autumn.twilight.item.TwilightItems
import io.autumn.twilight.lists.TwilightBlockFamilies
import io.autumn.twilight.specialrenderer.custom.LocklessChestSpecialRenderer
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.MultiVariant
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator
import net.minecraft.client.data.models.model.ItemModelUtils
import net.minecraft.client.data.models.model.ModelLocationUtils
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.client.data.models.model.TextureMapping
import net.minecraft.client.data.models.model.TexturedModel
import net.minecraft.client.renderer.block.dispatch.Variant
import net.minecraft.client.renderer.item.ItemModel
import net.minecraft.client.resources.model.sprite.Material
import net.minecraft.resources.Identifier
import net.minecraft.util.random.WeightedList
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class ModelProvider(output: FabricPackOutput) : FabricModelProvider(output) {
    override fun generateBlockStateModels(blockModelGenerators: BlockModelGenerators) {
        blockModelGenerators.createTrivialCube(TwilightBlocks.ROOT_BLOCK)
        blockModelGenerators.createTrivialCube(TwilightBlocks.LIVEROOT_BLOCK)
        createHedge(blockModelGenerators, "hedge")
        blockModelGenerators.createPlantWithAltPotted("fiddlehead", TwilightBlocks.FIDDLEHEAD, TwilightBlocks.POTTED_FIDDLEHEAD, Twilight.namespaceAndPath("block/potted_fiddlehead"), BlockModelGenerators.PlantType.TINTED)
        blockModelGenerators.createPlantWithAltPotted("mushgloom", TwilightBlocks.MUSHGLOOM, TwilightBlocks.POTTED_MUSHGLOOM, Twilight.namespaceAndPath("block/potted_mushgloom"), BlockModelGenerators.PlantType.NOT_TINTED)
        blockModelGenerators.blockStateOutput.accept(createSimpleBlock(TwilightBlocks.MAYAPPLE, MultiVariant(WeightedList.of(Variant(ModelLocationUtils.getModelLocation(TwilightBlocks.MAYAPPLE))))))
        blockModelGenerators.blockStateOutput.accept(createSimpleBlock(TwilightBlocks.POTTED_MAYAPPLE, MultiVariant(WeightedList.of(Variant(ModelLocationUtils.getModelLocation(TwilightBlocks.POTTED_MAYAPPLE))))))
        blockModelGenerators.createFlatItemModel(TwilightBlocks.MAYAPPLE.asItem())

        blockModelGenerators.createWoodSetModels(TwilightBlocks.TWILIGHT_OAK_SET, TwilightBlockFamilies.TWILIGHT_OAK.blockFamily, -12012264)
        blockModelGenerators.createTintedLeaves(TwilightBlocks.RAINBOW_OAK_LEAVES, TexturedModel.LEAVES, 0xFFAA88CC.toInt())
        blockModelGenerators.createPlantWithDefaultItem(TwilightBlocks.RAINBOW_OAK_SAPLING, TwilightBlocks.POTTED_RAINBOW_OAK_SAPLING, BlockModelGenerators.PlantType.NOT_TINTED)

        blockModelGenerators.createWoodSetModels( TwilightBlocks.CANOPY_SET, TwilightBlockFamilies.CANOPY.blockFamily,-10380959)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.TWILIGHT_MANGROVE_SET, TwilightBlockFamilies.TWILIGHT_MANGROVE.blockFamily,-8345771)
        blockModelGenerators.createTrivialCube(TwilightBlocks.TWILIGHT_MANGROVE_ROOT)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.DARKWOOD_SET, TwilightBlockFamilies.DARKWOOD.blockFamily,-12012264)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.TIMEWOOD_SET, TwilightBlockFamilies.TIMEWOOD.blockFamily,6986775)
        createMagicLogCore(blockModelGenerators, TwilightBlocks.TIMEWOOD_SET, TwilightBlocks.TIMEWOOD_CORE)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.TRANSWOOD_SET, TwilightBlockFamilies.TRANSWOOD.blockFamily,7130346)
        createMagicLogCore(blockModelGenerators, TwilightBlocks.TRANSWOOD_SET, TwilightBlocks.TRANSWOOD_CORE)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.MINEWOOD_SET, TwilightBlockFamilies.MINEWOOD.blockFamily,16576836)
        createMagicLogCore(blockModelGenerators, TwilightBlocks.MINEWOOD_SET, TwilightBlocks.MINEWOOD_CORE)

        blockModelGenerators.createWoodSetModels(TwilightBlocks.SORTWOOD_SET, TwilightBlockFamilies.SORTWOOD.blockFamily,3558403)
        createMagicLogCore(blockModelGenerators, TwilightBlocks.SORTWOOD_SET, TwilightBlocks.SORTWOOD_CORE)
    }

    override fun generateItemModels(itemModelGenerators: ItemModelGenerators) {
        itemModelGenerators.createFlatItemModels(
            listOf(
                TwilightItems.RAVEN_FEATHER,
                TwilightItems.TOWER_KEY,
                TwilightItems.CARMINITE,
                TwilightItems.NAGA_SCALE,
                TwilightItems.LIVEROOT,
                TwilightItems.RAW_IRONWOOD,
                TwilightItems.IRONWOOD_INGOT,
                TwilightItems.STEELEAF_INGOT,
                TwilightItems.FIERY_BLOOD,
                TwilightItems.FIERY_TEARS,
                TwilightItems.FIERY_INGOT,
                TwilightItems.ARMOR_SHARD,
                TwilightItems.ARMOR_SHARD_CLUSTER,
                TwilightItems.KNIGHTMETAL_INGOT,
                TwilightItems.ARCTIC_FUR,
                TwilightItems.ALPHA_YETI_FUR
            )
        )

        createTwoLayerItemModels(itemModelGenerators,
            listOf(
                TwilightItems.BORER_ESSENCE
            ), listOf(
                Twilight.namespaceAndPath("borer_essence")
            )
        )

        itemModelGenerators.createToolSetModels(TwilightItems.IRONWOOD_TOOL_SET)
        itemModelGenerators.createToolSetModels(TwilightItems.STEELEAF_TOOL_SET)
        itemModelGenerators.createToolSetModels(TwilightItems.KNIGHTMETAL_TOOL_SET)
        itemModelGenerators.createToolSetModels(TwilightItems.FIERY_TOOL_SET)
    }

    private fun createTwoLayerItemModels(itemModelGenerators: ItemModelGenerators, itemList: List<Item>, idList: List<Identifier>) {
        for (item in itemList) {
            for (itemId in idList) {
                val id = itemModelGenerators.generateLayeredItem(item, Material(itemId.withPrefix("item/").withSuffix("_layer0")), Material(itemId.withPrefix("item/").withSuffix("_layer1")))
                itemModelGenerators.itemModelOutput.accept(item, ItemModelUtils.plainModel(id))
            }
        }
    }

    private fun createLocklessChest(blockModelGenerators: BlockModelGenerators, block: Block, particle: Block, texture: Identifier) {
        blockModelGenerators.createParticleOnlyBlock(block, particle)

        val chestItem: Item = block.asItem()
        val itemModelBase: Identifier = ModelTemplates.CHEST_INVENTORY.create(chestItem, TextureMapping.particle(particle), blockModelGenerators.modelOutput)
        val plainModel: ItemModel.Unbaked = ItemModelUtils.specialModel(itemModelBase, LocklessChestSpecialRenderer.Unbaked(texture))

        blockModelGenerators.itemModelOutput.accept(chestItem, plainModel)
    }

    private fun createMagicLogCore(blockModelGenerators: BlockModelGenerators, woodSet: WoodSet, coreBlock: Block) {
        val mappingOff = TextureMapping.column(Material(Twilight.namespaceAndPath("block/${woodSet.woodPath}_core")), Material(Twilight.namespaceAndPath("block/${woodSet.woodPath}_log_top")))
        val mappingOn = TextureMapping.column(Material(Twilight.namespaceAndPath("block/${woodSet.woodPath}_core_on")), Material(Twilight.namespaceAndPath("block/${woodSet.woodPath}_log_top")))

        val offId = ModelTemplates.CUBE_COLUMN.create(coreBlock, mappingOff, blockModelGenerators.modelOutput)
        val onId = blockModelGenerators.createSuffixedVariant(coreBlock, "_on", ModelTemplates.CUBE_COLUMN) { mappingOn }

        blockModelGenerators.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(coreBlock).with(
                BlockModelGenerators.createBooleanModelDispatch(
                    MagicLogCoreBlock.ACTIVE,
                    MultiVariant(WeightedList.of(Variant(onId))),
                    MultiVariant(WeightedList.of(Variant(offId)))
                )
            )
        )
    }

    private fun createHedge(blockModelGenerators: BlockModelGenerators, name: String) {
        val mappingOff = TextureMapping.cube(Material(Twilight.namespaceAndPath("block/${name}")))
        val mappingOn = TextureMapping.cube(Material(Twilight.namespaceAndPath("block/${name}_rose")))

        val offId = ModelTemplates.CUBE_ALL.create(TwilightBlocks.HEDGE, mappingOff, blockModelGenerators.modelOutput)
        val onId = blockModelGenerators.createSuffixedVariant(TwilightBlocks.HEDGE, "_rose", ModelTemplates.CUBE_ALL) { mappingOn }

        blockModelGenerators.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(TwilightBlocks.HEDGE).with(
                BlockModelGenerators.createBooleanModelDispatch(
                    HedgeBlock.ROSE,
                    MultiVariant(WeightedList.of(Variant(onId))),
                    MultiVariant(WeightedList.of(Variant(offId)))
                )
            )
        )
    }
}