package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.network.PacketRequestUpdateWindowbox;
import net.grallarius.sundereddeco.network.PacketUpdateWindowbox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityWindowbox extends TileEntity {
    public long lastChangeTime;
    public int facing;

    public ItemStackHandler inventory = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot){
            if (!world.isRemote) {
                lastChangeTime = world.getTotalWorldTime();
                SunderedDeco.wrapper.sendToAllAround(new PacketUpdateWindowbox(TileEntityWindowbox.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
            }
        }
    };

    @Override
    public void onLoad() {
        if (world.isRemote) {
            SunderedDeco.wrapper.sendToServer(new PacketRequestUpdateWindowbox(this));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        compound.setLong("lastChangeTime", lastChangeTime);
        compound.setInteger("facing", getFacing());
        return super.writeToNBT(compound);
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        lastChangeTime =compound.getLong("lastChangeTime");
        facing = compound.getInteger("facing");
        super.readFromNBT(compound);
    }

    public int getFacing() { return facing; }

    public void setFacing(int facing) { this.facing = facing; }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }
}
