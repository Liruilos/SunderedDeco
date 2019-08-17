package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockClutterPlate extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = VoxelShapes.or(
            Block.makeCuboidShape(2, 0, 2, 14, 1.5, 14),
            Block.makeCuboidShape(3, 1, 3, 13, 3.5, 13));

    private static final Properties props = Properties.create(Material.ROCK)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.STONE);

    public BlockClutterPlate(){
        super(props);
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
