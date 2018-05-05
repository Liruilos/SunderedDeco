package net.grallarius.sundereddeco.block.counter;

import net.grallarius.sundereddeco.block.BlockTileEntity;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockCounter extends BlockTileEntity<TileEntityCounter> {

    public BlockCounter() {
        super(Material.ROCK, "counter");
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityCounter tile = getTileEntity(world, pos);
            if (facing == EnumFacing.DOWN) {
                tile.decrementCount();
            } else if (facing == EnumFacing.UP) {
                tile.incrementCount();
            }
            Minecraft.getMinecraft().player.sendChatMessage("Count: " + tile.getCount());
        }
        return true;
    }

@Override
public Class<TileEntityCounter> getTileEntityClass() {
    return TileEntityCounter.class;
}
    @Nullable
    @Override
    public TileEntityCounter createTileEntity(World world, IBlockState state) {
        return new TileEntityCounter();
    }
}