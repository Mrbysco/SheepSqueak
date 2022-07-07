package com.mrbysco.sheepsqueak.mixin;

import com.mrbysco.sheepsqueak.callback.LivingHurtCallback;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

	@Inject(method = "actuallyHurt",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/world/entity/LivingEntity;getDamageAfterArmorAbsorb(Lnet/minecraft/world/damagesource/DamageSource;F)F",
					shift = Shift.BEFORE,
					ordinal = 0))
	private void sheepsqueak_postTick(CallbackInfo ci) {
		LivingHurtCallback.EVENT.invoker().onHurt((LivingEntity) (Object) this);
	}
}