package net.nikistgar.testmod.datagen;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.client.RecipeBookCategories;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.nikistgar.testmod.TestMod;
import net.nikistgar.testmod.blocks.ModBlocks;
import net.nikistgar.testmod.items.ModItems;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {

        oreSmelting(pFinishedRecipeConsumer, List.of(ModItems.SUN_STONE.get()),
                ModItems.PURIFIED_SUN_STONE.get(), 0.7f, 200, "purified_sun_stone");

        oreSmelting(pFinishedRecipeConsumer, List.of(ModItems.MOON_STONE.get()),
                ModItems.PURIFIED_MOON_STONE.get(), 0.7f, 200, "purified_sun_stone");

        ShapedRecipeBuilder.shaped(ModItems.SUN.get())
                .define('S', Items.STICK)
                .define('G', Items.GOLD_INGOT)
                .define('P', ModItems.PURIFIED_SUN_STONE.get())
                .pattern(" GP")
                .pattern("GPG")
                .pattern("SG ")
                .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                                         .of(ModItems.PURIFIED_SUN_STONE.get()).build()))
                .save(pFinishedRecipeConsumer);

        ShapedRecipeBuilder.shaped(ModItems.MOON.get())
                .define('S', Items.STICK)
                .define('G', Items.GOLD_INGOT)
                .define('P', ModItems.PURIFIED_MOON_STONE.get())
                .pattern(" GP")
                .pattern("GPG")
                .pattern("SG ")
                .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.PURIFIED_MOON_STONE.get()).build()))
                .save(pFinishedRecipeConsumer);

        //nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_OPAL.get(), RecipeCategory.MISC,
        //        ModBlocks.BLACK_OPAL_BLOCK.get());

        // ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
        //         .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
        //         .save(consumer);

        // ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLACK_OPAL_BLOCK.get())
        //         .define('B', ModItems.BLACK_OPAL.get())
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .pattern("BBB")
        //         .unlockedBy("has_black_opal", inventoryTrigger(ItemPredicate.Builder.item()
        //                 .of(ModItems.BLACK_OPAL.get()).build()))
        //         .save(consumer);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_176592_, List<ItemLike> p_176593_, ItemLike p_176594_, float p_176595_, int p_176596_, String p_176597_) {
        oreCooking(p_176592_, RecipeSerializer.SMELTING_RECIPE, p_176593_, p_176594_, p_176595_, p_176596_, p_176597_, "_from_smelting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_176534_, SimpleCookingSerializer<?> p_176535_, List<ItemLike> p_176536_, ItemLike p_176537_, float p_176538_, int p_176539_, String p_176540_, String p_176541_) {
        for(ItemLike itemlike : p_176536_) {
            SimpleCookingRecipeBuilder.cooking(Ingredient.of(itemlike), p_176537_, p_176538_, p_176539_, p_176535_).group(p_176540_)
                    .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_176534_, new ResourceLocation(TestMod.MOD_ID,getItemName(p_176537_) + p_176541_ + "_" + getItemName(itemlike)));
        }

    }

    //protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> p_251817_, List<ItemLike> p_249619_, RecipeBookCategories p_251154_, ItemLike p_250066_, float p_251871_, int p_251316_, String p_251450_, String p_249236_) {
    //    for(ItemLike itemlike : p_249619_) {
    //        SimpleCookingRecipeBuilder.smelting(Ingredient.of(itemlike), p_251154_, p_250066_, p_251871_, p_251316_, p_251817_).group(p_251450_)
    //                .unlockedBy(getHasName(itemlike), has(itemlike)).save(p_250791_, new ResourceLocation(TutorialMod.MOD_ID, getItemName(p_250066_)) + p_249236_ + "_" + getItemName(itemlike));
    //    }
    //}

    //protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_249580_, RecipeCategory p_251203_, ItemLike p_251689_, RecipeCategory p_251376_, ItemLike p_248771_) {
    //    nineBlockStorageRecipes(p_249580_, p_251203_, p_251689_, p_251376_, p_248771_, getSimpleRecipeName(p_248771_), (String)null, getSimpleRecipeName(p_251689_), (String)null);
    //}

    //protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> p_250423_, RecipeCategory p_250083_, ItemLike p_250042_,
    //                                              RecipeCategory p_248977_, ItemLike p_251911_, String p_250475_, @Nullable String p_248641_,
    //                                              String p_252237_, @Nullable String p_250414_) {
    //    ShapelessRecipeBuilder.shapeless(p_250083_, p_250042_, 9).requires(p_251911_).group(p_250414_).unlockedBy(getHasName(p_251911_), has(p_251911_))
    //            .save(p_250423_, new ResourceLocation(TutorialMod.MOD_ID, p_252237_));
    //    ShapedRecipeBuilder.shaped(p_248977_, p_251911_).define('#', p_250042_).pattern("###").pattern("###").pattern("###").group(p_248641_)
    //            .unlockedBy(getHasName(p_250042_), has(p_250042_)).save(p_250423_, new ResourceLocation(TutorialMod.MOD_ID, p_250475_));
}
