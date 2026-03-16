package io.autumn.twilight.block.custom

import io.autumn.carminite.math.VoxelBresenhamIterator
import io.autumn.twilight.lists.TwilightBlockTags
import io.autumn.twilight.sound.TwilightSounds
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.server.level.ServerLevel
import net.minecraft.sounds.SoundSource
import net.minecraft.util.RandomSource
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState

class MinewoodCoreBlock(properties: Properties) : MagicLogCoreBlock(properties) {
    override fun performTreeEffect(level: ServerLevel, pos: BlockPos, rand: RandomSource) {
        val dPos = randomOffset(rand, pos, 16)
        val moved = doMagnet(level, pos, dPos, true)

        if (moved > 0) {
            level.playSound(
                null,
                pos,
                TwilightSounds.MINEWOOD_CORE_ACTIVE,
                SoundSource.BLOCKS,
                0.1f,
                1.0f
            )
        }
    }

    override fun doesCoreFunction(): Boolean = true

    fun doMagnet(level: Level, usePos: BlockPos, destPos: BlockPos, sourceIsMineCore: Boolean): Int {
        var blocksMoved = 0

        var attractedOreBlock: BlockState = Blocks.AIR.defaultBlockState()
        var replacementBlock: BlockState = Blocks.AIR.defaultBlockState()
        var foundPos: BlockPos? = null
        var basePos: BlockPos? = null

        for (coord in VoxelBresenhamIterator(usePos, destPos)) {
            val searchState = level.getBlockState(coord)

            if (basePos == null) {
                if (isReplaceable(searchState)) {
                    basePos = coord
                }
            } else if (
                foundPos == null &&
                searchState.block != Blocks.AIR &&
                isOre(searchState.block, sourceIsMineCore) &&
                level.getBlockEntity(coord) == null
            ) {
                attractedOreBlock = searchState
                replacementBlock =
                    (if (sourceIsMineCore) TREE_ORE_TO_BLOCK_REPLACEMENTS else MAGNET_ORE_TO_BLOCK_REPLACEMENTS)
                        .getOrDefault(attractedOreBlock.block, Blocks.STONE)
                        .defaultBlockState()
                foundPos = coord
            }
        }

        if (basePos != null && foundPos != null && attractedOreBlock.block != Blocks.AIR) {
            val veinBlocks: MutableSet<BlockPos> = HashSet()
            findVein(level, foundPos, attractedOreBlock, veinBlocks)

            val offX = basePos.x - foundPos.x
            val offY = basePos.y - foundPos.y
            val offZ = basePos.z - foundPos.z

            for (coord in veinBlocks) {
                val replacePos = coord.offset(offX, offY, offZ)
                val replaceState = level.getBlockState(replacePos)

                if (isReplaceable(replaceState) || replaceState.canBeReplaced() || replaceState.isAir) {
                    level.setBlock(coord, replacementBlock, UPDATE_CLIENTS)

                    level.setBlock(replacePos, attractedOreBlock, UPDATE_CLIENTS)
                    blocksMoved++
                }
            }
        }

        return blocksMoved
    }

    private fun isReplaceable(state: BlockState): Boolean = state.`is`(TwilightBlockTags.ORE_MAGNET_SAFE_REPLACE_BLOCK.tagKey)

    private fun findVein(level: Level, here: BlockPos, oreState: BlockState, veinBlocks: MutableSet<BlockPos>): Boolean {
        if (here in veinBlocks) {
            return false
        }

        if (veinBlocks.size >= 24) {
            return false
        }

        if (level.getBlockState(here) == oreState) {
            veinBlocks.add(here)

            for (dir in Direction.entries) {
                findVein(level, here.relative(dir), oreState, veinBlocks)
            }

            return true
        } else {
            return false
        }
    }

    private fun isOre(ore: Block, core: Boolean): Boolean {
        return (if (core) TREE_ORE_TO_BLOCK_REPLACEMENTS else MAGNET_ORE_TO_BLOCK_REPLACEMENTS)
            .containsKey(ore)
    }

    private fun randomOffset(random: RandomSource, pos: BlockPos, rx: Int, ry: Int, rz: Int): BlockPos {
        val dx = random.nextInt(rx * 2 + 1) - rx
        val dy = random.nextInt(ry * 2 + 1) - ry
        val dz = random.nextInt(rz * 2 + 1) - rz
        return pos.offset(dx, dy, dz)
    }

    private fun randomOffset(random: RandomSource, pos: BlockPos, range: Int): BlockPos = randomOffset(random, pos, range, range, range)

    companion object {
        val MAGNET_ORE_TO_BLOCK_REPLACEMENTS: MutableMap<Block, Block> = HashMap()
        val TREE_ORE_TO_BLOCK_REPLACEMENTS: MutableMap<Block, Block> = HashMap()

        init {
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.COPPER_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.IRON_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.GOLD_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DIAMOND_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.LAPIS_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.EMERALD_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.REDSTONE_ORE] = Blocks.STONE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_COPPER_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_IRON_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_GOLD_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_DIAMOND_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_LAPIS_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_EMERALD_ORE] = Blocks.DEEPSLATE
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.DEEPSLATE_REDSTONE_ORE] = Blocks.DEEPSLATE

            TREE_ORE_TO_BLOCK_REPLACEMENTS.putAll(MAGNET_ORE_TO_BLOCK_REPLACEMENTS)

            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.NETHER_GOLD_ORE] = Blocks.NETHERRACK
            MAGNET_ORE_TO_BLOCK_REPLACEMENTS[Blocks.NETHER_QUARTZ_ORE] = Blocks.NETHERRACK
            TREE_ORE_TO_BLOCK_REPLACEMENTS[Blocks.NETHER_GOLD_ORE] = Blocks.NETHERRACK
            TREE_ORE_TO_BLOCK_REPLACEMENTS[Blocks.NETHER_QUARTZ_ORE] = Blocks.NETHERRACK

            MAGNET_ORE_TO_BLOCK_REPLACEMENTS.putIfAbsent(Blocks.ANCIENT_DEBRIS, Blocks.NETHERRACK)
            TREE_ORE_TO_BLOCK_REPLACEMENTS.putIfAbsent(Blocks.ANCIENT_DEBRIS, Blocks.NETHERRACK)
        }
    }
}