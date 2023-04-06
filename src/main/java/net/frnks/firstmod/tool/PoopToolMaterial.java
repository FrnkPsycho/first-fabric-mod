package net.frnks.firstmod.tool;

import net.frnks.firstmod.item.Poop;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class PoopToolMaterial implements ToolMaterial {
    public static final PoopToolMaterial INSTANCE = new PoopToolMaterial();

    @Override
    public int getDurability() {
        return 300;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(new Poop(new FabricItemSettings()));
    }
}
