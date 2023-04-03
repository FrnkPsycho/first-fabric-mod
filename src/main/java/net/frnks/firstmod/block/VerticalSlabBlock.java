package net.frnks.firstmod.block;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public class VerticalSlabBlock extends HorizontalFacingBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public VerticalSlabBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
        Direction dir = state.get(FACING);
        switch (dir) {
            case NORTH: return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
            case SOUTH: return VoxelShapes.cuboid(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
            case WEST: return VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
            case EAST: return VoxelShapes.cuboid(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
            default:
                return VoxelShapes.fullCube();
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        // VERY BUGGED! NEED TO FIX!@*&^%%@~
        Direction dir = ctx.getPlayerLookDirection();
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();
        if ( dir == Direction.UP || dir == Direction.DOWN ) {
            switch (dir) {
                case UP:
                    pos.up(1);
                    break;
                case DOWN:
                    pos.down(1);
                    break;
                default:
                    break;
            }
            BlockState bs = world.getBlockState(pos);
            if ( bs.getProperties().contains(Properties.HORIZONTAL_FACING) ) {
                dir = bs.get(Properties.HORIZONTAL_FACING);
            } else {
                dir = Direction.NORTH;
            }
        }
        return super.getPlacementState(ctx)
                .with(Properties.HORIZONTAL_FACING, dir)
                .with(WATERLOGGED, world.getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if ( state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
