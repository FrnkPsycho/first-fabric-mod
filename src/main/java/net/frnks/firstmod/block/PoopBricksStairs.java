package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;

public class PoopBricksStairs extends StairsBlock {
    public PoopBricksStairs(BlockState blockState, Settings settings) {
        super(blockState, settings);
    }
    public static final PoopBricksStairs POOP_BRICKS_STAIRS = new PoopBricksStairs(
            PoopBricks.POOP_BRICKS.getDefaultState(),
            FabricBlockSettings.of(Material.STONE)
                    .strength(1.0f)
                    .requiresTool()
    );

    public static final BlockItem POOP_BRICKS_STAIRS_ITEM = new BlockItem(POOP_BRICKS_STAIRS, new FabricItemSettings());
}
