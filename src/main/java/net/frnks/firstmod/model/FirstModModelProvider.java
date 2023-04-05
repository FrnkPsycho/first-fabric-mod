package net.frnks.firstmod.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class FirstModModelProvider implements ModelResourceProvider {
    public static final TopSidedFurnaceModel TOP_SIDED_FURNACE_MODEL = new TopSidedFurnaceModel();
    public static final Identifier TOP_SIDED_FURNACE_MODEL_BLOCK = new Identifier("firstmod:block/top_sided_furnace");
    public static final Identifier TOP_SIDED_FURNACE_MODEL_ITEM = new Identifier("firstmod:item/top_sided_furnace");

    @Override
    public @Nullable UnbakedModel loadModelResource(Identifier resourceId, ModelProviderContext context) throws ModelProviderException {
        if ( resourceId.equals(TOP_SIDED_FURNACE_MODEL_BLOCK) || resourceId.equals(TOP_SIDED_FURNACE_MODEL_ITEM)) {
            System.out.println("SUCCESS LOADED CUSTOM MODEL!!!!");
            return TOP_SIDED_FURNACE_MODEL;
        } else {
            return null;
        }
    }
}
