package net.grallarius.sundereddeco.network;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketUpdateWindowbox implements IMessage {
    private BlockPos pos;
    private ItemStack stack;
    private long lastChangeTime;

    public PacketUpdateWindowbox(BlockPos pos, ItemStack stack, long lastChangeTime) {
        this.pos = pos;
        this.stack = stack;
        this.lastChangeTime = lastChangeTime;
    }

    public PacketUpdateWindowbox(TileEntityWindowbox tew) {
        this(tew.getPos(), tew.inventory.getStackInSlot(0), tew.lastChangeTime);
    }

    public PacketUpdateWindowbox() {
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeItemStack(buf, stack);
        buf.writeLong(lastChangeTime);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        stack = ByteBufUtils.readItemStack(buf);
        lastChangeTime = buf.readLong();
    }

    public static class Handler implements IMessageHandler<PacketUpdateWindowbox, IMessage> {

        @Override
        public IMessage onMessage(PacketUpdateWindowbox message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TileEntityWindowbox tew = (TileEntityWindowbox)Minecraft.getMinecraft().world.getTileEntity(message.pos);
                tew.inventory.setStackInSlot(0, message.stack);
                tew.lastChangeTime = message.lastChangeTime;
            });
            return null;
        }

    }
}
