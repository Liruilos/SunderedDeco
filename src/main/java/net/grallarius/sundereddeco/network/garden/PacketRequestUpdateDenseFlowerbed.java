package net.grallarius.sundereddeco.network.garden;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityDenseFlowerbed;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

//implements IMessage
public class PacketRequestUpdateDenseFlowerbed {
    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdateDenseFlowerbed(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }
/*
    public PacketRequestUpdateDenseFlowerbed(TileEntityDenseFlowerbed te) {
        this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PacketRequestUpdateDenseFlowerbed() {
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

    public static class Handler implements IMessageHandler<PacketRequestUpdateDenseFlowerbed, PacketUpdateDenseFlowerbed> {

        @Override
        public PacketUpdateDenseFlowerbed onMessage(PacketRequestUpdateDenseFlowerbed message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            TileEntityDenseFlowerbed te = (TileEntityDenseFlowerbed)world.getTileEntity(message.pos);
            if (te != null) {
                return new PacketUpdateDenseFlowerbed(te);
            } else {
                return null;
            }
        }

    }*/
}
