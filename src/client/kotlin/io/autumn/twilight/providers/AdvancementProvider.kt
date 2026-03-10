package io.autumn.twilight.providers

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider
import net.minecraft.advancements.AdvancementHolder
import net.minecraft.core.HolderLookup
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AdvancementProvider(output: FabricPackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricAdvancementProvider(output, registriesFuture) {
    override fun generateAdvancement(registryLookup: HolderLookup.Provider, consumer: Consumer<AdvancementHolder>) {
        //WIP
    }
}