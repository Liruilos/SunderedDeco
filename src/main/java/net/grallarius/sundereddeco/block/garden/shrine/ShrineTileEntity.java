package net.grallarius.sundereddeco.block.garden.shrine;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

import static net.grallarius.sundereddeco.block.ModBlocks.SHRINE_TILE;
import static net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox.FACING;

public class ShrineTileEntity extends TileEntity {

    public int facing;

    public ItemStackHandler inventory;

    public ShrineTileEntity(){
        super(SHRINE_TILE);

        this.inventory = new ItemStackHandler(1) {
            @Override
            protected void onContentsChanged(int slot) {
                if (!world.isRemote) {
                    ShrineTileEntity.this.saveAndSync();
                }
            }
        };
    }

    @Override
    public void onLoad() {
        if (world.isRemote) {
            this.saveAndSync();
        }
    }

    public int getFacing() { return this.facing; }

    public void setFacing(int facing) { this.facing = facing; }

    public ItemStackHandler getInventory(){
        return this.inventory;
    }

    public void saveAndSync() {
        BlockState state = this.world.getBlockState(this.pos);
        this.setFacing(state.get(FACING).getHorizontalIndex());
        this.world.markForRerender(this.pos);
        this.world.notifyBlockUpdate(pos, state, state, 3);
        this.markDirty();
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(this.getPos(), 0, this.getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket packet) {
        this.read(packet.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        return this.write(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(CompoundNBT nbt) {
        this.read(nbt);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.inventory.deserializeNBT(compound.getCompound("inventory"));
        this.facing = compound.getInt("facing");
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inventory", this.inventory.serializeNBT());
        compound.putInt("facing", this.getFacing());
        return super.write(compound);
    }

}
