package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.frnks.firstmod.FirstMod;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

public class RegisterBlocks {
    public static void register(ItemGroup itemGroup) {
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_bricks"), PoopBricks.POOP_BRICKS);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_bricks_stairs"), PoopBricksStairs.POOP_BRICKS_STAIRS);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "lightning_block"), LightningBlock.LIGHTNING_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_bricks_vertical_slab"), PoopBricksVerticalSlab.POOP_BRICKS_VERTICAL_SLAB);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "polished_andesite_vertical_slab"), PolishedAndesiteVerticalSlab.POLISHED_ANDESITE_VERTICAL_SLAB);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_chest_block"), PoopChestBlock.POOP_CHEST_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "poop_barrel_block"), PoopBarrelBlock.POOP_BARREL_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "invisible_block"), InvisibleBlock.INVISIBLE_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("firstmod", "transparent_block"), TransparentBlock.TRANSPARENT_BLOCK);
        Registry.register(Registries.BLOCK, TopSidedFurnaceBlock.TOP_SIDED_FURNACE_ID, TopSidedFurnaceBlock.TOP_SIDED_FURNACE);
        Registry.register(Registries.BLOCK, AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK_ID, AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK);
        Registry.register(Registries.BLOCK, IronCropBlock.IRON_CROP_BLOCK_ID, IronCropBlock.IRON_CROP_BLOCK);


        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_bricks"), PoopBricks.POOP_BRICKS_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_bricks_stairs"), PoopBricksStairs.POOP_BRICKS_STAIRS_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "lightning_block"), LightningBlock.LIGHTNING_BLOCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_bricks_vertical_slab"), PoopBricksVerticalSlab.POOP_BRICKS_VERTICAL_SLAB_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "polished_andesite_vertical_slab"), PolishedAndesiteVerticalSlab.POLISHED_ANDESITE_VERTICAL_SLAB_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_chest_block"), PoopChestBlock.POOP_CHEST_BLOCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "poop_barrel_block"), PoopBarrelBlock.POOP_BARREL_BLOCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "invisible_block"), InvisibleBlock.INVISIBLE_BLOCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("firstmod", "transparent_block"), TransparentBlock.TRANSPARENT_BLOCK_ITEM);
        Registry.register(Registries.ITEM, TopSidedFurnaceBlock.TOP_SIDED_FURNACE_ID, TopSidedFurnaceBlock.TOP_SIDED_FURNACE_ITEM);
        Registry.register(Registries.ITEM, AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK_ID, AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK_ITEM);

        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("firstmod", "poop_chest_block"), PoopChestBlockEntity.POOP_CHEST_BLOCK_ENTITY);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("firstmod", "poop_barrel_block"), PoopBarrelBlockEntity.POOP_BARREL_BLOCK_ENTITY);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, TopSidedFurnaceBlock.TOP_SIDED_FURNACE_ID, TopSidedFurnaceBlockEntity.TOP_SIDED_FURNACE_BLOCK_ENTITY);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK_ID, AwesomeJukeboxBlockEntity.AWESOME_JUKEBOX_BLOCK_ENTITY);

        // Add to ItemGroup
        var itemList = new ArrayList<Item>();
        itemList.add(PoopBricks.POOP_BRICKS_ITEM);
        itemList.add(PoopBricksStairs.POOP_BRICKS_STAIRS_ITEM);
        itemList.add(PoopBricksVerticalSlab.POOP_BRICKS_VERTICAL_SLAB_ITEM);
        itemList.add(PolishedAndesiteVerticalSlab.POLISHED_ANDESITE_VERTICAL_SLAB_ITEM);
        itemList.add(LightningBlock.LIGHTNING_BLOCK_ITEM);
        itemList.add(PoopChestBlock.POOP_CHEST_BLOCK_ITEM);
        itemList.add(PoopBarrelBlock.POOP_BARREL_BLOCK_ITEM);
        itemList.add(InvisibleBlock.INVISIBLE_BLOCK_ITEM);
        itemList.add(TransparentBlock.TRANSPARENT_BLOCK_ITEM);
        itemList.add(TopSidedFurnaceBlock.TOP_SIDED_FURNACE_ITEM);
        itemList.add(AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK_ITEM);
        for ( var item: itemList) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> content.add(item));
        }

        PoopOreBlocks.register();
        RedMapleTreeBlocks.register();
        RegisterFlammableBlocks.register();
        RegisterStrippableBlocks.register();
    }

    public static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }
//    public static final BlockEntityType<PoopChestBlockEntity> POOP_CHEST_BLOCK_ENTITY =
//            FabricBlockEntityTypeBuilder.create(
//                    PoopChestBlockEntity::new,
//                    PoopChestBlock.POOP_CHEST_BLOCK
//            ).build();
//
//    public static BlockEntityType<? extends BlockEntity> registerBlockEntity(String name, Block block, BlockEntity blockEntity) {
//        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(FirstMod.MOD_ID, name),
//                FabricBlockEntityTypeBuilder.create(
//                        blockEntity.getClass()::new,
//                        block
//                ).build()
//        );
//    }
}
