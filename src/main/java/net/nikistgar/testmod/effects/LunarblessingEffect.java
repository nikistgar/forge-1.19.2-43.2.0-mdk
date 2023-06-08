package net.nikistgar.testmod.effects;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class LunarblessingEffect extends MobEffect {
    public LunarblessingEffect(MobEffectCategory mobEffectCategory, int color)
    {
        super(mobEffectCategory, color);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier)
    {
        ModEffects.LUNARBLESSING.get().addAttributeModifier(Attributes.ATTACK_DAMAGE, "91AEAA56-376B-4498-935B-2F7F68070635", 7, AttributeModifier.Operation.ADDITION);
        ModEffects.LUNARBLESSING.get().addAttributeModifier(Attributes.MOVEMENT_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL);
        ModEffects.LUNARBLESSING.get().addAttributeModifier(Attributes.ATTACK_SPEED, "91AEAA56-376B-4498-935B-2F7F68070635", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier)
    {
        return true;
    }
}