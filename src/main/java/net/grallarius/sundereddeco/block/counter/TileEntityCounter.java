package net.grallarius.sundereddeco.block.counter;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCounter extends TileEntity {

    private int count = 0;

    public TileEntityCounter(){
    super(ModBlocks.COUNTER_TILE);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("count", count);
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.count = compound.getInt("count");
    }

    public int getCount() {
        return this.count;
    }

    public void incrementCount() {
        this.count++;
        markDirty();
    }
    public void decrementCount() {
        this.count--;
        markDirty();
    }

}
