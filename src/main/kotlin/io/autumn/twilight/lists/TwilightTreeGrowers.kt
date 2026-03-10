package io.autumn.twilight.lists

import io.autumn.twilight.bootstrap.TwilightTreeConfigurations
import net.minecraft.world.level.block.grower.TreeGrower
import java.util.Optional

object TwilightTreeGrowers {
    val TWILIGHT_OAK = TreeGrower(
        "twilight_oak",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.of(TwilightTreeConfigurations.TWILIGHT_OAK),
        Optional.of(TwilightTreeConfigurations.FANCY_TWILIGHT_OAK),
        Optional.empty(),
        Optional.empty()
    )
    val RAINBOW_OAK = TreeGrower(
    "rainbow_oak",
    0.1f,
    Optional.empty(),
    Optional.empty(),
    Optional.of(TwilightTreeConfigurations.RAINBOW_OAK),
    Optional.of(TwilightTreeConfigurations.FANCY_RAINBOW_OAK),
    Optional.empty(),
    Optional.empty()
    )
    val CANOPY = TreeGrower(
        "canopy",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.of(TwilightTreeConfigurations.CANOPY),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val TWILIGHT_MANGROVE = TreeGrower(
        "twilight_mangrove",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.of(TwilightTreeConfigurations.TWILIGHT_MANGROVE),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val DARKWOOD = TreeGrower(
        "darkwood",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.of(TwilightTreeConfigurations.DARKWOOD),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val TIMEWOOD = TreeGrower(
        "timewood",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.of(TwilightTreeConfigurations.TIMEWOOD),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val TRANSWOOD = TreeGrower(
        "transwood",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val MINEWOOD = TreeGrower(
        "minewood",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
    val SORTWOOD = TreeGrower(
        "sortwood",
        0.1f,
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty(),
        Optional.empty()
    )
}