package me.mycf.discord_example.mixins;

import net.minecraft.enchantment.MendingEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MendingEnchantment.class)
public class MendingEnchantmentMixin {

    @ModifyConstant(
            method = "Lnet/minecraft/enchantment/MendingEnchantment;getMaxLevel()I",
            constant = @Constant(intValue = 1))
    int neweIntValue(int oldValue) {
        return 23;
    }

}
