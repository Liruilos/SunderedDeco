package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.block.garden.flowerbeds.*;
import net.grallarius.sundereddeco.block.garden.windowbox.ContainerWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.GuiWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.pedestal.ContainerPedestal;
import net.grallarius.sundereddeco.block.pedestal.GuiPedestal;
import net.grallarius.sundereddeco.block.pedestal.TileEntityPedestal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
    public static final int PEDESTAL = 0;
    public static final int WINDOWBOX = 1;
    public static final int FLOWERBED = 2;
    public static final int DENSEFLOWERBED = 3;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case PEDESTAL:
                return new ContainerPedestal(player.inventory, (TileEntityPedestal)world.getTileEntity(new BlockPos(x, y, z)));
            case WINDOWBOX:
                return new ContainerWindowbox(player.inventory, (TileEntityWindowbox)world.getTileEntity(new BlockPos(x, y, z)));
            case FLOWERBED:
                return new ContainerFlowerbed(player.inventory, (TileEntityFlowerbed)world.getTileEntity(new BlockPos(x, y, z)));
            case DENSEFLOWERBED:
                return new ContainerDenseFlowerbed(player.inventory, (TileEntityDenseFlowerbed)world.getTileEntity(new BlockPos(x, y, z)));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch (ID) {
            case PEDESTAL:
                return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case WINDOWBOX:
                return new GuiWindowbox(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case FLOWERBED:
                return new GuiFlowerbed(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case DENSEFLOWERBED:
                return new GuiDenseFlowerbed(getServerGuiElement(ID, player, world, x, y, z), player.inventory);

            default:
                return null;
        }
    }
}
