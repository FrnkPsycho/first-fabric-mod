package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class TopSidedFurnaceBlock extends FurnaceBlock {
    public static final Identifier TOP_SIDED_FURNACE_ID = new Identifier("firstmod","top_sided_furnace");
    public static final TopSidedFurnaceBlock TOP_SIDED_FURNACE = new TopSidedFurnaceBlock(FabricBlockSettings.of(Material.STONE));
    public static final BlockItem TOP_SIDED_FURNACE_ITEM = new BlockItem(TOP_SIDED_FURNACE, new FabricItemSettings());
    public TopSidedFurnaceBlock(Settings settings) {
        super(settings);
        settings.luminance(createLightLevelFromLitBlockState(13));
    }
    private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> state.get(Properties.LIT) ? litLevel : 0;
    }

    @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return FurnaceBlock.checkType(world, type, BlockEntityType.FURNACE);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new TopSidedFurnaceBlockEntity(pos, state);
    }

}
