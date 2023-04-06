package net.frnks.firstmod.renderer;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public class AwesomeJukeboxBlockEntityRenderer implements BlockEntityRenderer {
    private static ItemStack itemStack = new ItemStack(Items.JUKEBOX, 1);
    public AwesomeJukeboxBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {

    }
    @Override
    public void render(BlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        double offset = Math.sin((entity.getWorld().getTime() + tickDelta) / 8.0) / 4.0;
        matrices.translate(0.5, 1.25 + offset, 0.5);
//        matrices.multiply(Vec3d.
        MinecraftClient.getInstance().getItemRenderer().renderItem(itemStack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, MinecraftClient.getInstance().world, 0);
        matrices.pop();
    }
}
