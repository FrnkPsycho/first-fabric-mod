package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;


public class ModTagGenerator extends FabricTagProvider<Item> {
    private static final TagKey<Item> DELICIOUS_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("firstmod", "delicious_items"));

    /**
     * Constructs a new {@link FabricTagProvider} with the default computed path.
     *
     * <p>Common implementations of this class are provided.
     *
     * @param output           the {@link FabricDataOutput} instance
     * @param registryKey
     * @param registriesFuture the backing registry for the tag type
     */
    public ModTagGenerator(FabricDataOutput output, RegistryKey<? extends Registry<Item>> registryKey, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registryKey, registriesFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(DELICIOUS_ITEMS)
                .add(Items.ROTTEN_FLESH)
                .add(Items.SLIME_BALL)
                .add(Items.SPIDER_EYE)
                .add(Items.POISONOUS_POTATO)
                .addOptionalTag(ItemTags.DIRT);
    }
}
