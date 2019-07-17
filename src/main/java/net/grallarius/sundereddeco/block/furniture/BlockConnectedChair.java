package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

//TODO get to update correctly once placed, logic is whack, also needs model update
public class BlockConnectedChair extends BlockChair {
    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 12, 16);

    /** Whether there should be legs to the left */
    public static final BooleanProperty NORTHSIDE = BooleanProperty.create("northside");
    public static final BooleanProperty EASTSIDE = BooleanProperty.create("eastside");
    public static final BooleanProperty SOUTHSIDE = BooleanProperty.create("southside");
    public static final BooleanProperty WESTSIDE = BooleanProperty.create("westside");
    public static final BooleanProperty NORTHBACK = BooleanProperty.create("northback");
    public static final BooleanProperty EASTBACK = BooleanProperty.create("eastback");
    public static final BooleanProperty SOUTHBACK = BooleanProperty.create("southback");
    public static final BooleanProperty WESTBACK = BooleanProperty.create("westback");


    public BlockConnectedChair(String name){
        super(name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(NORTHBACK, true)
        .with(EASTBACK, false).with(SOUTHBACK, false).with(WESTBACK, false).with(NORTHSIDE, false)
        .with(EASTSIDE, true).with(SOUTHSIDE, false).with(WESTSIDE, true));
    }

/*    @Override
    @Deprecated
    public VoxelShape func_196244_b(BlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return BOUNDING_BOX;
    }*/

/*    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
    }*/

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer() != null) {
            return super.getStateForPlacement(context)
                    .with(FACING, context.getPlayer().getHorizontalFacing());
        }else return super.getStateForPlacement(context).with(FACING, Direction.NORTH);
    }

    /** Logic for connectable chair submodels */
    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos pos, BlockPos facingPos) {

        BlockState blockleft = world.getBlockState(pos.offset(state.get(FACING).rotateYCCW()));
        BlockState blockright = world.getBlockState(pos.offset(state.get(FACING).rotateY()));
        BlockState blockfront = world.getBlockState(pos.offset(state.get(FACING).getOpposite()));
        BlockState blockback = world.getBlockState(pos.offset(state.get(FACING)));

        boolean leftChair = blockleft.getBlock() instanceof BlockConnectedChair && !(state.get(FACING) == blockleft.get(FACING).getOpposite());
        boolean rightChair = blockright.getBlock() instanceof BlockConnectedChair && !(state.get(FACING) == blockright.get(FACING).getOpposite());
        boolean frontChairLeft = blockfront.getBlock() instanceof BlockConnectedChair && (state.get(FACING) == blockfront.get(FACING).rotateY());
        boolean frontChairRight = blockfront.getBlock() instanceof BlockConnectedChair && (state.get(FACING) == blockfront.get(FACING).rotateYCCW());
        boolean backChairLeft = blockback.getBlock() instanceof BlockConnectedChair && (state.get(FACING) == blockback.get(FACING).rotateY());
        boolean backChairRight = blockback.getBlock() instanceof BlockConnectedChair && (state.get(FACING) == blockback.get(FACING).rotateYCCW());

        boolean outer = (backChairLeft && rightChair) || (backChairRight && leftChair);
        boolean innerExtraLeft = rightChair && frontChairRight;
        boolean innerExtraRight = leftChair && frontChairLeft;

        BlockState newState = state
                .with(NORTHSIDE, (state.get(FACING) == Direction.EAST && !leftChair)
                        || (state.get(FACING) == Direction.WEST && !rightChair))
                .with(EASTSIDE,(state.get(FACING) == Direction.SOUTH && !leftChair)
                        || (state.get(FACING) == Direction.NORTH && !rightChair))
                .with(SOUTHSIDE, (state.get(FACING) == Direction.WEST && !leftChair)
                        || (state.get(FACING) == Direction.EAST && !rightChair))
                .with(WESTSIDE,(state.get(FACING) == Direction.NORTH && !leftChair)
                        || (state.get(FACING) == Direction.SOUTH && !rightChair))
                .with(NORTHBACK, (state.get(FACING) == Direction.NORTH && !outer)
                        || (state.get(FACING) == Direction.WEST && innerExtraRight)
                        || (state.get(FACING) == Direction.EAST && innerExtraLeft))
                .with(EASTBACK, (state.get(FACING) == Direction.EAST && !outer)
                        || (state.get(FACING) == Direction.NORTH && innerExtraRight)
                        || (state.get(FACING) == Direction.SOUTH && innerExtraLeft))
                .with(SOUTHBACK, (state.get(FACING) == Direction.SOUTH && !outer)
                        || (state.get(FACING) == Direction.EAST && innerExtraRight)
                        || (state.get(FACING) == Direction.WEST && innerExtraLeft))
                .with(WESTBACK, (state.get(FACING) == Direction.WEST && !outer)
                        || (state.get(FACING) == Direction.SOUTH && innerExtraRight)
                        || (state.get(FACING) == Direction.NORTH && innerExtraLeft));
        return newState;
    }


    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, NORTHSIDE, EASTSIDE, SOUTHSIDE, WESTSIDE, NORTHBACK, EASTBACK, SOUTHBACK, WESTBACK);
    }

}
