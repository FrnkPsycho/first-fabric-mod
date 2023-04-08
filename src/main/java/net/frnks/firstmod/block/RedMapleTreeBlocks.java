package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frnks.firstmod.FirstMod;
import net.frnks.firstmod.world.tree.RedMapleSaplingGenerator;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class RedMapleTreeBlocks {
//    public static final Block RED_MAPLE_LOG = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "red_maple_log"),
//            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f).requiresTool()));
    public static final TagKey<Item> RED_MAPLE_LOGS = TagKey.of(RegistryKeys.ITEM, new Identifier(FirstMod.MOD_ID, "red_maple_items"));
    public static final Block RED_MAPLE_LOG = RegisterBlocks.registerBlock("red_maple_log",
        new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4.0f).requiresTool()));
    public static final Block RED_MAPLE_WOOD = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "red_maple_wood"),
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f).requiresTool()));
    public static final Block STRIPPED_RED_MAPLE_LOG = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "stripped_red_maple_log"),
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(4f).requiresTool()));
    public static final Block STRIPPED_RED_MAPLE_WOOD = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "stripped_red_maple_wood"),
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f).requiresTool()));
    public static final Block RED_MAPLE_PLANKS = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "red_maple_planks"),
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f).requiresTool()));
    public static final Block RED_MAPLE_LEAVES = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "red_maple_leaves"),
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(4f).requiresTool()));
    public static final Block RED_MAPLE_SAPLING = Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, "red_maple_sapling"),
            new SaplingBlock(new RedMapleSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(4f).requiresTool()));


    public static final Item RED_MAPLE_WOOD_ITEM = RegisterBlocks.registerBlockItem("red_maple_wood", RED_MAPLE_WOOD, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item RED_MAPLE_LOG_ITEM = RegisterBlocks.registerBlockItem("red_maple_log", RED_MAPLE_LOG, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item STRIPPED_RED_MAPLE_LOG_ITEM = RegisterBlocks.registerBlockItem("stripped_red_maple_log", STRIPPED_RED_MAPLE_LOG, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item STRIPPED_RED_MAPLE_WOOD_ITEM = RegisterBlocks.registerBlockItem("stripped_red_maple_wood", STRIPPED_RED_MAPLE_WOOD, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item RED_MAPLE_PLANKS_ITEM = RegisterBlocks.registerBlockItem("red_maple_planks", RED_MAPLE_PLANKS, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item RED_MAPLE_LEAVES_ITEM = RegisterBlocks.registerBlockItem("red_maple_leaves", RED_MAPLE_LEAVES, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item RED_MAPLE_SAPLING_ITEM = RegisterBlocks.registerBlockItem("red_maple_sapling", RED_MAPLE_SAPLING, FirstMod.FIRST_MOD_ITEM_GROUP);

    public static void register() {}
}
