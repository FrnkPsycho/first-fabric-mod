package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public class ModEnglishLangProvider extends FabricLanguageProvider {
    public ModEnglishLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add("advancement.get_first_poop_title", "Poop = digest(food)");
        translationBuilder.add("advancement.get_first_poop_description", "errrrr...gross");

        try {
            Path filePath = dataOutput.getModContainer().findPath("assets/firstmod/lang/en_us.json").get();
            translationBuilder.add(filePath);
        } catch (Exception e ) {
            throw new RuntimeException("Failed");
        }
    }
}
