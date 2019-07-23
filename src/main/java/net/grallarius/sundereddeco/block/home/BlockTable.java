package net.grallarius.sundereddeco.block.home;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class BlockTable extends BlockBase{

    /** Whether there should be a leg in the NW position */
    public static final BooleanProperty NORTHWEST = BooleanProperty.create("northwest");
    /** Whether there should be a leg in the NE position */
    public static final BooleanProperty NORTHEAST = BooleanProperty.create("northeast");
    /** Whether there should be a leg in the SE position */
    public static final BooleanProperty SOUTHEAST = BooleanProperty.create("southeast");
    /** Whether there should be a leg in the SW position */
    public static final BooleanProperty SOUTHWEST = BooleanProperty.create("southwest");


    private static final Properties props = Properties.create(Material.WOOD)
            .sound(SoundType.WOOD);

    private static final VoxelShape TABLETOP_BOX = Block.makeCuboidShape(0, 14, 0, 16, 16, 16);
    private static final VoxelShape NWLEG_BOX = Block.makeCuboidShape(1, 0, 1, 4, 14, 4);
    private static final VoxelShape NELEG_BOX = Block.makeCuboidShape(12, 0, 1, 15, 14, 4);
    private static final VoxelShape SELEG_BOX = Block.makeCuboidShape(12, 0, 12, 15, 14, 15);
    private static final VoxelShape SWLEG_BOX = Block.makeCuboidShape(1, 0, 12, 4, 14, 15);


    public BlockTable(String name) {
        super(props, name);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape COMBI_SHAPE = TABLETOP_BOX;
        if (state.get(NORTHEAST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, NELEG_BOX);
        }
        if (state.get(NORTHWEST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, NWLEG_BOX);
        }
        if (state.get(SOUTHEAST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, SELEG_BOX);
        }
        if (state.get(SOUTHWEST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, SWLEG_BOX);
        }
        return COMBI_SHAPE;
    }

    /** If no other block of type table present in relevant 2 cardinal directions, add a leg in that corner */
    private BlockState connectedState(IWorld world, BlockPos pos){

        boolean northTable = world.getBlockState(pos.north()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.north()).getBlock().isSolid(world.getBlockState(pos.north()));
        boolean southTable = world.getBlockState(pos.south()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.south()).getBlock().isSolid(world.getBlockState(pos.south()));
        boolean eastTable = world.getBlockState(pos.east()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.east()).getBlock().isSolid(world.getBlockState(pos.east()));
        boolean westTable = world.getBlockState(pos.west()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.west()).getBlock().isSolid(world.getBlockState(pos.west()));

        BlockState newState = this.getDefaultState()
                .with(NORTHWEST, !northTable && !westTable)
                .with(NORTHEAST,  !northTable && !eastTable)
                .with(SOUTHEAST, !southTable && !eastTable)
                .with(SOUTHWEST,  !southTable && !westTable);
        return newState;
    }

    @Override
    @Deprecated
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return connectedState(world, currentPos);
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return connectedState(context.getWorld(), context.getPos());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
