package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockConnectedChair extends BlockChair {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,0.62D,1.0D);

    /** Whether there should be legs to the left */
    public static final PropertyBool LEFTSIDE = PropertyBool.create("leftside");
    /** Whether there should be legs to the right */
    public static final PropertyBool RIGHTSIDE = PropertyBool.create("rightside");

    public BlockConnectedChair() {
        super("parkbench");
    }

    /** If no other connectable Chair to the left side (anticlockwise in y) in the same axis then add left side submodel */
    /** If no other connectable Chair to the right side (clockwise in y) in the same axis then add right side submodel */
    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {

        IBlockState blockleft = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW()));
        IBlockState blockright = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateY()));

        boolean leftChair = blockleft.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockleft.getValue(FACING));
        boolean rightChair = blockright.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockright.getValue(FACING));

        return state.withProperty(LEFTSIDE, !leftChair)
                .withProperty(RIGHTSIDE,  !rightChair);

    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, LEFTSIDE, RIGHTSIDE});
    }
}
