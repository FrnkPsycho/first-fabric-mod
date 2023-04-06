package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TopSidedFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final BlockEntityType<TopSidedFurnaceBlockEntity> TOP_SIDED_FURNACE_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(
            TopSidedFurnaceBlockEntity::new,
            TopSidedFurnaceBlock.TOP_SIDED_FURNACE
    ).build();

    public TopSidedFurnaceBlockEntity(BlockPos pos, BlockState state) {
        super(TOP_SIDED_FURNACE_BLOCK_ENTITY, pos, state, RecipeType.SMELTING);
    }

//    @Override
//    protected Text getContainerName() {
//        return Text.translatable("")
//    }

    @Override
    protected Text getContainerName() {
        return Text.translatable("container.top_sided_furnace");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new FurnaceScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

//    @Nullable
//    @Override
//    public Packet<ClientPlayPacketListener> toUpdatePacket() {
//        return BlockEntityUpdateS2CPacket.create(this);
//    }


    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return super.toUpdatePacket();
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
