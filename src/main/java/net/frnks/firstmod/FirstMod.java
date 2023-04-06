package net.frnks.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;

import net.frnks.firstmod.armor.RegisterArmorItems;
import net.frnks.firstmod.block.RegisterBlocks;
import net.frnks.firstmod.item.Poop;
import net.frnks.firstmod.item.RegisterItems;
import net.frnks.firstmod.screen.RegisterScreens;
import net.frnks.firstmod.tool.RegisterToolItems;

import net.minecraft.item.*;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class FirstMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("firstmod");
	public static final Poop poop = Registry.register(
			Registries.ITEM,
			new Identifier("firstmod", "poop"),
			new Poop(new FabricItemSettings()));
	private static final ItemGroup FIRST_MOD_ITEM_GROUP = FabricItemGroup.builder(
			new Identifier("firstmod", "item_group"))
			.icon(() -> new ItemStack(poop))
			.build();

	@Override
	public void onInitialize() {
//		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
//			content.addAfter(Items.NETHERITE_SWORD, strangeSword);
//		});
		FuelRegistry.INSTANCE.add(poop, 800);
		CompostingChanceRegistry.INSTANCE.add(poop, 0.9F);
		ItemGroupEvents.modifyEntriesEvent(FIRST_MOD_ITEM_GROUP).register(content -> content.add(poop));

		RegisterItems.register(FIRST_MOD_ITEM_GROUP);
		RegisterBlocks.register(FIRST_MOD_ITEM_GROUP);
		RegisterArmorItems.register(FIRST_MOD_ITEM_GROUP);
		RegisterToolItems.register(FIRST_MOD_ITEM_GROUP);
		RegisterScreens.register();

		LOGGER.info("Hello Fabric world!");
	}
}
