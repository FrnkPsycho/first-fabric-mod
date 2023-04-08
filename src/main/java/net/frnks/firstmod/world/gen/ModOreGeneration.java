package net.frnks.firstmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.frnks.firstmod.world.ModOrePlacementFeatures;
import net.frnks.firstmod.world.ModPlaceFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlaceFeatures.POOP_ORE_PLACED_KEY);
    }
}
