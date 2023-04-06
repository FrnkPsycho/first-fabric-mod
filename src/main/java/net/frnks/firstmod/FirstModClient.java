package net.frnks.firstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.frnks.firstmod.block.AwesomeJukeboxBlockEntity;
import net.frnks.firstmod.block.IronCropBlock;
import net.frnks.firstmod.block.TransparentBlock;
import net.frnks.firstmod.model.FirstModModelProvider;
import net.frnks.firstmod.renderer.AwesomeJukeboxBlockEntityRenderer;
import net.frnks.firstmod.screen.PoopBarrelScreen;
import net.frnks.firstmod.screen.PoopBarrelScreenHandler;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class FirstModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(PoopBarrelScreenHandler.BARREL_SCREEN_HANDLER, PoopBarrelScreen::new);

		BlockRenderLayerMap.INSTANCE.putBlock(TransparentBlock.TRANSPARENT_BLOCK, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), IronCropBlock.IRON_CROP_BLOCK);

		ModelLoadingRegistry.INSTANCE.registerResourceProvider(resourceManager -> new FirstModModelProvider());

		BlockEntityRendererRegistry.register(AwesomeJukeboxBlockEntity.AWESOME_JUKEBOX_BLOCK_ENTITY, AwesomeJukeboxBlockEntityRenderer::new);
	}
}
