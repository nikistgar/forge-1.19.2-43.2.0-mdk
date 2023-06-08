package net.nikistgar.testmod.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;

public class IgnitedEffect extends MobEffect {
    int ticks = 0;
    public IgnitedEffect(MobEffectCategory mobEffectCategory, int color)
    {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        ticks ++;
        if (ticks >= 40)
        {
            pLivingEntity.hurt(DamageSource.MAGIC, 2);
            ticks = 0;
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}