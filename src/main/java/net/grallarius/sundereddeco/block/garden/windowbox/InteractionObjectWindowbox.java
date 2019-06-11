package net.grallarius.sundereddeco.block.garden.windowbox;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectWindowbox implements IInteractionObject {
    private TileEntityWindowbox tile;

    public InteractionObjectWindowbox(TileEntityWindowbox tile){
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
    public Container createContainer(InventoryPlayer playerInv, EntityPlayer arg1) {
        return new ContainerWindowbox(playerInv, this.tile);
    }

    @Override
    public String getGuiID() {
        return SunderedDeco.MODID + ":windowbox_gui";
    }
}
