package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.item.BlockItem;

public class PoopBricksVerticalSlab extends VerticalSlabBlock {
    public PoopBricksVerticalSlab(Settings settings) {
        super(settings);
    }
    public static final PoopBricksVerticalSlab POOP_BRICKS_VERTICAL_SLAB = new PoopBricksVerticalSlab(
            FabricBlockSettings.copyOf(PoopBricks.POOP_BRICKS)
    );
    public static final BlockItem POOP_BRICKS_VERTICAL_SLAB_ITEM = new BlockItem(POOP_BRICKS_VERTICAL_SLAB, new FabricItemSettings());
}
