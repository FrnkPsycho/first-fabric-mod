package net.frnks.firstmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frnks.firstmod.data.*;

public class FirstModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModAdvancementGenerator::new);
        pack.addProvider(ModEnglishLangProvider::new);
//        pack.addProvider(ModTagGenerator::new);
//        pack.addProvider(ModWorldGenerator::new);
    }
}
