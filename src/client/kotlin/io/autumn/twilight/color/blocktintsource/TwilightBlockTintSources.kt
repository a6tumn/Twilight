package io.autumn.twilight.color.blocktintsource

import net.minecraft.client.color.block.BlockTintSource
import net.minecraft.client.renderer.BiomeColors
import net.minecraft.client.renderer.block.BlockAndTintGetter
import net.minecraft.core.BlockPos
import net.minecraft.world.level.block.state.BlockState

object TwilightBlockTintSources {
    fun rainbowFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = -12012264

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {

                var red = pos.x * 32 + pos.y * 16
                if ((red and 256) != 0) red = 255 - (red and 255)
                red = red and 255

                var green = pos.y * 32 + pos.z * 16
                if ((green and 256) != 0) green = 255 - (green and 255)
                green = green xor 255

                var blue = pos.x * 16 + pos.z * 32
                if ((blue and 256) != 0) blue = 255 - (blue and 255)
                blue = blue and 255

                return (0xFF shl 24) or (red shl 16) or (green shl 8) or blue
            }
        }
    }
    fun canopyFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = -12012264

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                val base = BiomeColors.getAverageFoliageColor(level, pos)
                return canopyColorize(base)
            }
        }
    }

    fun mangroveFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = -12012264

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                val base = BiomeColors.getAverageFoliageColor(level, pos)
                return mangroveColorize(base)
            }
        }
    }

    fun timewoodFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = 0xFF000000.toInt() or (106 shl 16) or (156 shl 8) or 23

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                var fade = pos.x * 16 + pos.y * 16 + pos.z * 16

                if ((fade and 256) != 0) {
                    fade = 255 - (fade and 255)
                }
                fade = fade and 255

                val spring = (255 - fade) / 255f
                val fall = fade / 255f

                val red = (spring * 106 + fall * 251).toInt()
                val green = (spring * 156 + fall * 108).toInt()
                val blue = (spring * 23 + fall * 27).toInt()

                return 0xFF000000.toInt() or (red shl 16) or (green shl 8) or blue
            }
        }
    }

    fun transwoodFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = 0xFF000000.toInt() or (108 shl 16) or (204 shl 8) or 234

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                var fade = pos.x * 27 + pos.y * 63 + pos.z * 39

                if ((fade and 256) != 0) {
                    fade = 255 - (fade and 255)
                }
                fade = fade and 255

                val spring = (255 - fade) / 255f
                val fall = fade / 255f

                val red = (spring * 108 + fall * 96).toInt()
                val green = (spring * 204 + fall * 107).toInt()
                val blue = (spring * 234 + fall * 121).toInt()

                return 0xFF000000.toInt() or (red shl 16) or (green shl 8) or blue
            }
        }
    }

    fun minewoodFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = 0xFF000000.toInt() or (252 shl 16) or (241 shl 8) or 68

            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                var fade = pos.x * 31 + pos.y * 33 + pos.z * 32

                if ((fade and 256) != 0) {
                    fade = 255 - (fade and 255)
                }
                fade = fade and 255

                val spring = (255 - fade) / 255f
                val fall = fade / 255f

                val red = (spring * 252 + fall * 237).toInt()
                val green = (spring * 241 + fall * 172).toInt()
                val blue = (spring * 68 + fall * 9).toInt()

                return 0xFF000000.toInt() or (red shl 16) or (green shl 8) or blue
            }
        }
    }

    fun sortwoodFoliage(): BlockTintSource {
        return object : BlockTintSource {
            override fun color(state: BlockState): Int = 0xFF000000.toInt() or (54 shl 16) or (76 shl 8) or 3
            override fun colorInWorld(state: BlockState, level: BlockAndTintGetter, pos: BlockPos): Int {
                var fade = pos.x * 63 + pos.y * 63 + pos.z * 63

                if ((fade and 256) != 0) {
                    fade = 255 - (fade and 255)
                }
                fade = fade and 255

                val spring = (255 - fade) / 255f
                val fall = fade / 255f

                val red = (spring * 54 + fall * 168).toInt()
                val green = (spring * 76 + fall * 199).toInt()
                val blue = (spring * 3 + fall * 43).toInt()

                return 0xFF000000.toInt() or (red shl 16) or (green shl 8) or blue
            }
        }
    }

    private fun canopyColorize(color: Int): Int = 0xFF000000.toInt() or (((color and 0xFEFEFE) + 0x469A66) / 2)

    private fun mangroveColorize(color: Int): Int = 0xFF000000.toInt() or (((color and 0xFEFEFE) + 0xC0E694) / 2)

}