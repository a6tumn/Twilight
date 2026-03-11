package io.autumn.twilight

import io.autumn.twilight.bootstrap.TwilightBiomes
import io.autumn.twilight.bootstrap.TwilightDimensionTypes
import io.autumn.twilight.bootstrap.TwilightTreeConfigurations
import io.autumn.twilight.providers.*
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries

object TwilightDataGenerator : DataGeneratorEntrypoint {
	override fun onInitializeDataGenerator(fabricDataGenerator: FabricDataGenerator) {
		val pack = fabricDataGenerator.createPack()

		pack.addProvider(::BlockTagsProvider)
		pack.addProvider(::ItemTagsProvider)
		pack.addProvider(::BlockLootTableProvider)
		pack.addProvider(::EnglishLangProvider)
		pack.addProvider(::ModelProvider)
		pack.addProvider(::AdvancementProvider)
		pack.addProvider(::RecipeProvider)
		pack.addProvider(::EnchantmentProvider)
		pack.addProvider(::DynamicRegistryProvider)
		pack.addProvider(::SoundProvider)
	}

	override fun buildRegistry(registryBuilder: RegistrySetBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, TwilightTreeConfigurations::bootstrap)
		registryBuilder.add(Registries.BIOME, TwilightBiomes::bootstrap)
		registryBuilder.add(Registries.DIMENSION_TYPE, TwilightDimensionTypes::bootstrap)
        registryBuilder.add(Registries.ENCHANTMENT, EnchantmentProvider::bootstrap)
	}
}