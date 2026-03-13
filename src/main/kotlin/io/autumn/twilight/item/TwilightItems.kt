package io.autumn.twilight.item

import io.autumn.torchberry.annotations.OnInitialize
import io.autumn.twilight.Twilight
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.Rarity

object TwilightItems {

    val RAVEN_FEATHER: Item = register(Twilight.namespaceAndPath("raven_feather"), ::Item, Item.Properties())
    val TOWER_KEY = register(Twilight.namespaceAndPath("tower_key"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON).fireResistant())
    val BORER_ESSENCE = register(Twilight.namespaceAndPath("borer_essence"), ::Item, Item.Properties())
    val CARMINITE = register(Twilight.namespaceAndPath("carminite"), ::Item, Item.Properties())

    val NAGA_SCALE = register(Twilight.namespaceAndPath("naga_scale"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val LIVEROOT = register(Twilight.namespaceAndPath("liveroot"), ::Item, Item.Properties())
    val RAW_IRONWOOD = register(Twilight.namespaceAndPath("raw_ironwood"), ::Item, Item.Properties())
    val IRONWOOD_INGOT = register(Twilight.namespaceAndPath("ironwood_ingot"), ::Item, Item.Properties())
    val STEELEAF_INGOT = register(Twilight.namespaceAndPath("steeleaf_ingot"), ::Item, Item.Properties())
    val FIERY_BLOOD = register(Twilight.namespaceAndPath("fiery_blood"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val FIERY_TEARS = register(Twilight.namespaceAndPath("fiery_tears"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))
    val FIERY_INGOT = register(Twilight.namespaceAndPath("fiery_ingot"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON).fireResistant())
    val ARMOR_SHARD = register(Twilight.namespaceAndPath("armor_shard"), ::Item, Item.Properties())
    val ARMOR_SHARD_CLUSTER = register(Twilight.namespaceAndPath("armor_shard_cluster"), ::Item, Item.Properties())
    val KNIGHTMETAL_INGOT = register(Twilight.namespaceAndPath("knightmetal_ingot"), ::Item, Item.Properties())
    val ARCTIC_FUR = register(Twilight.namespaceAndPath("arctic_fur"), ::Item, Item.Properties())
    val ALPHA_YETI_FUR = register(Twilight.namespaceAndPath("alpha_yeti_fur"), ::Item, Item.Properties().rarity(Rarity.UNCOMMON))

    fun <T : Item> register(
        nameSpaceAndPath: Identifier,
        itemFactory: (Item.Properties) -> T,
        settings: Item.Properties
    ): T {
        val itemKey: ResourceKey<Item> = ResourceKey.create(
            Registries.ITEM,
            nameSpaceAndPath
        )
        
        val item: T = itemFactory(settings.setId(itemKey))
        
        Registry.register(BuiltInRegistries.ITEM, itemKey, item)

        return item
    }
    
    @OnInitialize
    fun initialize() {
        Twilight.LOGGER?.info("Registering items for ${Twilight.NAMESPACE}.")
    }
}