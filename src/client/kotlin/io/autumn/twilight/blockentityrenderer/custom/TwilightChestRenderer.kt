package io.autumn.twilight.blockentityrenderer.custom

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.math.Axis
import com.mojang.math.Transformation
import io.autumn.twilight.block.TwilightBlocks
import io.autumn.twilight.blockentityrenderer.custom.state.TwilightChestRenderState
import io.autumn.twilight.list.TwilightSheets
import it.unimi.dsi.fastutil.floats.Float2FloatFunction
import it.unimi.dsi.fastutil.ints.Int2IntFunction
import net.minecraft.client.model.geom.ModelLayers
import net.minecraft.client.model.`object`.chest.ChestModel
import net.minecraft.client.renderer.SubmitNodeCollector
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider
import net.minecraft.client.renderer.blockentity.BrightnessCombiner
import net.minecraft.client.renderer.feature.ModelFeatureRenderer
import net.minecraft.client.renderer.rendertype.RenderType
import net.minecraft.client.renderer.rendertype.RenderTypes
import net.minecraft.client.renderer.state.level.CameraRenderState
import net.minecraft.client.renderer.texture.OverlayTexture
import net.minecraft.client.renderer.texture.TextureAtlasSprite
import net.minecraft.client.resources.model.sprite.SpriteGetter
import net.minecraft.client.resources.model.sprite.SpriteId
import net.minecraft.core.Direction
import net.minecraft.util.Util
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.ChestBlock
import net.minecraft.world.level.block.DoubleBlockCombiner
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.ChestBlockEntity
import net.minecraft.world.level.block.entity.LidBlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.properties.ChestType
import net.minecraft.world.phys.Vec3
import org.joml.Matrix4f

class TwilightChestRenderer<T>(context: BlockEntityRendererProvider.Context) :
    BlockEntityRenderer<T, TwilightChestRenderState> where T : BlockEntity, T : LidBlockEntity {

    private val sprites: SpriteGetter = context.sprites()
    private val singleModel: ChestModel = ChestModel(context.bakeLayer(ModelLayers.CHEST))
    private val doubleLeftModel: ChestModel = ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_LEFT))
    private val doubleRightModel: ChestModel = ChestModel(context.bakeLayer(ModelLayers.DOUBLE_CHEST_RIGHT))

    companion object {
        private val TRANSFORMATIONS: Map<Direction, Transformation> = Util.makeEnumMap(Direction::class.java) { createModelTransformation(it) }

        @JvmStatic
        fun modelTransformation(facing: Direction): Transformation = TRANSFORMATIONS[facing]!!

        private fun createModelTransformation(facing: Direction): Transformation =
            Transformation(Matrix4f().rotationAround(Axis.YP.rotationDegrees(-facing.toYRot()), 0.5f, 0.0f, 0.5f))

        private fun getChestMaterial(entity: BlockEntity): TwilightChestRenderState.TwilightChestMaterialType {
            return when(val block = entity.blockState.block) {
                TwilightBlocks.TWILIGHT_OAK_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TWILIGHT_OAK
                TwilightBlocks.TRAPPED_TWILIGHT_OAK_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TWILIGHT_OAK
                TwilightBlocks.CANOPY_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.CANOPY
                TwilightBlocks.TRAPPED_CANOPY_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_CANOPY
                TwilightBlocks.TWILIGHT_MANGROVE_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TWILIGHT_MANGROVE
                TwilightBlocks.TRAPPED_TWILIGHT_MANGROVE_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TWILIGHT_MANGROVE
                TwilightBlocks.DARKWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.DARKWOOD
                TwilightBlocks.TRAPPED_DARKWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_DARKWOOD
                TwilightBlocks.TIMEWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TIMEWOOD
                TwilightBlocks.TRAPPED_TIMEWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TIMEWOOD
                TwilightBlocks.TRANSWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRANSWOOD
                TwilightBlocks.TRAPPED_TRANSWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TRANSWOOD
                TwilightBlocks.MINEWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.MINEWOOD
                TwilightBlocks.TRAPPED_MINEWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_MINEWOOD
                TwilightBlocks.SORTWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.SORTWOOD
                TwilightBlocks.TRAPPED_SORTWOOD_CHEST -> TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_SORTWOOD
                else -> throw IllegalStateException("Unknown twilight chest material: $block")
            }
        }
    }

    override fun createRenderState(): TwilightChestRenderState = TwilightChestRenderState()

    override fun extractRenderState(blockEntity: T, state: TwilightChestRenderState, partialTicks: Float, cameraPosition: Vec3, breakProgress: ModelFeatureRenderer.CrumblingOverlay?) {
        super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress)

        val hasLevel = blockEntity.level != null
        val blockState: BlockState = if (hasLevel) {
            blockEntity.blockState
        } else {
            Blocks.CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH)
        }

        state.type = if (blockState.hasProperty(ChestBlock.TYPE)) blockState.getValue(ChestBlock.TYPE) else ChestType.SINGLE
        state.facing = blockState.getValue(ChestBlock.FACING)
        state.material = getChestMaterial(blockEntity)

        val combineResult: DoubleBlockCombiner.NeighborCombineResult<out ChestBlockEntity> =
            if (hasLevel && blockState.block is ChestBlock) {
                (blockState.block as ChestBlock).combine(blockState, blockEntity.level!!, blockEntity.blockPos, true)
            } else {
                object : DoubleBlockCombiner.NeighborCombineResult<ChestBlockEntity> {
                    override fun <R : Any> apply(callback: DoubleBlockCombiner.Combiner<in ChestBlockEntity, R>): R {
                        @Suppress("UNCHECKED_CAST")
                        return when {
                            Float2FloatFunction::class.java.isAssignableFrom(callback.javaClass) ->
                                Float2FloatFunction.identity() as R
                            Int2IntFunction::class.java.isAssignableFrom(callback.javaClass) ->
                                Int2IntFunction.identity() as R
                            else -> throw IllegalStateException("Unhandled type for combineResult")
                        }
                    }
                }
            }

        state.open = combineResult.apply(ChestBlock.opennessCombiner(blockEntity))[partialTicks]
        if (state.type != ChestType.SINGLE) {
            state.lightCoords = (combineResult.apply(BrightnessCombiner())).applyAsInt(state.lightCoords)
        }
    }

    override fun submit(state: TwilightChestRenderState, poseStack: PoseStack, submitNodeCollector: SubmitNodeCollector, camera: CameraRenderState) {
        poseStack.pushPose()
        poseStack.mulPose(modelTransformation(state.facing))

        var open = state.open
        open = 1.0f - open
        open = 1.0f - open * open * open

        val spriteId: SpriteId = TwilightSheets.chooseSprite(state.material, state.type)
        val renderType: RenderType = spriteId.renderType(RenderTypes::entityCutoutCull)
        val sprite: TextureAtlasSprite = sprites[spriteId]

        val model: ChestModel = when (state.type) {
            ChestType.SINGLE -> singleModel
            ChestType.LEFT -> doubleLeftModel
            ChestType.RIGHT -> doubleRightModel
        }

        submitNodeCollector.submitModel(
            model,
            open,
            poseStack,
            renderType,
            state.lightCoords,
            OverlayTexture.NO_OVERLAY,
            -1,
            sprite,
            0,
            state.breakProgress
        )

        poseStack.popPose()
    }
}