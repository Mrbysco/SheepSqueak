package com.mrbysco.sheepsqueak.registration;

import com.mrbysco.sheepsqueak.Constants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

/**
 * Example class for item registration
 */
public class ModSounds {
	public static final RegistrationProvider<SoundEvent> SOUND_EVENTS = RegistrationProvider.get(BuiltInRegistries.SOUND_EVENT, Constants.MOD_ID);

	public static final RegistryObject<SoundEvent> SQUEAK = SOUND_EVENTS.register("squeak", () ->
			SoundEvent.createVariableRangeEvent(new ResourceLocation(Constants.MOD_ID, "squeak")));


	// Called in the mod initializer / constructor in order to make sure that items are registered
	public static void loadClass() {
	}
}
