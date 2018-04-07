package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChair extends BlockSittable {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.125D, 0.0D,0.125D,0.875D,1.0D,0.875D);

    //directional code

    //ability to be higher than 1 block

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

}
