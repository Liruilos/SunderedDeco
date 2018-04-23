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
    /** Whether there should be legs to the right */
    public static final PropertyBool LEFTCORNER = PropertyBool.create("leftcorner");
    /** Whether there should be legs to the right */
    public static final PropertyBool RIGHTCORNER = PropertyBool.create("rightcorner");
    /** Whether there should be legs to the right */
    public static final PropertyBool HASBACK = PropertyBool.create("hasback");

    public BlockConnectedChair() {
        super("parkbench");
    }


    /** Logic for connectable chair submodels */
    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {

        IBlockState blockleft = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW()));
        IBlockState blockright = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateY()));
        IBlockState blockfront = worldIn.getBlockState(pos.offset(state.getValue(FACING).getOpposite()));
        IBlockState blockback = worldIn.getBlockState(pos.offset(state.getValue(FACING)));

        boolean leftChair = blockleft.getBlock() instanceof BlockConnectedChair && !(state.getValue(FACING) == blockleft.getValue(FACING).getOpposite());
        boolean rightChair = blockright.getBlock() instanceof BlockConnectedChair && !(state.getValue(FACING) == blockright.getValue(FACING).getOpposite());
        boolean frontChairLeft = blockfront.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockfront.getValue(FACING).rotateY());
        boolean frontChairRight = blockfront.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockfront.getValue(FACING).rotateYCCW());
        boolean backChairLeft = blockback.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockback.getValue(FACING).rotateY());
        boolean backChairRight = blockback.getBlock() instanceof BlockConnectedChair && (state.getValue(FACING) == blockback.getValue(FACING).rotateYCCW());

        /** LEFTCORNER / RIGHTCORNER submodels add back rotated in correct position to make internal corners */
        /** LEFTSIDE /RIGHTSIDE submodel added if no other connectable Chair to the side (in any direction but opposite) */
        /** Submodel for sides must be separate as submodel is mirrored not rotated, unlike for the corners */
        /** HASBACK property usually true, exception is when forming an outer corner */


        return state.withProperty(LEFTCORNER, frontChairLeft && !leftChair)
                .withProperty(RIGHTCORNER, frontChairRight && !rightChair)
                .withProperty(LEFTSIDE, !leftChair && !frontChairLeft && !backChairRight)
                .withProperty(RIGHTSIDE,  !rightChair && !frontChairRight && !backChairLeft)
                .withProperty(HASBACK, !((backChairLeft && !rightChair && !frontChairLeft) || (backChairRight && !leftChair && !frontChairRight)));

    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, LEFTSIDE, RIGHTSIDE, LEFTCORNER, RIGHTCORNER, HASBACK});
    }
}
