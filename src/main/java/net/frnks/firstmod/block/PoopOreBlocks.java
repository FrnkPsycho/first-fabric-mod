package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frnks.firstmod.FirstMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.Item;

public class PoopOreBlocks {
    public static final Block POOP_ORE_BLOCK = RegisterBlocks.registerBlock("poop_ore_block", new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE).strength(3.0f).requiresTool()));
    public static final Block DEEPSLATE_POOP_ORE_BLOCK = RegisterBlocks.registerBlock("deepslate_poop_ore_block", new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_COAL_ORE).strength(6.0F).requiresTool()));

    public static final Item POOP_ORE_BLOCK_ITEM = RegisterBlocks.registerBlockItem("poop_ore_block", POOP_ORE_BLOCK, FirstMod.FIRST_MOD_ITEM_GROUP);
    public static final Item DEEPSLATE_POOP_ORE_BLOCK_ITEM = RegisterBlocks.registerBlockItem("deepslate_poop_ore_block", DEEPSLATE_POOP_ORE_BLOCK, FirstMod.FIRST_MOD_ITEM_GROUP);

    /* This method does nothing, just to ensure jvm to load this class */
    public static void register() {}
}
