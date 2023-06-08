package net.nikistgar.testmod.items;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikistgar.testmod.TestMod;
public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TEST_TAB)));

    public static final RegistryObject<Item> SUN = ITEMS.register("sun",
            () -> new SwordItem(Tiers.WOOD, 0, -2.4f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1)));

    public static final RegistryObject<Item> MOON = ITEMS.register("moon",
            () -> new SwordItem(Tiers.WOOD, 13, -1.6f,
                    new Item.Properties().tab(ModCreativeModeTab.TEST_TAB).stacksTo(1).durability(4000).fireResistant().rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
