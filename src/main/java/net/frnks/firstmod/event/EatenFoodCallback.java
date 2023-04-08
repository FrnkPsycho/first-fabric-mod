package net.frnks.firstmod.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

public interface EatenFoodCallback {
    Event<EatenFoodCallback> EVENT = EventFactory.createArrayBacked(EatenFoodCallback.class,
            (listeners) -> (player, world) -> {
                for ( EatenFoodCallback listener : listeners) {
                    ActionResult result = listener.interact(player, world);
                    if ( result != ActionResult.PASS ) {
                        return result;
                    }
                }
                return ActionResult.PASS;
            });

    ActionResult interact(PlayerEntity player, World world);
}
