package com.mrbysco.sheepsqueak;

import net.minecraft.world.entity.animal.Sheep;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class SheepSqueakForge {

	public SheepSqueakForge() {
		CommonClass.init();

		MinecraftForge.EVENT_BUS.addListener(this::onLivingHurt);
	}

	private void onLivingHurt(LivingHurtEvent event) {
		if (event.getEntity() instanceof Sheep sheep && !sheep.isSheared()) {
			CommonClass.playSqueak(sheep);
		}
	}
}