package net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileEntityCounter extends TileEntity {

    private int count = 0;

    public TileEntityCounter(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
        //super(TileEntityType.register("counter", TileEntityType.Builder.create(TileEntityCounter::new)));
    }

    public TileEntityCounter(){
    super(SunderedDeco.TECOUNTER);
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        compound.setInt("count", count);
        return super.write(compound);
    }

    @Override
    public void read(NBTTagCompound compound) {
        count = compound.getInt("count");
        super.read(compound);
    }

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
