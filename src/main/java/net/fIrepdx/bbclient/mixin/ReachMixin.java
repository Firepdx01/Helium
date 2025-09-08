package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.modules.Reach;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ReachMixin {
    
    @Inject(method = "getReachDistance", at = @At("HEAD"), cancellable = true)
    private void modifyReachDistance(CallbackInfoReturnable<Float> cir) {
        if (Reach.isEnabled()) {
            cir.setReturnValue((float) Reach.getReachDistance());
        }
    }
}