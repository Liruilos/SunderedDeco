package net.grallarius.sundereddeco.network.garden;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityFlowerbed;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdateFlowerbed implements IMessage {
    private BlockPos pos;
    private ItemStack stack1;
    private ItemStack stack2;



    public PacketUpdateFlowerbed(BlockPos pos, ItemStack stack1, ItemStack stack2) {
        this.pos = pos;
        this.stack1 = stack1;
        this.stack2 =stack2;

    }

    public PacketUpdateFlowerbed(TileEntityFlowerbed te) {
        this(te.getPos(), te.inventory.getStackInSlot(0), te.inventory.getStackInSlot(1));


    }

    public PacketUpdateFlowerbed() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeItemStack(buf, stack1);
        ByteBufUtils.writeItemStack(buf, stack2);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        stack1 = ByteBufUtils.readItemStack(buf);
        stack2 = ByteBufUtils.readItemStack(buf);
    }

    public static class Handler implements IMessageHandler<PacketUpdateFlowerbed, IMessage> {

        @Override
        public IMessage onMessage(PacketUpdateFlowerbed message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntityFlowerbed te = (TileEntityFlowerbed) Minecraft.getMinecraft().world.getTileEntity(message.pos);
                te.inventory.setStackInSlot(0, message.stack1);
                te.inventory.setStackInSlot(1, message.stack2);
            });
            return null;
        }

    }
}
