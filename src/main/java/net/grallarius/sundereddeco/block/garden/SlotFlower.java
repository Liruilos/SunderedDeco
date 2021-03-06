package net.grallarius.sundereddeco.block.garden;

import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class SlotFlower extends SlotItemHandler {

    private final IItemHandler itemHandler;
    private final int index;

    public SlotFlower(IItemHandler itemHandler, int index, int xPosition, int yPosition){
        super(itemHandler, index, xPosition, yPosition);
        this.itemHandler = itemHandler;
        this.index = index;
    }
    @Override
    public int getSlotStackLimit() { return 1; }

    @Override
    public int getItemStackLimit(@Nonnull ItemStack stack) {return 1;}

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack)
    {
        if (stack.isEmpty())
            return false;

        Block block = Block.getBlockFromItem(stack.getItem());
        Boolean isFlower = block instanceof FlowerBlock;

/*        if ((!isFlower) && (block != Blocks.DANDELION) && (block != Blocks.POPPY) && (block != Blocks.BROWN_MUSHROOM) && (block != Blocks.RED_MUSHROOM) && (block != Blocks.SAPLING) && (block != Blocks.DEADBUSH))
        {
            int i = stack.getMetadata();
            return block == Blocks.TALLGRASS && i == BlockTallGrass.EnumType.FERN.getMeta();
        }*/

        IItemHandler handler = this.getItemHandler();
        ItemStack remainder;
        if (handler instanceof IItemHandlerModifiable)
        {
            IItemHandlerModifiable handlerModifiable = (IItemHandlerModifiable) handler;
            ItemStack currentStack = handlerModifiable.getStackInSlot(index);

            handlerModifiable.setStackInSlot(index, ItemStack.EMPTY);

            remainder = handlerModifiable.insertItem(index, stack, true);

            handlerModifiable.setStackInSlot(index, currentStack);
        }
        else
        {
            remainder = handler.insertItem(index, stack, true);
        }
        return remainder.isEmpty() || remainder.getCount() < stack.getCount();
    }

}
