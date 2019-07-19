package net.grallarius.sundereddeco.block.counter;

import net.grallarius.sundereddeco.block.BlockTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
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
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            if (world.getTileEntity(pos) != null && world.getTileEntity(pos) instanceof TileEntityCounter) {
                TileEntityCounter tile = (TileEntityCounter) world.getTileEntity(pos);
                //facing == EnumFacing.DOWN
                if (hit.getFace() == Direction.DOWN) {
                    tile.decrementCount();
                    //facing == EnumFacing.UP
                } else if (hit.getFace() == Direction.UP) {
                    tile.incrementCount();
                }
                Minecraft.getInstance().player.sendChatMessage("Count: " + tile.getCount());
            }
        } return true;
    }

    public TileEntity createNewTileEntity(IBlockReader worldIn) {
        return new TileEntityCounter();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

}