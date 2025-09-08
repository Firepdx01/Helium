package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.modules.NoFall;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class NoFallMixin {
    
    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void preventFallDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (NoFall.isEnabled() && source.isOf(net.minecraft.entity.damage.DamageTypes.FALL)) {
            cir.setReturnValue(false);
        }
    }
}