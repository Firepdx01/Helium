package net.fIrepdx.bbclient.mixin;

import net.fIrepdx.bbclient.modules.Velocity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class VelocityMixin {
    
    @Inject(method = "setVelocityClient", at = @At("HEAD"), cancellable = true)
    private void modifyVelocity(double x, double y, double z, CallbackInfo ci) {
        if (Velocity.isEnabled()) {
            ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
            
            // Apply velocity multipliers
            double modifiedX = x * Velocity.getHorizontalMultiplier();
            double modifiedZ = z * Velocity.getHorizontalMultiplier();
            double modifiedY = y * Velocity.getVerticalMultiplier();
            
            player.setVelocity(new Vec3d(modifiedX, modifiedY, modifiedZ));
            ci.cancel();
        }
    }
}