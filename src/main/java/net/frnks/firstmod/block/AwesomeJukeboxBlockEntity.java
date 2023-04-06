package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class AwesomeJukeboxBlockEntity extends JukeboxBlockEntity {
    public static final BlockEntityType<AwesomeJukeboxBlockEntity> AWESOME_JUKEBOX_BLOCK_ENTITY = FabricBlockEntityTypeBuilder.create(
            AwesomeJukeboxBlockEntity::new,
            AwesomeJukeboxBlock.AWESOME_JUKEBOX_BLOCK
    ).build();

    public AwesomeJukeboxBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

//    @Nullable
//    @Override
//    public Packet<ClientPlayPacketListener> toUpdatePacket() {
//        return super.toUpdatePacket();
//    }
//
//    @Override
//    public NbtCompound toInitialChunkDataNbt() {
//        return createNbt();
//    }
}
