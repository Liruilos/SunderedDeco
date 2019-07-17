package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

/*    @Override
    @Deprecated
    public BlockFaceShape func_193383_a(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
        return BlockFaceShape.UNDEFINED;
    }*/

/*    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }*/

}
