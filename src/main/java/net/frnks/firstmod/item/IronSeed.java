package net.frnks.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frnks.firstmod.block.IronCropBlock;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;

public class IronSeed extends Item {
    public static final Item IRON_SEED = new AliasedBlockItem(IronCropBlock.IRON_CROP_BLOCK, new FabricItemSettings());
    public IronSeed(Settings settings) {
        super(settings);
    }
}
