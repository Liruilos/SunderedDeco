package net.grallarius.sundereddeco.block.garden.flowerbeds;


import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockFlowerbed extends BlockConnectableHorizontal {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,0.6D,1.0D);

    public BlockFlowerbed(String name){
        super(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.SINGLE));
    }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        EnumShape shape = getShape(state, worldIn, pos, worldIn.getBlockState(pos).getClass());
        return state.withProperty(SHAPE, shape);
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

}
