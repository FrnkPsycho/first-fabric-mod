package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RegisterBlocks {
    public static void register(ItemGroup itemGroup) {
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_bricks"), PoopBricks.POOP_BRICKS);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_bricks"), PoopBricks.POOP_BRICKS_ITEM);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_bricks_stairs"), PoopBricksStairs.POOP_BRICKS_STAIRS);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_bricks_stairs"), PoopBricksStairs.POOP_BRICKS_STAIRS_ITEM);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "lightning_block"), LightningBlock.LIGHTNING_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "lightning_block"), LightningBlock.LIGHTNING_BLOCK_ITEM);

        // Add to ItemGroup
        var itemList = new ArrayList<Item>();
        itemList.add(PoopBricks.POOP_BRICKS_ITEM);
        itemList.add(PoopBricksStairs.POOP_BRICKS_STAIRS_ITEM);
        itemList.add(LightningBlock.LIGHTNING_BLOCK_ITEM);
        itemList.add(LightningBlock.LIGHTNING_BLOCK_ITEM);
        for ( var item: itemList) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(item));
        }
    }
}
