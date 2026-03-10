package io.autumn.twilight.list

import io.autumn.twilight.Twilight
import io.autumn.twilight.blockentityrenderer.custom.state.TwilightChestRenderState
import net.minecraft.client.renderer.SpriteMapper
import net.minecraft.client.resources.model.sprite.SpriteId
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.state.properties.ChestType

object TwilightSheets {
    private val CHEST_MAPPER: SpriteMapper = SpriteMapper(Identifier.withDefaultNamespace("textures/atlas/chest.png"), "entity/chest")

    val TWILIGHT_OAK_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_oak"))
    val TWILIGHT_OAK_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_oak_left"))
    val TWILIGHT_OAK_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_oak_right"))

    val TWILIGHT_OAK_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_oak"))
    val TWILIGHT_OAK_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_oak_left"))
    val TWILIGHT_OAK_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_oak_right"))

    val CANOPY_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("canopy"))
    val CANOPY_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("canopy_left"))
    val CANOPY_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("canopy_right"))

    val CANOPY_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_canopy"))
    val CANOPY_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_canopy_left"))
    val CANOPY_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_canopy_right"))

    val TWILIGHT_MANGROVE_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_mangrove"))
    val TWILIGHT_MANGROVE_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_mangrove_left"))
    val TWILIGHT_MANGROVE_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("twilight_mangrove_right"))

    val TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_mangrove"))
    val TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_mangrove_left"))
    val TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_twilight_mangrove_right"))

    val DARKWOOD_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("darkwood"))
    val DARKWOOD_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("darkwood_left"))
    val DARKWOOD_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("darkwood_right"))

    val DARKWOOD_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_darkwood"))
    val DARKWOOD_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_darkwood_left"))
    val DARKWOOD_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_darkwood_right"))

    val TIMEWOOD_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("timewood"))
    val TIMEWOOD_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("timewood_left"))
    val TIMEWOOD_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("timewood_right"))

    val TIMEWOOD_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_timewood"))
    val TIMEWOOD_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_timewood_left"))
    val TIMEWOOD_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_timewood_right"))

    val TRANSWOOD_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("transwood"))
    val TRANSWOOD_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("transwood_left"))
    val TRANSWOOD_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("transwood_right"))

    val TRANSWOOD_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_transwood"))
    val TRANSWOOD_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_transwood_left"))
    val TRANSWOOD_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_transwood_right"))

    val MINEWOOD_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("minewood"))
    val MINEWOOD_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("minewood_left"))
    val MINEWOOD_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("minewood_right"))

    val MINEWOOD_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_minewood"))
    val MINEWOOD_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_minewood_left"))
    val MINEWOOD_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_minewood_right"))

    val SORTWOOD_CHEST_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("sortwood"))
    val SORTWOOD_CHEST_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("sortwood_left"))
    val SORTWOOD_CHEST_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("sortwood_right"))

    val SORTWOOD_CHEST_TRAP_LOCATION: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_sortwood"))
    val SORTWOOD_CHEST_TRAP_LOCATION_LEFT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_sortwood_left"))
    val SORTWOOD_CHEST_TRAP_LOCATION_RIGHT: SpriteId = CHEST_MAPPER.apply(Twilight.namespaceAndPath("trapped_sortwood_right"))

    fun chooseSprite(materialType: TwilightChestRenderState.TwilightChestMaterialType, type: ChestType): SpriteId =
        when (materialType) {
            TwilightChestRenderState.TwilightChestMaterialType.TWILIGHT_OAK -> chooseSprite(type, TWILIGHT_OAK_CHEST_LOCATION, TWILIGHT_OAK_CHEST_LOCATION_LEFT, TWILIGHT_OAK_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TWILIGHT_OAK -> chooseSprite(type, TWILIGHT_OAK_CHEST_TRAP_LOCATION, TWILIGHT_OAK_CHEST_TRAP_LOCATION_LEFT, TWILIGHT_OAK_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.CANOPY -> chooseSprite(type, CANOPY_CHEST_LOCATION, CANOPY_CHEST_LOCATION_LEFT, CANOPY_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_CANOPY -> chooseSprite(type, CANOPY_CHEST_TRAP_LOCATION, CANOPY_CHEST_TRAP_LOCATION_LEFT, CANOPY_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TWILIGHT_MANGROVE -> chooseSprite(type, TWILIGHT_MANGROVE_CHEST_LOCATION, TWILIGHT_MANGROVE_CHEST_LOCATION_LEFT, TWILIGHT_MANGROVE_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TWILIGHT_MANGROVE -> chooseSprite(type, TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION, TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION_LEFT, TWILIGHT_MANGROVE_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.DARKWOOD -> chooseSprite(type, DARKWOOD_CHEST_LOCATION, DARKWOOD_CHEST_LOCATION_LEFT, DARKWOOD_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_DARKWOOD -> chooseSprite(type, DARKWOOD_CHEST_TRAP_LOCATION, DARKWOOD_CHEST_TRAP_LOCATION_LEFT, DARKWOOD_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TIMEWOOD -> chooseSprite(type, TIMEWOOD_CHEST_LOCATION, TIMEWOOD_CHEST_LOCATION_LEFT, TIMEWOOD_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TIMEWOOD -> chooseSprite(type, TIMEWOOD_CHEST_TRAP_LOCATION, TIMEWOOD_CHEST_TRAP_LOCATION_LEFT, TIMEWOOD_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRANSWOOD -> chooseSprite(type, TRANSWOOD_CHEST_LOCATION, TRANSWOOD_CHEST_LOCATION_LEFT, TRANSWOOD_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_TRANSWOOD -> chooseSprite(type, TRANSWOOD_CHEST_TRAP_LOCATION, TRANSWOOD_CHEST_TRAP_LOCATION_LEFT, TRANSWOOD_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.MINEWOOD -> chooseSprite(type, MINEWOOD_CHEST_LOCATION, MINEWOOD_CHEST_LOCATION_LEFT, MINEWOOD_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_MINEWOOD -> chooseSprite(type, MINEWOOD_CHEST_TRAP_LOCATION, MINEWOOD_CHEST_TRAP_LOCATION_LEFT, MINEWOOD_CHEST_TRAP_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.SORTWOOD -> chooseSprite(type, SORTWOOD_CHEST_LOCATION, SORTWOOD_CHEST_LOCATION_LEFT, SORTWOOD_CHEST_LOCATION_RIGHT)
            TwilightChestRenderState.TwilightChestMaterialType.TRAPPED_SORTWOOD -> chooseSprite(type, SORTWOOD_CHEST_TRAP_LOCATION, SORTWOOD_CHEST_TRAP_LOCATION_LEFT, SORTWOOD_CHEST_TRAP_LOCATION_RIGHT)
        }

    private fun chooseSprite(type: ChestType, single: SpriteId, left: SpriteId, right: SpriteId): SpriteId =
        when (type) {
            ChestType.LEFT -> left
            ChestType.RIGHT -> right
            ChestType.SINGLE -> single
        }
}