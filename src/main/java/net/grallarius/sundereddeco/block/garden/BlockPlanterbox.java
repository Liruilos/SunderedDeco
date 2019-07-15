package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockPlanterbox extends BlockConnectableHorizontal {

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockPlanterbox(String name){
        super(props, name);
        //this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.SINGLE));
    }

/*    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,1.125D,1.0D);*/


    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_)
    {
        return BlockFaceShape.SOLID;
    }

    @Override
    @Deprecated
    public boolean isTopSolid(IBlockState state) {
        return true;
    }

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockReader world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable){ return true;}



/*    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }*/
}
