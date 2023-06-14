package net.nikistgar.testmod.datagen.loot;

import net.minecraft.data.loot.BlockLoot;
import net.nikistgar.testmod.blocks.ModBlocks;
import net.nikistgar.testmod.items.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.add(ModBlocks.SUN_STONE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.SUN_STONE_ORE.get(), ModItems.SUN_STONE.get()));

        this.add(ModBlocks.MOON_STONE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.MOON_STONE_ORE.get(), ModItems.MOON_STONE.get()));

        this.dropSelf(ModBlocks.ALTAR.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
