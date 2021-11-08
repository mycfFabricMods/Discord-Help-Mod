package me.mycf.discord_example.mixins;

import net.minecraft.block.MapColor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(MapColor.class)
public interface MapColorMixin {

    @Invoker("<init>")
    static MapColor callConstructor(int id, int color) {
        throw new AssertionError("Called Mixed in method not correct method");
    }
}
