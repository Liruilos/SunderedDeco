package net.grallarius.sundereddeco.block.furniture;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChair extends BlockSittable {


    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.125D, 0.0D,0.125D,0.875D,0.62D,0.875D);

    //directional code
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public BlockChair(String name) {
        super(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    @Override
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    //model higher than 1 block - make blocks unable to be placed directly on top? or leave so back is unbounded cause it looks good?

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

}
