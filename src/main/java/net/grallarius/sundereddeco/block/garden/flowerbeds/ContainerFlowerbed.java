package net.grallarius.sundereddeco.block.garden.flowerbeds;

import net.grallarius.sundereddeco.block.garden.SlotFlower;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

import static net.grallarius.sundereddeco.block.ModBlocks.FLOWERBED_CONTAINER;

public class ContainerFlowerbed extends Container {

    private TileEntityFlowerbed tileEntity;


    public ContainerFlowerbed(int windowId, World world, BlockPos pos, PlayerInventory playerInventory, PlayerEntity player) {

        super(FLOWERBED_CONTAINER, windowId);
        tileEntity = (TileEntityFlowerbed) world.getTileEntity(pos);
        IItemHandler inventory = tileEntity.getInventory();

        addSlot(new SlotFlower(inventory, 0, 80, 21) {
            @Override
            public void onSlotChanged() { tileEntity.markDirty(); }
        });
        addSlot(new SlotFlower(inventory, 1, 80, 53) {
            @Override
            public void onSlotChanged() { tileEntity.markDirty(); }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
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
