@file:Suppress("SameParameterValue", "MemberVisibilityCanBePrivate")

package me.mycf.discord_example.items

import me.mycf.discord_example.MainFile
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object ModIdItems {
    private var ItemRegistry = linkedMapOf<String, Item>()


    /**
     * Register [net.minecraft.item.Item]s in here.
     */
    init {
    }

    private fun addItem(name: String, item: Item): Item {
        val correctedName = name.lowercase().trim()
        ItemRegistry[correctedName] = item
        return item
    }

    public fun registerItems() {
        ItemRegistry.forEach {
            Registry.register(Registry.ITEM, Identifier(MainFile.MOD_ID, it.key), it.value)
        }
    }
}