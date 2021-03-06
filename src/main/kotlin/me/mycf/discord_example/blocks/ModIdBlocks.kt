@file:Suppress("SameParameterValue", "MemberVisibilityCanBePrivate")

package me.mycf.discord_example.blocks

import me.mycf.discord_example.MainFile
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.Blocks
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModIdBlocks {
    private var BlockItemsRegistry = linkedMapOf<String, Item>()
    private var BlockRegistry = linkedMapOf<String, Block>()

    val COOLIO: Block

    /**
     * Register blocks in here.
     * [net.minecraft.item.BlockItem] gets added automatically.
     * If you wish to change the settings of the BlockItem implement your own methods for it.
     */
    init {
        COOLIO = addBlock("cool_block", Block(AbstractBlock.Settings.copy(Blocks.STONE)))
    }

    private fun addBlock(name: String, block: Block): Block {
        val correctedName = name.lowercase().trim()
        BlockRegistry[correctedName] = block
        BlockItemsRegistry[correctedName + "_item"] =
            (BlockItem(block, Item.Settings().maxCount(64).group(ItemGroup.MISC)))
        return block
    }

    fun registerBlocks() {
        BlockRegistry.forEach {
            Registry.register(Registry.BLOCK, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
        registerBlockItems()
    }

    private fun registerBlockItems() {
        BlockItemsRegistry.forEach {
            Registry.register(Registry.ITEM, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
    }
}