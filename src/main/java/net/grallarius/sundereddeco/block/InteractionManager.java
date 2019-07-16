package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.garden.windowbox.ContainerWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionManager implements IInteractionObject {

    private TileEntity tile;

    public InteractionManager(TileEntity tile){
        this.tile = tile;
    }

    @Override
    public ITextComponent getCustomName() {
        return null;
    }

    @Override
    public ITextComponent getName() {
        return null;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }


    @Override
    public Container func_174876_a(InventoryPlayer inventoryPlayer, EntityPlayer entityPlayer) {
        if (this.tile instanceof TileEntityWindowbox) return new ContainerWindowbox(inventoryPlayer, (TileEntityWindowbox) this.tile);
        else return null;
    }

/*    @Override
    public Container createContainer(InventoryPlayer playerInv, EntityPlayer arg1) {
        if (this.tile instanceof TileEntityWindowbox) return new ContainerWindowbox(playerInv, (TileEntityWindowbox) this.tile);
        else return null;
    }*/

    @Override
    public String func_174875_k() {
        if (this.tile instanceof TileEntityWindowbox) return SunderedDeco.MODID + ":windowbox_gui";
        else return null;
    }

/*    @Override
    public String getGuiID() {
        if (this.tile instanceof TileEntityWindowbox) return SunderedDeco.MODID + ":windowbox_gui";
        else return null;
    }*/

}
