package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockPlanterbox extends BlockConnectableHorizontal {

    private static final Properties props = Properties.create(Material.ROCK).sound(SoundType.STONE);
    protected static final VoxelShape BOUNDBOX = Block.makeCuboidShape(0, 0,0,16,18,16);

    public BlockPlanterbox(String name){
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(SHAPE, EnumShape.SINGLE));
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDBOX;
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, net.minecraftforge.common.IPlantable plantable){ return true;}

}
