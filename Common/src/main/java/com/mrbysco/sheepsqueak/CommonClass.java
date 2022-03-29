package com.mrbysco.sheepsqueak;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class CommonClass {

	public static void playSqueak(LivingEntity entity, SoundEvent sound) {
		entity.level.playSound((Player) null, entity.blockPosition(), sound, SoundSource.NEUTRAL, 1.0F, 1.0F);
	}
}