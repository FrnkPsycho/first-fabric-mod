package net.frnks.firstmod.world;

import net.frnks.firstmod.FirstMod;
import net.frnks.firstmod.block.PoopOreBlocks;
import net.frnks.firstmod.block.RedMapleTreeBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfigureFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MAPLE_KEY = registryKey("red_maple_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> POOP_ORE_KEY = registryKey("poop_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, RED_MAPLE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RedMapleTreeBlocks.RED_MAPLE_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(RedMapleTreeBlocks.RED_MAPLE_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4),
                new TwoLayersFeatureSize(1, 0, 2)
        ).build());

        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> overworldPoopOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, PoopOreBlocks.POOP_ORE_BLOCK.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, PoopOreBlocks.DEEPSLATE_POOP_ORE_BLOCK.getDefaultState()));
        register(context, POOP_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPoopOres, 6));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FirstMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key,
                                                                                   F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
