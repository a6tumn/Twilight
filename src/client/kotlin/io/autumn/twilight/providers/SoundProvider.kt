package io.autumn.twilight.providers

import io.autumn.twilight.sound.TwilightSounds
import net.fabricmc.fabric.api.client.datagen.v1.builder.SoundTypeBuilder
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricSoundsProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.sounds.SoundEvents
import java.util.concurrent.CompletableFuture

class SoundProvider(output: PackOutput, registriesFuture: CompletableFuture<HolderLookup.Provider>) : FabricSoundsProvider(output, registriesFuture) {
    override fun configure(holderLookup: HolderLookup.Provider, soundExporter: SoundExporter) {
        soundExporter.add(TwilightSounds.TIMEWOOD_CORE_ACTIVE,
            SoundTypeBuilder.of(TwilightSounds.TIMEWOOD_CORE_ACTIVE)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofEvent(SoundEvents.COMPARATOR_CLICK))
                .subtitle("Timewood Core Active")
        )
        soundExporter.add(TwilightSounds.TRANSWOOD_CORE_ACTIVE,
            SoundTypeBuilder.of(TwilightSounds.TRANSWOOD_CORE_ACTIVE)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofEvent(SoundEvents.NOTE_BLOCK_HARP))
                .subtitle("Transwood Core Active")
        )
        soundExporter.add(TwilightSounds.MINEWOOD_CORE_ACTIVE,
            SoundTypeBuilder.of(TwilightSounds.MINEWOOD_CORE_ACTIVE)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofEvent(SoundEvents.EXPERIENCE_ORB_PICKUP))
                .subtitle("Minewood Core Active")
        )
        soundExporter.add(TwilightSounds.SORTWOOD_CORE_ACTIVE,
            SoundTypeBuilder.of(TwilightSounds.SORTWOOD_CORE_ACTIVE)
                .sound(SoundTypeBuilder.RegistrationBuilder.ofEvent(SoundEvents.PISTON_EXTEND))
                .subtitle("Sortwood Core Active")
        )
    }

    override fun getName(): String = "SoundProvider"
}