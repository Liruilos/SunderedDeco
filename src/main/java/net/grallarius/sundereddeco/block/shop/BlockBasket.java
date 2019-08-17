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

public class BlockBasket extends BlockDirectional {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(1, 0, 1, 15, 6, 15);

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.WOOD);

    public BlockBasket(){
        super(props);
    }


    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }

}
