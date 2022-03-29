package com.mrbysco.sheepsqueak;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Constants.MOD_ID)
public class SheepSqueakForge {
	public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Constants.MOD_ID);
	public static final RegistryObject<SoundEvent> SQUEAK = SOUND_EVENTS.register("squeak", () -> new SoundEvent(new ResourceLocation(Constants.MOD_ID, "squeak")));

	public SheepSqueakForge() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SOUND_EVENTS.register(eventBus);

		MinecraftForge.EVENT_BUS.addListener(this::onLivingHurt);
	}

	private void onLivingHurt(LivingHurtEvent event) {
		LivingEntity hurtEntity = event.getEntityLiving();
		if (hurtEntity instanceof Sheep sheep && !sheep.isSheared()) {
			sheep.level.playSound((Player) null, sheep.blockPosition(), SQUEAK.get(), SoundSource.NEUTRAL, 1.0F, 1.0F);
		}
	}
}