package com.mrbysco.sheepsqueak.callback;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;

public interface LivingHurtCallback {
	Event<LivingHurtCallback> EVENT = EventFactory.createArrayBacked(LivingHurtCallback.class,
			(listeners) -> (livingEntity) -> {
				for (LivingHurtCallback event : listeners) {
					InteractionResult result = event.onHurt(livingEntity);

					if (result != InteractionResult.PASS) {
						return result;
					}
				}

				return InteractionResult.PASS;
			}
	);

	InteractionResult onHurt(LivingEntity livingEntity);
}
