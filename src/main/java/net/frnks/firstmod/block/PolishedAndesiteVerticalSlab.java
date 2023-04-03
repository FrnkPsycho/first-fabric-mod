package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;

public class PolishedAndesiteVerticalSlab extends VerticalSlabBlock {
    public PolishedAndesiteVerticalSlab(Settings settings) {
        super(settings);
    }
    public static final PolishedAndesiteVerticalSlab POLISHED_ANDESITE_VERTICAL_SLAB = new PolishedAndesiteVerticalSlab(
            FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE)
    );
    public static final BlockItem POLISHED_ANDESITE_VERTICAL_SLAB_ITEM = new BlockItem(POLISHED_ANDESITE_VERTICAL_SLAB, new FabricItemSettings());
}
