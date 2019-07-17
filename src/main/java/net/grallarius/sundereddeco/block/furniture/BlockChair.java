package net.grallarius.sundereddeco.block.furniture;

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
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class BlockChair extends BlockSittable {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(2, 0, 2, 14, 10, 14);

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

/*    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
        //TODO try to add chair back to the bounding box?
        //return VoxelShapes.combine(BOUNDING_BOX, BOUNDING_BOX2, IBooleanFunction.AND);
    }*/

/*    @Override
    @Deprecated
    public VoxelShape func_196244_b(BlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return BOUNDING_BOX;
    }*/

}
