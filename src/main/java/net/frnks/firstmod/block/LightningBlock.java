package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Items;
import net.minecraft.predicate.LightPredicate;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningBlock extends Block {
    public static final BooleanProperty CHARGED = BooleanProperty.of("charged");
    public LightningBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(CHARGED,false));
    }
    public static final LightningBlock LIGHTNING_BLOCK = new LightningBlock(
            FabricBlockSettings.of(Material.METAL)
                    .luminance(state -> state.get(CHARGED) ? 15: 0)
                    .strength(4.0F)
                    .requiresTool()
    );
    public static final BlockItem LIGHTNING_BLOCK_ITEM = new BlockItem(LIGHTNING_BLOCK, new FabricItemSettings());

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHARGED);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){

        var mainHandItemStack = player.getHandItems().iterator().next();
        var mainHandItem = mainHandItemStack.getItem();
        if ( mainHandItem.equals(Items.COPPER_INGOT) && hand == Hand.MAIN_HAND && !state.get(CHARGED)) {
            if ( !player.isCreative()  ) {
                mainHandItemStack.decrement(1);
            }
            player.playSound(SoundEvents.BLOCK_RESPAWN_ANCHOR_CHARGE, 1, 1);
            world.setBlockState(pos, state.with(CHARGED, true));
            return ActionResult.SUCCESS;
        }
        else if ( state.get(CHARGED) ) {
            return ActionResult.SUCCESS;
        }
        else {
            if ( !world.isClient ) {
                player.sendMessage(Text.translatable("block.firstmod.lightning_block.caution"),false);
            }
            return ActionResult.SUCCESS;
        }
    }
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) throws NullPointerException {
        if ( world.getBlockState(pos).get(CHARGED)) {
            LightningEntity lightningEntity = (LightningEntity) EntityType.LIGHTNING_BOLT.create(world);
            assert lightningEntity != null;
            lightningEntity.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(pos));
            world.spawnEntity(lightningEntity);
        }
        world.setBlockState(pos, state.with(CHARGED, false));
        super.onSteppedOn(world, pos, state, entity);
    }
}
