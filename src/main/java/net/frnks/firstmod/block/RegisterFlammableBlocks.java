package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class RegisterFlammableBlocks {
    public static void register() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(RedMapleTreeBlocks.RED_MAPLE_LOG, 5, 20);
        /* etc. */
    }
}
