package net.nikistgar.testmod.items.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.nikistgar.testmod.effects.ModEffects;

public class MoonItem extends SwordItem {
    public MoonItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (Minecraft.getInstance().level.getDayTime() >= 13000) {
            pAttacker.addEffect(new MobEffectInstance(ModEffects.LUNARBLESSING.get(), 200), pAttacker);
            if (pAttacker.hasEffect(ModEffects.LUNARBLESSING.get()))
            {
                pTarget.addEffect(new MobEffectInstance(ModEffects.FROZEN.get(), 200), pAttacker);
            }
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
