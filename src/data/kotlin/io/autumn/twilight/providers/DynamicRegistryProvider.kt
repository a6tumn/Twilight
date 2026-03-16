package io.autumn.twilight.providers

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import java.util.concurrent.CompletableFuture

class DynamicRegistryProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricDynamicRegistryProvider(output, registriesFuture) {
    override fun configure(registries: HolderLookup.Provider, entries: Entries) {
        entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE))
        entries.addAll(registries.lookupOrThrow(Registries.BIOME))
        entries.addAll(registries.lookupOrThrow(Registries.DIMENSION_TYPE))
    }

    override fun getName(): String = "DynamicRegistryProvider"
}