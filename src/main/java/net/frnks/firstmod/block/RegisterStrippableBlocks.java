package net.frnks.firstmod.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class RegisterStrippableBlocks {
    public static void register() {
        StrippableBlockRegistry.register(RedMapleTreeBlocks.RED_MAPLE_LOG, RedMapleTreeBlocks.STRIPPED_RED_MAPLE_LOG);
        StrippableBlockRegistry.register(RedMapleTreeBlocks.RED_MAPLE_WOOD, RedMapleTreeBlocks.STRIPPED_RED_MAPLE_WOOD);
    }
}
