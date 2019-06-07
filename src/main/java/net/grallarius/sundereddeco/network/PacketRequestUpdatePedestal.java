package net.grallarius.sundereddeco.network;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.pedestal.TileEntityPedestal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//implements IMessage
public class PacketRequestUpdatePedestal {
    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdatePedestal(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }
/*
    public PacketRequestUpdatePedestal(TileEntityPedestal tep) {
        this(tep.getPos(), tep.getWorld().provider.getDimension());
    }

    public PacketRequestUpdatePedestal() {
    }

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

    public static class Handler implements IMessageHandler<PacketRequestUpdatePedestal, PacketUpdatePedestal> {

        @Override
        public PacketUpdatePedestal onMessage(PacketRequestUpdatePedestal message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            TileEntityPedestal tep = (TileEntityPedestal)world.getTileEntity(message.pos);
            if (tep != null) {
                return new PacketUpdatePedestal(tep);
            } else {
                return null;
            }
        }

    }*/
}
