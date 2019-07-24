package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockShopSign extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX_NS = Block.makeCuboidShape(6, 1, 1, 10, 16, 15);
    private static final VoxelShape BOUNDING_BOX_EW = Block.makeCuboidShape(1, 1, 6, 15, 16, 10);

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockShopSign(String name){
        super(props, name);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING))
        {
            case NORTH:
                return BOUNDING_BOX_NS;
            case SOUTH:
                return BOUNDING_BOX_NS;
            case WEST:
                return BOUNDING_BOX_EW;
            case EAST:
            default:
                return BOUNDING_BOX_EW;
        }
    }

}
