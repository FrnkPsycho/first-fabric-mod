package net.frnks.firstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.frnks.firstmod.FirstMod;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class StrangeFood extends Item {

    public static final StrangeFood STRANGE_FOOD = new StrangeFood(new FabricItemSettings().food(FoodComponents.APPLE));
    public StrangeFood(Settings settings) {
        super(settings);
    }
    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if ( user.isPlayer() ) {
            PlayerEntity player = (PlayerEntity) user;
            player.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.5f, 0.2f);
            player.giveItemStack(new ItemStack(FirstMod.poop, 1));
        }
        return stack;
    }

//    @Override
//    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
//        if ( remainingUseTicks == 0 && world.isClient ) {
//            if ( user.isPlayer() ) {
//                PlayerEntity player = (PlayerEntity) user;
//                player.giveItemStack(new ItemStack(FirstMod.poop, 1));
//            }
//        }
//    }
}