package net.frnks.firstmod.screen;

import net.fabricmc.fabric.api.screenhandler.v1.FabricScreenHandlerFactory;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.frnks.firstmod.FirstMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Identifier;

public class ChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    // 客户端调用该构造器
    public ChestScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(27));
    }

    // 服务端BlockEntity调用该构造器
    public ChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        // TODO add screen handler instance
        super(PLACEHOLDER, syncId);
        checkSize(inventory, 27);
        this.inventory = inventory;
        // 玩家开启时，一些物品栏有自定义的逻辑。
        inventory.onOpen(playerInventory.player);

        // 将Slot分配到网格的对应位置中
        int m, n;

        // 方块实体的物品栏
        for ( m = 0 ; m < 3; m++ ) {
            for ( n=0 ; n < 9; n++ ) {
                this.addSlot(new Slot(inventory, n + m * 9, 62 + n * 18, 17 + m * 18));
            }
        }

        // 玩家物品栏
        for ( m = 0 ; m < 3; m++ ) {
            for ( n=0 ; n < 9; n++ ) {
                this.addSlot(new Slot(inventory, n + m * 9 + 9, 8 + n * 18, 84 + m * 18));
            }
        }

        // 玩家快捷栏
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

}
