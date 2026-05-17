package com.mrbysco.sheepsqueak;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.world.entity.animal.sheep.Sheep;

public class SheepSqueakFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		CommonClass.init();

		ServerLivingEntityEvents.AFTER_DAMAGE.register((hurtEntity, source,
		                                                baseDamageTaken, damageTaken, blocked) -> {
			if (hurtEntity instanceof Sheep sheep && !sheep.isSheared()) {
				CommonClass.playSqueak(sheep);
			}
		});
	}
}
