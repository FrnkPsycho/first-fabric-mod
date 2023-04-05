package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;

public class TransparentBlock extends Block {
    public TransparentBlock(Settings settings) {
        super(settings);
    }
    public static final TransparentBlock TRANSPARENT_BLOCK = new TransparentBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).nonOpaque());
    public static final BlockItem TRANSPARENT_BLOCK_ITEM = new BlockItem(TRANSPARENT_BLOCK, new FabricItemSettings());
}
