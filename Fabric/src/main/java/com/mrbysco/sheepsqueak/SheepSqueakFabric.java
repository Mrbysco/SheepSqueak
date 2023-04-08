package com.mrbysco.sheepsqueak;

import com.mrbysco.sheepsqueak.callback.LivingHurtCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;

public class SheepSqueakFabric implements ModInitializer {

	@Override
	public void onInitialize() {
		CommonClass.init();
		
		LivingHurtCallback.EVENT.register((hurtEntity) -> {
			if (hurtEntity instanceof Sheep sheep && !sheep.isSheared()) {
				CommonClass.playSqueak(sheep);
			}
			return InteractionResult.PASS;
		});
	}
}
