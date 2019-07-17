package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockFountain extends BlockConnectableHorizontal {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 15, 16);

    private static final Properties props = Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockFountain(String name) {
        super(props, name);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return Minecraft.getInstance().gameSettings.fancyGraphics ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.CUTOUT;
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

/*    @Override
    @Deprecated
    public VoxelShape func_196244_b(IBlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
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
    public boolean isFullCube(IBlockState state) {
        return false;
    }*/

}
