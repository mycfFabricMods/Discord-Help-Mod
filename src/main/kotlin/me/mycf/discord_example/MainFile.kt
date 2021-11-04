package me.mycf.discord_example

import me.mycf.discord_example.blocks.ModIdBlocks
import me.mycf.discord_example.items.ModIdItems
import net.fabricmc.api.ModInitializer


/**
 * Main File
 * VM options for mixins:
 * -Dmixin.debug.export=true (exports mixins into run/mixin.out/)
 * -Dmixin.debug=true (turns on all debugging features)
 */
@Suppress("UNUSED")
object MainFile : ModInitializer {
    const val MOD_ID = "discord_example"


    override fun onInitialize() {
        ModIdBlocks.registerBlocks()
        ModIdItems.registerItems()
    }
}
