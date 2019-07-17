package net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityCounter extends TileEntity {

    private int count = 0;

    public TileEntityCounter(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityCounter(){
    super(SunderedDeco.teCounter);
    }

    /*@Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.putInt("count", count);
        return compound;
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        count = compound.getInt("count");
    }*/

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
        markDirty();
    }
    public void decrementCount() {
        count--;
        markDirty();
    }

}
