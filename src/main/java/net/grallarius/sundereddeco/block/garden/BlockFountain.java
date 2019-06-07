package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockFountain extends BlockConnectableHorizontal {


    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,0.9375D,1.0D);

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockFountain(String name) {
        super(props, name);
    }

/*    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockReader worldIn, BlockPos pos) {

        EnumShape shape = getShape(state, worldIn, pos, worldIn.getBlockState(pos).getClass());
        return state.withProperty(SHAPE, shape);
    }*/

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return Minecraft.getInstance().gameSettings.fancyGraphics ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.SOLID;
    }

/*    @Override
    @OnlyIn(Dist.CLIENT)
    @Deprecated
    public static boolean shouldSideBeRendered(IBlockState adjacentState, IBlockReader blockState, BlockPos blockAccess, EnumFacing pos) {
        IBlockState iblockstate = blockState.getBlockState(blockAccess.offset(pos));
        Block block = iblockstate.getBlock();

        if (this == ModBlocks.fountain)
        {
                return false;
        }

        return (block != this) && super.shouldSideBeRendered(adjacentState, blockAccess, pos, side);
    }*/

/*    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return *//*!Minecraft.getMinecraft().gameSettings.fancyGraphics && *//*blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }*/

/*
    //@Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }*/

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

}
