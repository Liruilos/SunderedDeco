package net.grallarius.sundereddeco.block.garden.windowbox;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static net.grallarius.sundereddeco.block.ModBlocks.WINDOWBOX_TILE;
import static net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox.FACING;

public class TileEntityWindowbox extends TileEntity implements INamedContainerProvider {
    public int facing;

    public ItemStackHandler inventory;

    public TileEntityWindowbox(){
        super(WINDOWBOX_TILE);

        this.inventory = new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                if (!world.isRemote) {
                    TileEntityWindowbox.this.saveAndSync();
                }
            }
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                return BlockWindowbox.canBePotted(stack);
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!BlockWindowbox.canBePotted(stack)) {
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
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

    @Override
    public ITextComponent getDisplayName() {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    @Nullable
    @Override
    public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        return new ContainerWindowbox(i, world, pos, playerInventory, playerEntity);
    }

}
