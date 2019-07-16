package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockPlanterbox extends BlockConnectableHorizontal {

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockPlanterbox(String name){
        super(props, name);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.SINGLE));
    }

/*    @Override
    @Deprecated
    public VoxelShape func_196244_b(IBlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return BOUNDING_BOX;
    }*/


    @Override
    @Deprecated
    public BlockFaceShape func_193383_a(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
        return BlockFaceShape.SOLID;
    }

/*    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
    {
        return BlockFaceShape.SOLID;
    }*/

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockReader world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable){ return true;}

}
