package com.mrbysco.sheepsqueak;

import com.mrbysco.sheepsqueak.callback.LivingHurtCallback;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.Sheep;

public class SheepSqueakFabric implements ModInitializer {
	public static final SoundEvent SQUEAK = new SoundEvent(new ResourceLocation(Constants.MOD_ID, "squeak"));

	@Override
	public void onInitialize() {
		Registry.register(Registry.SOUND_EVENT, SQUEAK.getLocation(), SQUEAK);

		LivingHurtCallback.EVENT.register((hurtEntity) -> {
			if (hurtEntity instanceof Sheep sheep && !sheep.isSheared()) {
				CommonClass.playSqueak(sheep, SQUEAK);
			}
			return InteractionResult.PASS;
		});
	}
}
