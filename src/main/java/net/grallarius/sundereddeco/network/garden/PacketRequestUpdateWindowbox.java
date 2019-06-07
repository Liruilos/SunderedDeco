package net.grallarius.sundereddeco.network.garden;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//implements IMessage
public class PacketRequestUpdateWindowbox  {
    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdateWindowbox(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }

    public PacketRequestUpdateWindowbox(TileEntityWindowbox te) {
        //this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PacketRequestUpdateWindowbox() {
    }
/*
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(dimension);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        dimension = buf.readInt();
    }

    public static class Handler implements IMessageHandler<PacketRequestUpdateWindowbox, PacketUpdateWindowbox> {

        @Override
        public PacketUpdateWindowbox onMessage(PacketRequestUpdateWindowbox message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            TileEntityWindowbox te = (TileEntityWindowbox)world.getTileEntity(message.pos);
            if (te != null) {
                return new PacketUpdateWindowbox(te);
            } else {
                return null;
            }
        }

    }*/
}
