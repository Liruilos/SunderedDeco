package net.grallarius.sundereddeco.block;


import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public abstract class BlockConnectableHTileEntity<TE extends TileEntity> extends BlockConnectableHorizontal {

    public BlockConnectableHTileEntity(Block.Properties properties, String name) {
        super(properties);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockReader world, BlockPos pos) {
        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }


}
