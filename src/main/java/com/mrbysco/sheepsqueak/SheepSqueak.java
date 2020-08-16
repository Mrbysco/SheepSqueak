package com.mrbysco.sheepsqueak;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SheepSqueak.MOD_ID)
public class SheepSqueak {
    public static final String MOD_ID = "sheepsqueak";
    private static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);
    public static final RegistryObject<SoundEvent> SQUEAK = SOUND_EVENTS.register("squeak", () -> new SoundEvent(new ResourceLocation(MOD_ID, "squeak")));

    public SheepSqueak() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SOUND_EVENTS.register(eventBus);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void playSoundAtEntityEvent(LivingHurtEvent event) {
            DamageSource source = event.getSource();
            Entity damageSource = source.getTrueSource();
            LivingEntity hurtEntity = event.getEntityLiving();
            if(hurtEntity instanceof SheepEntity) {
                SheepEntity sheep = (SheepEntity)hurtEntity;
                if(!sheep.getSheared()) {
                    sheep.world.playSound((PlayerEntity)null, sheep.getPosition(), SheepSqueak.SQUEAK.get(), SoundCategory.NEUTRAL, 1.0F, 1.0F);
                }
            }
        }
    }
}
