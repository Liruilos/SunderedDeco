package net.grallarius.sundereddeco;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {
    public static final int PEDESTAL = 0;
    public static final int WINDOWBOX = 1;
    public static final int FLOWERBED = 2;
    public static final int DENSEFLOWERBED = 3;

    @Override
    public Container getServerGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
        switch (ID) {
/*            case PEDESTAL:
                return new ContainerPedestal(player.inventory, (TileEntityPedestal)world.getTileEntity(new BlockPos(x, y, z)));
            case WINDOWBOX:
                return new ContainerWindowbox(player.inventory, (TileEntityWindowbox)world.getTileEntity(new BlockPos(x, y, z)));
            case FLOWERBED:
                return new ContainerFlowerbed(player.inventory, (TileEntityFlowerbed)world.getTileEntity(new BlockPos(x, y, z)));
            case DENSEFLOWERBED:
                return new ContainerDenseFlowerbed(player.inventory, (TileEntityDenseFlowerbed)world.getTileEntity(new BlockPos(x, y, z)));*/
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
        switch (ID) {
/*            case PEDESTAL:
                return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case WINDOWBOX:
                return new WindowboxScreen(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case FLOWERBED:
                return new FlowerbedScreen(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
            case DENSEFLOWERBED:
                return new DenseFlowerbedScreen(getServerGuiElement(ID, player, world, x, y, z), player.inventory);*/

            default:
                return null;
        }
    }
}
