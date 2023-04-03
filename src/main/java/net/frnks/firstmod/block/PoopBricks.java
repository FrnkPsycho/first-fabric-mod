package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PoopBricks extends Block {
    public static final float POOP_BRICKS_STRENGTH = 2.0f;
    public static final Material POOP_BRICKS_MATERIAL = Material.STONE;
    public PoopBricks(Settings settings) {
        super(settings);
    }
    public static final PoopBricks POOP_BRICKS = new PoopBricks(
            FabricBlockSettings.of(POOP_BRICKS_MATERIAL)
                    .strength(POOP_BRICKS_STRENGTH)
                    .requiresTool()
    );
    public static final BlockItem POOP_BRICKS_ITEM = new BlockItem(POOP_BRICKS, new FabricItemSettings());
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if ( !world.isClient && hand == Hand.MAIN_HAND ) {
            var it = player.getHandItems().iterator();
            if ( it.next().isEmpty() ) {
                player.sendMessage(Text.translatable("block.firstmod.poop_bricks.test_message"), false);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.FAIL;
    }
}
