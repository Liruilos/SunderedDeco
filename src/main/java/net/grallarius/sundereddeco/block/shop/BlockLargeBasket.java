package net.grallarius.sundereddeco.block.shop;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLargeBasket extends BlockBasket {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.065D, 0.0D,0.065D,0.935D,0.8D,0.935D);

    public BlockLargeBasket(String name){
        super(name);
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

}
