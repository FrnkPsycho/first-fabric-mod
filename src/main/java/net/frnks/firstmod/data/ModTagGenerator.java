package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.frnks.firstmod.FirstMod;
import net.frnks.firstmod.block.RedMapleTreeBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class ModTagGenerator extends FabricTagProvider.ItemTagProvider {
    public static final TagKey<Item> DELICIOUS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("firstmod", "delicious_items"));
    public ModTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DELICIOUS_ITEMS)
                .add(Items.ROTTEN_FLESH)
                .add(Items.SLIME_BALL)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO)
                .addOptionalTag(ItemTags.DIRT);
        getOrCreateTagBuilder(RedMapleTreeBlocks.RED_MAPLE_LOGS)
                .add(RedMapleTreeBlocks.RED_MAPLE_LOG_ITEM)
                .add(RedMapleTreeBlocks.RED_MAPLE_WOOD_ITEM)
                .add(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG_ITEM)
                .add(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_WOOD_ITEM);
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(RedMapleTreeBlocks.RED_MAPLE_PLANKS_ITEM);
    }
}
