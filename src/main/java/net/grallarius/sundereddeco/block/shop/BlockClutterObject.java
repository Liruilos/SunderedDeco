package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockClutterObject extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(2, 0, 2, 14, 11, 14);

    public BlockClutterObject(Material material){
        super(Block.Properties.create(material).hardnessAndResistance(2F, 10F));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }
}
