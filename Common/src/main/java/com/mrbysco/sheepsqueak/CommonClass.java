package com.mrbysco.sheepsqueak;

import com.mrbysco.sheepsqueak.registration.ModSounds;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CommonClass {

	public static void init() {
		ModSounds.loadClass();
	}

	public static void playSqueak(LivingEntity entity) {
		entity.level.playSound((Player) null, entity.blockPosition(), ModSounds.SQUEAK.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
	}
}