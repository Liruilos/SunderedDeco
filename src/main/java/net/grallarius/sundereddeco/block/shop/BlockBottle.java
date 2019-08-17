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

public class BlockBottle extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = VoxelShapes.or(
            Block.makeCuboidShape(4, 0, 4, 12, 9, 12),
            Block.makeCuboidShape(6, 9, 6, 10, 14, 10)) ;

    private static final Block.Properties props = Block.Properties.create(Material.GLASS)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.GLASS);

    public BlockBottle(){
        super(props);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }
}
