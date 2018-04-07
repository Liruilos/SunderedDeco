package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockChair extends BlockSittable {

    public BlockChair() {
        super( "chair");
    }

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.065D, 0.0D,0.065D,0.935D,0.62D,0.935D);

    //directional code

    //model higher than 1 block - make blocks unable to be placed directly on top? or leave so back is unbounded?

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

}
