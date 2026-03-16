package io.autumn.twilight.providers

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.enchantment.Enchantment
import java.util.concurrent.CompletableFuture

class EnchantmentProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    companion object {
        fun bootstrap(context: BootstrapContext<Enchantment>){}
    }

    private fun register(context: BootstrapContext<Enchantment>, key: ResourceKey<Enchantment>, builder: Enchantment.Builder){ context.register(key, builder.build(key.identifier())) }

    override fun configure(registries: HolderLookup.Provider, entries: Entries) { entries.addAll(registries.lookupOrThrow(Registries.ENCHANTMENT)) }

    override fun getName(): String = "EnchantmentProvider"
}