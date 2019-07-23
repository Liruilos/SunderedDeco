package net.grallarius.sundereddeco.block.home;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockChair extends BlockSittable {

    private static final VoxelShape SEAT_AND_LEGS = Block.makeCuboidShape(1, 0, 1, 15, 10, 15);
    private static final VoxelShape NORTH_BACK = Block.makeCuboidShape(1, 10, 1, 15, 20, 3);
    private static final VoxelShape EAST_BACK = Block.makeCuboidShape(13, 10, 1, 15, 20, 15);
    private static final VoxelShape SOUTH_BACK = Block.makeCuboidShape(1, 10, 13, 15, 20, 15);
    private static final VoxelShape WEST_BACK = Block.makeCuboidShape(1, 10, 1, 3, 20, 15);


    //directional code
    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockChair(String name) {
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        if (context.getPlayer() != null) {
            return super.getStateForPlacement(context)
                    .with(FACING, context.getPlayer().getHorizontalFacing());
        }else return super.getStateForPlacement(context).with(FACING, Direction.NORTH);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape COMBI_SHAPE = SEAT_AND_LEGS;
        if (state.get(FACING) == Direction.NORTH){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, NORTH_BACK);
        }
        else if (state.get(FACING) == Direction.EAST){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, EAST_BACK);
        }
        else if (state.get(FACING) == Direction.SOUTH){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, SOUTH_BACK);
        }
        else if (state.get(FACING) == Direction.WEST){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, WEST_BACK);
        }
        return COMBI_SHAPE;
    }

}
