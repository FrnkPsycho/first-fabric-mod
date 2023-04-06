package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AwesomeJukeboxBlock extends JukeboxBlock {
    public static final Identifier AWESOME_JUKEBOX_BLOCK_ID = new Identifier("firstmod", "awesome_jukebox");
    public static final AwesomeJukeboxBlock AWESOME_JUKEBOX_BLOCK = new AwesomeJukeboxBlock(FabricBlockSettings.copyOf(Blocks.JUKEBOX));
    public static final BlockItem AWESOME_JUKEBOX_BLOCK_ITEM = new BlockItem(AWESOME_JUKEBOX_BLOCK, new FabricItemSettings());
    public AwesomeJukeboxBlock(Settings settings) {
        super(settings);
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AwesomeJukeboxBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, AwesomeJukeboxBlockEntity.AWESOME_JUKEBOX_BLOCK_ENTITY, AwesomeJukeboxBlockEntity::tick);
    }
}
