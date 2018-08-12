package net.grallarius.sundereddeco.block.pedestal;

import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotBook extends SlotItemHandler {

    private final IItemHandler itemHandler;
    private final int index;

    public SlotBook(IItemHandler itemHandler, int index, int xPosition, int yPosition){
        super(itemHandler, index, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.index = index;
    }

    @Override
    public int getSlotStackLimit() { return 1; }

    @Override
    public int getItemStackLimit(@Nonnull ItemStack stack) {return 1;}

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        if (stack.isEmpty())
            return false;

        return stack.getItem() instanceof ItemBook || stack.getItem() instanceof ItemEnchantedBook;

    }

}
