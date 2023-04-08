package net.frnks.firstmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frnks.firstmod.data.*;
import net.frnks.firstmod.world.ModConfigureFeatures;
import net.frnks.firstmod.world.ModPlaceFeatures;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class FirstModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModAdvancementGenerator::new);
//        pack.addProvider(ModEnglishLangProvider::new);
        pack.addProvider(ModTagGenerator::new);
        pack.addProvider(ModWorldGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfigureFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlaceFeatures::bootstrap);
    }
}
