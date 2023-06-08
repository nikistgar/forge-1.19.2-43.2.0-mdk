package net.nikistgar.testmod.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikistgar.testmod.TestMod;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TestMod.MOD_ID);

    public static final RegistryObject<MobEffect> FROZEN = MOB_EFFECTS.register("frozen",
            () -> new FrozenEffect(MobEffectCategory.HARMFUL, 2222222));

    public static final RegistryObject<MobEffect> IGNITED = MOB_EFFECTS.register("ignited",
            () -> new IgnitedEffect(MobEffectCategory.HARMFUL, 2222222));

    public static final RegistryObject<MobEffect> LUNARBLESSING = MOB_EFFECTS.register("lunarblessing",
            () -> new SolarblessingEffect(MobEffectCategory.BENEFICIAL, 0000000));

    public static final RegistryObject<MobEffect> SOLARBLESSING = MOB_EFFECTS.register("solarblessing",
            () -> new SolarblessingEffect(MobEffectCategory.BENEFICIAL, 0000000));

    public static void register(IEventBus eventBus)
    {
        MOB_EFFECTS.register(eventBus);
    }
}
