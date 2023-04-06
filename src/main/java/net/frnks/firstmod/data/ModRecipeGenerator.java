package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.frnks.firstmod.item.IronSeed;
import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
//        offerSingleOutputShapelessRecipe(exporter, IronSeed.IRON_SEED, Items.IRON_NUGGET, RecipeCategory.MISC.getName());
//        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, IronSeed.IRON_SEED)
//                .input(Ingredient.ofItems(Items.IRON_NUGGET, Items.WHEAT_SEEDS))
//                .offerTo(exporter);

//        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, IronSeed.IRON_SEED)
//                .pattern("AAA")
//                .pattern("ABA")
//                .pattern("AAA")
//                .input('A', Items.IRON_NUGGET)
//                .input('B', Items.WHEAT_SEEDS)
//                .criterion(FabricRecipeProvider.hasItem(Items.IRON_NUGGET), FabricRecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
//                .criterion(FabricRecipeProvider.hasItem(Items.WHEAT_SEEDS), FabricRecipeProvider.conditionsFromItem(Items.WHEAT_SEEDS))
//                .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(IronSeed.IRON_SEED)));

        offerCompactingRecipe(exporter, RecipeCategory.MISC, Items.IRON_NUGGET, IronSeed.IRON_SEED, "nope");
    }
}
