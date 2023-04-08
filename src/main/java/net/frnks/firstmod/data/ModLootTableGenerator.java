package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frnks.firstmod.block.IronCropBlock;
import net.frnks.firstmod.block.RedMapleTreeBlocks;
import net.frnks.firstmod.item.IronSeed;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.state.property.IntProperty;

import java.util.Collection;


public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(IronCropBlock.IRON_CROP_BLOCK, CustomCropDrops(IronCropBlock.IRON_CROP_BLOCK, Items.IRON_NUGGET, IronSeed.IRON_SEED,
                1, 2,
                BlockStatePropertyLootCondition.builder(IronCropBlock.IRON_CROP_BLOCK)
                .properties(StatePredicate.Builder.create()
                        .exactMatch(IntProperty.of("age", 0, 7), 7))));

        addDrop(RedMapleTreeBlocks.RED_MAPLE_LOG, new BlockItem(RedMapleTreeBlocks.RED_MAPLE_LOG, new FabricItemSettings()));
        addDrop(RedMapleTreeBlocks.RED_MAPLE_WOOD, new BlockItem(RedMapleTreeBlocks.RED_MAPLE_WOOD, new FabricItemSettings()));
        addDrop(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG, new BlockItem(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG, new FabricItemSettings()));
        addDrop(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_WOOD, new BlockItem(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_WOOD, new FabricItemSettings()));
        addDrop(RedMapleTreeBlocks.RED_MAPLE_PLANKS, new BlockItem(RedMapleTreeBlocks.RED_MAPLE_PLANKS, new FabricItemSettings()));
        addDrop(RedMapleTreeBlocks.RED_MAPLE_SAPLING, new BlockItem(RedMapleTreeBlocks.RED_MAPLE_SAPLING, new FabricItemSettings()));

    }

    public LootTable.Builder CustomCropDrops(Block crop, Item product, Item seeds, float minProductDrop, float maxProductDrop ,LootCondition.Builder condition) {
        return this.applyExplosionDecay(crop, LootTable.builder()
                .pool(LootPool.builder()
                        .with((ItemEntry.builder(product)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minProductDrop, maxProductDrop)))
                                .conditionally(condition))
                                .alternatively(ItemEntry.builder(seeds))))
                .pool(LootPool.builder()
                        .conditionally(condition)
                        .with(ItemEntry.builder(seeds)
                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)))));
    }
}
