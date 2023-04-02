package net.frnks.firstmod.tool;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RegisterToolItems {
    public static final ToolItem POOP_PICKAXE = new PoopPickaxeItem(PoopToolMaterial.INSTANCE, 1, -2.8F, new Item.Settings() );
    public static final ToolItem POOP_SWORD = new SwordItem(PoopToolMaterial.INSTANCE, 5, 1.5F, new Item.Settings());

    public static void register(ItemGroup itemGroup) {
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_sword"), POOP_SWORD);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_pickaxe"), POOP_PICKAXE);


        var itemList = new ArrayList<Item>();
        itemList.add(POOP_PICKAXE);
        itemList.add(POOP_SWORD);

        for ( var item: itemList) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(item));
        }
    }
}

class PoopPickaxeItem extends PickaxeItem {

    public PoopPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}