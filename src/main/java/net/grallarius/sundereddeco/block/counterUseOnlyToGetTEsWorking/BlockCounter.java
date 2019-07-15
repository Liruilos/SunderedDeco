package net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking;

import net.grallarius.sundereddeco.block.BlockTileEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockCounter extends BlockTileEntity {

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockCounter() {
        super(props, "counter");
    }

    @Override
    @Deprecated
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntityCounter) {
                TileEntityCounter tile = (TileEntityCounter) world.getTileEntity(pos);
                if (facing == EnumFacing.DOWN) {
                    tile.decrementCount();
                } else if (facing == EnumFacing.UP) {
                    tile.incrementCount();
                }
                Minecraft.getInstance().player.sendChatMessage("Count: " + tile.getCount());
            }
        }
        return true;
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityCounter();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

}