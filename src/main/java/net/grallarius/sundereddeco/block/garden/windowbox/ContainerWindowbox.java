package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.block.garden.SlotFlower;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerWindowbox extends Container {

    public ContainerWindowbox(Inventory playerInv, final TileEntityWindowbox windowbox) {
        //TODO i just picked a random id to make this class work, idekwid
        super(null, 20);
        //IItemHandler inventory = windowbox.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        IItemHandler inventory = windowbox.getInventory();

        addSlot(new SlotFlower(inventory, 0, 60, 21) {
            @Override
            public void onSlotChanged() { windowbox.markDirty(); }
        });
        addSlot(new SlotFlower(inventory, 1, 100, 21) {
            @Override
            public void onSlotChanged() { windowbox.markDirty(); }
        });
        addSlot(new SlotItemHandler(inventory, 2, 80, 53) {
            @Override
            public void onSlotChanged() { windowbox.markDirty(); }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlot(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            int containerSlots = inventorySlots.size() - player.inventory.mainInventory.size();

            if (index < containerSlots) {
                if (!this.mergeItemStack(itemstack1, containerSlots, inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, containerSlots, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.getCount() == 0) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

}
