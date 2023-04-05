package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class TopSidedFurnaceBlockEntity extends FurnaceBlockEntity {
    public static final BlockEntityType<TopSidedFurnaceBlockEntity> TOP_SIDED_FURNACE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(
            TopSidedFurnaceBlockEntity::new,
            TopSidedFurnaceBlock.TOP_SIDED_FURNACE
    ).build();
    public TopSidedFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}
