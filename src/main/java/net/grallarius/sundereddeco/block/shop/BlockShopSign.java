package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
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
    public VoxelShape func_196244_b(IBlockState state, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
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

/*    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
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
    }*/

    @Override
    @Deprecated
    public BlockFaceShape func_193383_a(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
        return BlockFaceShape.UNDEFINED;
    }

/*    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }*/

}
