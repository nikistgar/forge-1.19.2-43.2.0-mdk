package net.nikistgar.testmod.datagen;

import net.nikistgar.testmod.TestMod;
import net.nikistgar.testmod.blocks.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.SUN_STONE_ORE.get());
        simpleBlock(ModBlocks.MOON_STONE_ORE.get());
    }
}
