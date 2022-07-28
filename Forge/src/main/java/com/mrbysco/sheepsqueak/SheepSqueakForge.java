package com.mrbysco.sheepsqueak;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.animal.Sheep;
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
		if (event.getEntity() instanceof Sheep sheep && !sheep.isSheared()) {
			CommonClass.playSqueak(sheep, SQUEAK.get());
		}
	}
}