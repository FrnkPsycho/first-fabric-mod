package net.frnks.firstmod.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.frnks.firstmod.block.IronCropBlock;
import net.frnks.firstmod.block.RedMapleTreeBlocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.state.property.Properties;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(IronCropBlock.IRON_CROP_BLOCK, Properties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

        blockStateModelGenerator.registerLog(RedMapleTreeBlocks.RED_MAPLE_LOG).log(RedMapleTreeBlocks.RED_MAPLE_LOG).wood(RedMapleTreeBlocks.RED_MAPLE_WOOD);
        blockStateModelGenerator.registerLog(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG).log(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG).wood(RedMapleTreeBlocks.STRIPPED_RED_MAPLE_WOOD);
        blockStateModelGenerator.registerTintableCrossBlockState(RedMapleTreeBlocks.RED_MAPLE_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerCubeAllModelTexturePool(RedMapleTreeBlocks.RED_MAPLE_PLANKS);
        blockStateModelGenerator.registerCubeAllModelTexturePool(RedMapleTreeBlocks.RED_MAPLE_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
