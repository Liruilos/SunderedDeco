package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockConnectedChair extends BlockChair {

    /** Whether there should be legs in the N position */
    public static final PropertyBool NORTH = PropertyBool.create("north");
    /** Whether there should be legs in the E position */
    public static final PropertyBool EAST = PropertyBool.create("east");
    /** Whether there should be legs in the S position */
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    /** Whether there should be legs in the W position */
    public static final PropertyBool WEST = PropertyBool.create("west");

    public BlockConnectedChair() {
        super();
    }

    /** If no other connectable Chair in that cardinal direction in the right axis then add legs (and an armrest) */
    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        boolean northChair = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockConnectedChair;
        boolean southChair = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockConnectedChair;
        boolean eastChair = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockConnectedChair;
        boolean westChair = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockConnectedChair;

        return state.withProperty(NORTH, !northChair)
                .withProperty(EAST,  !eastChair)
                .withProperty(SOUTH, !southChair)
                .withProperty(WEST,  !westChair);
    }

}
