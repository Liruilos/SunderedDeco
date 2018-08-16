package net.grallarius.sundereddeco.block.pedestal;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.network.PacketRequestUpdatePedestal;
import net.grallarius.sundereddeco.network.PacketUpdatePedestal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

import static net.grallarius.sundereddeco.block.pedestal.BlockPedestal.HASBOOK;

public class TileEntityPedestal extends TileEntity {
    public long lastChangeTime;

    public ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot){
            if (!world.isRemote) {
                if (!getStackInSlot(0).isEmpty()){
                    //System.out.println("I am setting has book to true with item " + getStackInSlot(0) + " from " + inventory);
                    world.setBlockState(pos, world.getBlockState(pos).withProperty(HASBOOK, true));
                    //System.out.println("I have set has book to true with item " + getStackInSlot(0) + " from " + inventory);
                    markDirty();
                }
                if (getStackInSlot(0).isEmpty()){
                    //System.out.println("I am setting has book to false with item " + getStackInSlot(0) + " from " + inventory);
                    world.setBlockState(pos, world.getBlockState(pos).withProperty(HASBOOK, false));
                    //System.out.println("I have set has book to false with item " + getStackInSlot(0) + " from " + inventory);
                    markDirty();
                }

                lastChangeTime = world.getTotalWorldTime();
                SunderedDeco.wrapper.sendToAllAround(new PacketUpdatePedestal(TileEntityPedestal.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
            }
        }
    };

    @Override
    public void onLoad() {
        if (world.isRemote) {
            SunderedDeco.wrapper.sendToServer(new PacketRequestUpdatePedestal(this));
        }
    }

    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
        return (oldState.getBlock() != newState.getBlock());
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("inventory", inventory.serializeNBT());
        compound.setLong("lastChangeTime", lastChangeTime);
        return super.writeToNBT(compound);
    }


    @Override
    public void readFromNBT(NBTTagCompound compound) {
        inventory.deserializeNBT(compound.getCompoundTag("inventory"));
        lastChangeTime =compound.getLong("lastChangeTime");
        super.readFromNBT(compound);
    }


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
