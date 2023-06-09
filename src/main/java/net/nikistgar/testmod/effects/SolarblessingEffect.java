package net.nikistgar.testmod.effects;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class SolarblessingEffect extends MobEffect {
    int ticks = 0;
    public SolarblessingEffect(MobEffectCategory mobEffectCategory, int color)
    {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        ModEffects.SOLARBLESSING.get().addAttributeModifier(Attributes.ATTACK_DAMAGE, "91AEAA56-376B-4498-935B-2F7F68070635", 7, AttributeModifier.Operation.ADDITION);
        ticks ++;
        if (ticks >= 60)
        {
            pLivingEntity.heal(1);
            ticks = 0;
        }
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}