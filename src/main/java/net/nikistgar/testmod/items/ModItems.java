package net.nikistgar.testmod.items;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikistgar.testmod.TestMod;
import net.nikistgar.testmod.items.custom.MoonItem;
import net.nikistgar.testmod.items.custom.SunItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> SUNSTONE = ITEMS.register("sun_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> MOONSTONE = ITEMS.register("moon_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> PURIFIEDSUNSTONE = ITEMS.register("purified_sun_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> PURIFIEDMOONSTONE = ITEMS.register("purified_moon_stone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> MOON = ITEMS.register("moon",
            () -> new MoonItem(Tiers.WOOD, 6, -1.6f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1).durability(4000).fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> SUN = ITEMS.register("sun",
            () -> new SunItem(Tiers.WOOD, 6, -1.6f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1).durability(4000).fireResistant().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
