package net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking;

import net.grallarius.sundereddeco.block.BlockTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
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
    public void onBlockClicked(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntityCounter) {
                TileEntityCounter tile = (TileEntityCounter) world.getTileEntity(pos);
                //facing == EnumFacing.DOWN
                if (player.cameraYaw <= 0) {
                    tile.decrementCount();
                    //facing == EnumFacing.UP
                } else if (player.cameraYaw > 0) {
                    tile.incrementCount();
                }
                Minecraft.getInstance().player.sendChatMessage("Count: " + tile.getCount());
            }
        }
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityCounter();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

}