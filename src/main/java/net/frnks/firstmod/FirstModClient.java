package net.frnks.firstmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.frnks.firstmod.block.TransparentBlock;
import net.frnks.firstmod.screen.PoopBarrelScreen;
import net.frnks.firstmod.screen.PoopBarrelScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class FirstModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ScreenRegistry.register(PoopBarrelScreenHandler.BARREL_SCREEN_HANDLER, PoopBarrelScreen::new);

		BlockRenderLayerMap.INSTANCE.putBlock(TransparentBlock.TRANSPARENT_BLOCK, RenderLayer.getCutout());
	}
}
