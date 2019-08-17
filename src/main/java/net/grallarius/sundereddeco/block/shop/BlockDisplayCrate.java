package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockDisplayCrate extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(1, 0, 1, 15, 10, 15);

    private static final Block.Properties props = Block.Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockDisplayCrate(){
        super(props);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }

}
