package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class BlockCrate extends BlockBase {

    protected static final VoxelShape FULL_BOX = Block.makeCuboidShape(0, 0,0,16,16,16);
    protected static final VoxelShape BOTTOM_BOX = Block.makeCuboidShape(0, 0,0,16,15,16);
    protected static final VoxelShape LIP = VoxelShapes.or(
            VoxelShapes.or(Block.makeCuboidShape(0, 15,0,16,16,2), Block.makeCuboidShape(0, 15,0,2,16,16)),
            VoxelShapes.or(Block.makeCuboidShape(0, 15,14,16,16,16), Block.makeCuboidShape(14, 15,0,16,16,16))
            );
    protected static final VoxelShape BOUNDING_BOX = VoxelShapes.or(BOTTOM_BOX, LIP);

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);
    private boolean isClosed = false;

    public BlockCrate(String name){
        super(props, name);
    }

    public BlockCrate(String name, boolean isClosed){
        super(props, name);
        this.isClosed = isClosed;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (isClosed) return FULL_BOX;
        else return BOUNDING_BOX;
    }
}
