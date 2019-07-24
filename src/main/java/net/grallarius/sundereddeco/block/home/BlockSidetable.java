package net.grallarius.sundereddeco.block.home;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockSidetable extends BlockDirectional {

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    private static final VoxelShape BOUNDING_BOX = VoxelShapes.or(
            Block.makeCuboidShape(0, 13, 0, 16, 16, 16),
            Block.makeCuboidShape(1, 0, 1, 15, 13, 15)) ;


    public BlockSidetable(String name){
        super(props, name);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }
}
