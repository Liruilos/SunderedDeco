package net.grallarius.sundereddeco.block.shop;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockLargeBasket extends BlockBasket {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(1, 0, 1, 15, 12, 15);

    public BlockLargeBasket(){
        super();
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }

}
