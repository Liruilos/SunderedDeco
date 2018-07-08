package net.grallarius.sundereddeco.network.garden;

import io.netty.buffer.ByteBuf;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityFlowerbed;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketRequestUpdateFlowerbed implements IMessage {
    private BlockPos pos;
    private int dimension;

    public PacketRequestUpdateFlowerbed(BlockPos pos, int dimension) {
        this.pos = pos;
        this.dimension = dimension;
    }

    public PacketRequestUpdateFlowerbed(TileEntityFlowerbed te) {
        this(te.getPos(), te.getWorld().provider.getDimension());
    }

    public PacketRequestUpdateFlowerbed() {
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

    public static class Handler implements IMessageHandler<PacketRequestUpdateFlowerbed, PacketUpdateFlowerbed> {

        @Override
        public PacketUpdateFlowerbed onMessage(PacketRequestUpdateFlowerbed message, MessageContext ctx) {
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dimension);
            TileEntityFlowerbed te = (TileEntityFlowerbed)world.getTileEntity(message.pos);
            if (te != null) {
                return new PacketUpdateFlowerbed(te);
            } else {
                return null;
            }
        }

    }
}
