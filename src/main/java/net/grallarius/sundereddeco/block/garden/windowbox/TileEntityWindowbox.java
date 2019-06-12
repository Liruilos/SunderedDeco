package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class TileEntityWindowbox extends TileEntity {
    public int facing;

    public TileEntityWindowbox(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public TileEntityWindowbox(){
        super(SunderedDeco.teWindowbox);
    }

    public ItemStackHandler inventory = new ItemStackHandler(3) {

        @Override
        protected void onContentsChanged(int slot){
            if (!world.isRemote) {
                TileEntityWindowbox.this.saveAndSync();
                //SunderedDeco.wrapper.sendToAllAround(new PacketUpdateWindowbox(TileEntityWindowbox.this), new NetworkRegistry.TargetPoint(world.provider.getDimension(), pos.getX(), pos.getY(), pos.getZ(), 64));
            }
        }

    };

    @Override
    public void onLoad() {
        if (world.isRemote) {
            this.saveAndSync();
            //SunderedDeco.wrapper.sendToServer(new PacketRequestUpdateWindowbox(this));
        }
    }

    public int getFacing() { return facing; }

    public void setFacing(int facing) { this.facing = facing; }

    @Deprecated
    public ItemStackHandler getInventory() {
        return this.inventory;
    }

    public void saveAndSync() {
        IBlockState state = this.world.getBlockState(this.pos);
        this.world.markBlockRangeForRenderUpdate(this.pos, this.pos);
        this.world.notifyBlockUpdate(pos, state, state, 3);
        this.markDirty();
    }

    @Override
    public void read(NBTTagCompound compound) {
        super.read(compound);
        this.inventory.deserializeNBT(compound.getCompound("inventory"));
        this.facing = compound.getInt("facing");
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        compound.setTag("inventory", this.inventory.serializeNBT());
        compound.setInt("facing", this.getFacing());
        return super.write(compound);
    }


    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(this.getPos(), 0, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.read(packet.getNbtCompound());
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.write(new NBTTagCompound());
    }

    @Override
    public void handleUpdateTag(NBTTagCompound nbt) {
        this.read(nbt);
    }



/*    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? (T)inventory : super.getCapability(capability, facing);
    }*/

/*    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(getPos(), getPos().add(1, 2, 1));
    }*/
}
