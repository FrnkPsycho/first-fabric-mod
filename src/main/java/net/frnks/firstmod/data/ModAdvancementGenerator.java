package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.frnks.firstmod.FirstMod;
import net.frnks.firstmod.block.IronCropBlock;
import net.frnks.firstmod.item.IronSeed;
import net.frnks.firstmod.item.Poop;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.PlacedBlockCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementGenerator extends FabricAdvancementProvider {
    public ModAdvancementGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {
        new ModAdvancements().accept(consumer);
    }
}

class ModAdvancements implements  Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> advancementConsumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        FirstMod.poop,
                        Text.translatable("advancement.get_first_poop_title"),
                        Text.translatable("advancement.get_first_poop_description"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("get_poop", InventoryChangedCriterion.Conditions.items(FirstMod.poop))
                .build(advancementConsumer, "firstmod" + "/root");

        Advancement getIronSeedAdvancement = Advancement.Builder.create()
                .display(
                        IronSeed.IRON_SEED,
                        Text.translatable("advancement.get_iron_seed_title"),
                        Text.translatable("advancement.get_iron_seed_description"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .parent(rootAdvancement)
                .rewards(AdvancementRewards.Builder.experience(100))
                .criterion("get_iron_seed", InventoryChangedCriterion.Conditions.items(IronSeed.IRON_SEED))
                .build(advancementConsumer, "firstmod" + "/get_iron_seed");

        Advancement plantIronCropAdvancemnet = Advancement.Builder.create()
                .display(
                        Items.IRON_NUGGET,
                        Text.translatable("advancement.plant_iron_crop_title"),
                        Text.translatable("advancement.plant_iron_crop_description"),
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .parent(getIronSeedAdvancement)
                .criterion("plant_iron_crop", PlacedBlockCriterion.Conditions.block(IronCropBlock.IRON_CROP_BLOCK))
                .build(advancementConsumer, "firstmod" + "/plant_iron_crop");
    }
}