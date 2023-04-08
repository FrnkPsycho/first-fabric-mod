package net.frnks.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RegisterItems {
//    public static final Item POOP = new Poop(new FabricItemSettings());
    public static final Item POOP_BRICK = new PoopBrick(new FabricItemSettings());

    public static void register(ItemGroup itemGroup) {
//        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop"), POOP); Do not register Poop because it is registered at entry class.
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_brick"), POOP_BRICK);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "iron_seed"), IronSeed.IRON_SEED);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "strange_food"), StrangeFood.STRANGE_FOOD);

        // Add to Fuel


        // Add to ItemGroup
        var itemList = new ArrayList<Item>();
        itemList.add(POOP_BRICK);
        itemList.add(IronSeed.IRON_SEED);
        itemList.add(StrangeFood.STRANGE_FOOD);
        for ( var item: itemList) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(item));
        }
    }
}
