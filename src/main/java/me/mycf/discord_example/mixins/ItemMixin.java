package me.mycf.discord_example.mixins;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow
    public abstract Item asItem();

    @Inject(method = "isFireproof", at = @At("HEAD"), cancellable = true)
    private void ironIngotsDontBurn(CallbackInfoReturnable<Boolean> cir) {
        if (this.asItem().equals(Items.IRON_INGOT)) {
            cir.setReturnValue(true);
        }
    }
}
