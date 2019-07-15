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

public class BlockBasket extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(1, 0, 1, 15, 6, 15);

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.WOOD);

    public BlockBasket(String name){
        super(props, name);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
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
