package net.grallarius.sundereddeco.network.garden;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityDenseFlowerbed;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdateDenseFlowerbed implements IMessage {
    private BlockPos pos;
    private ItemStack stack1;
    private ItemStack stack2;
    private ItemStack stack3;
    private ItemStack stack4;


    public PacketUpdateDenseFlowerbed(BlockPos pos, ItemStack stack1, ItemStack stack2, ItemStack stack3, ItemStack stack4) {
        this.pos = pos;
        this.stack1 = stack1;
        this.stack2 =stack2;
        this.stack3 = stack3;
        this.stack4 = stack4;
    }

    public PacketUpdateDenseFlowerbed(TileEntityDenseFlowerbed te) {
        this(te.getPos(), te.inventory.getStackInSlot(0), te.inventory.getStackInSlot(1), te.inventory.getStackInSlot(2), te.inventory.getStackInSlot(3));


    }

    public PacketUpdateDenseFlowerbed() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeItemStack(buf, stack1);
        ByteBufUtils.writeItemStack(buf, stack2);
        ByteBufUtils.writeItemStack(buf, stack3);
        ByteBufUtils.writeItemStack(buf, stack4);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        stack1 = ByteBufUtils.readItemStack(buf);
        stack2 = ByteBufUtils.readItemStack(buf);
        stack3 = ByteBufUtils.readItemStack(buf);
        stack4 = ByteBufUtils.readItemStack(buf);
    }

    public static class Handler implements IMessageHandler<PacketUpdateDenseFlowerbed, IMessage> {

        @Override
        public IMessage onMessage(PacketUpdateDenseFlowerbed message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntityDenseFlowerbed te = (TileEntityDenseFlowerbed) Minecraft.getMinecraft().world.getTileEntity(message.pos);
                te.inventory.setStackInSlot(0, message.stack1);
                te.inventory.setStackInSlot(1, message.stack2);
                te.inventory.setStackInSlot(2, message.stack3);
                te.inventory.setStackInSlot(3, message.stack4);
            });
            return null;
        }

    }
}
