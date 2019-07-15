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
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isTopSolid(IBlockState state)
    {
        return false;
    }

    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

}
