package com.mrbysco.sheepsqueak;

import net.minecraft.world.entity.animal.Sheep;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingHurtEvent;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SheepSqueakForge {

	public SheepSqueakForge() {
		CommonClass.init();

		NeoForge.EVENT_BUS.addListener(this::onLivingHurt);
	}

	private void onLivingHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof Sheep sheep && !sheep.isSheared()) {
			CommonClass.playSqueak(sheep);
		}
	}
}