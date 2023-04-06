package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.frnks.firstmod.block.IronCropBlock;
import net.frnks.firstmod.item.IronSeed;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
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
//                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 9))))
//                ;
//        addDrop(applyExplosionDecay(IronCropBlock.IRON_CROP_BLOCK, LootTable.builder()
//                .pool(LootPool.builder()
//                        .with((ItemEntry.builder(Items.IRON_NUGGET)
//                                        .conditionally(BlockStatePropertyLootCondition.builder(IronCropBlock.IRON_CROP_BLOCK)
//                                                .properties(StatePredicate.Builder.create()
//                                                        .exactMatch(IntProperty.of("age", 0, 7), 7)
//                                        )
//                                )
//                        ).alternatively(ItemEntry.builder(IronSeed.IRON_SEED))))
//                .pool(LootPool.builder()
//                        .conditionally(BlockStatePropertyLootCondition.builder(IronCropBlock.IRON_CROP_BLOCK)
//                                .properties(StatePredicate.Builder.create()
//                                        .exactMatch(IntProperty.of("age", 0, 7), 7)
//                                ))
//                        .with((LootPoolEntry.Builder<?>)((Object)ItemEntry.builder(IronSeed.IRON_SEED)
//                                .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)))))));

//                addDrop(IronCropBlock.IRON_CROP_BLOCK, LootTable.builder()
//                        .pool(LootPool.builder()
//                                .rolls(ConstantLootNumberProvider.create(1.0F))
//                                .with(ItemEntry.builder(Items.IRON_NUGGET)
//                                        .apply(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(1.0F, 9.0F))))
//                                .with(ItemEntry.builder(IronSeed.IRON_SEED)
//                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 3.0F))))
//                                .conditionally(BlockStatePropertyLootCondition.builder(IronCropBlock.IRON_CROP_BLOCK).properties(StatePredicate.Builder.create().exactMatch(IntProperty.of("age", 0, 7), 7)))));
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
