package net.frnks.firstmod.world;

import net.frnks.firstmod.FirstMod;
import net.frnks.firstmod.block.RedMapleTreeBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModPlaceFeatures {
    public static final RegistryKey<PlacedFeature> RED_MAPLE_PLACED_KEY = registryKey("red_maple_tree_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var lookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, RED_MAPLE_PLACED_KEY, lookup.getOrThrow(ModConfigureFeatures.RED_MAPLE_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), RedMapleTreeBlocks.RED_MAPLE_SAPLING));
    }
    private static void register(Registerable<PlacedFeature> context,
                                 RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(FirstMod.MOD_ID, name));
    }
}
