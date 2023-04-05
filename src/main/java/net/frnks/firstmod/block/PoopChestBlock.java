package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.frnks.firstmod.FirstMod;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.frnks.firstmod.block.PoopBricks.POOP_BRICKS;

public class PoopChestBlock extends BlockWithEntity {
    public static final PoopChestBlock POOP_CHEST_BLOCK = new PoopChestBlock(
            FabricBlockSettings.copyOf(POOP_BRICKS));
    public static final BlockItem POOP_CHEST_BLOCK_ITEM = new BlockItem(POOP_CHEST_BLOCK, new FabricItemSettings());
    public PoopChestBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PoopChestBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(
                type,
                PoopChestBlockEntity.POOP_CHEST_BLOCK_ENTITY,
                PoopChestBlockEntity::tick
        );
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if ( world.isClient ) return ActionResult.FAIL;
        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);
        ItemStack handItemStack = player.getStackInHand(hand);

        if ( !handItemStack.isEmpty() ) {
            if ( blockEntity.getStack(0).isEmpty() ) {
                blockEntity.setStack(0, handItemStack.copy());
                handItemStack.setCount(0);
            } else if ( blockEntity.getStack(1).isEmpty() ) {
                blockEntity.setStack(1, handItemStack.copy());
                handItemStack.setCount(0);
            }
        } else {
            if ( !blockEntity.getStack(1).isEmpty() ) {
                player.getInventory().offerOrDrop(blockEntity.getStack(1));
                blockEntity.removeStack(1);
            } else if ( !blockEntity.getStack(0).isEmpty() ) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
            }
        }

        System.out.println("First Slot: " + blockEntity.getStack(0));
        System.out.println("Second Slot: " + blockEntity.getStack(1));
        return ActionResult.SUCCESS;
    }
}
