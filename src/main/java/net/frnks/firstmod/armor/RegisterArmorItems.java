package net.frnks.firstmod.armor;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RegisterArmorItems {
    public static final ArmorMaterial POOP_ARMOR_MATERIAL = new PoopArmorMaterial();
    public static final Item POOP_ARMOR_HELMET = new ArmorItem(POOP_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings());
    public static final Item POOP_ARMOR_CHESTPLATE = new ArmorItem(POOP_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings());
    public static final Item POOP_ARMOR_LEGGINGS = new ArmorItem(POOP_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings());
    public static final Item POOP_ARMOR_BOOTS = new ArmorItem(POOP_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings());

    public static void register(ItemGroup itemGroup) {
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_armor_helmet"), POOP_ARMOR_HELMET);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_armor_chestplate"), POOP_ARMOR_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_armor_leggings"), POOP_ARMOR_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_armor_boots"), POOP_ARMOR_BOOTS);

        var itemList = new ArrayList<Item>();
        itemList.add(POOP_ARMOR_HELMET);
        itemList.add(POOP_ARMOR_CHESTPLATE);
        itemList.add(POOP_ARMOR_LEGGINGS);
        itemList.add(POOP_ARMOR_BOOTS);

        for ( var item: itemList) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(item));
        }
    }
}
