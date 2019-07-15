package net.grallarius.sundereddeco.block.furniture;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
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

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 16, 16);

    private static final Properties props = Properties.create(Material.WOOD)
            .sound(SoundType.WOOD);

/*    public static final AxisAlignedBB TABLETOP_AABB = new AxisAlignedBB(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB NORTHWEST_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 1.5D, 1.0D);
    public static final AxisAlignedBB NORTHEAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.375D, 1.5D, 0.625D);
    public static final AxisAlignedBB SOUTHEAST_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.5D, 0.375D);
    public static final AxisAlignedBB SOUTHWEST_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.375D, 1.0D, 1.5D, 0.625D);
*/
    public BlockTable(String name) {
        super(props, name);
    }

    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
    }

    /** If no other block of type table present in relevant 2 cardinal directions, add a leg in that corner */
    private IBlockState connectedState(IWorld world, BlockPos pos){

        boolean northTable = world.getBlockState(pos.north()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.north()).getBlock().isFullCube(world.getBlockState(pos.north()));
        boolean southTable = world.getBlockState(pos.south()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.south()).getBlock().isFullCube(world.getBlockState(pos.south()));
        boolean eastTable = world.getBlockState(pos.east()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.east()).getBlock().isFullCube(world.getBlockState(pos.east()));
        boolean westTable = world.getBlockState(pos.west()).getBlock() instanceof BlockTable
                || world.getBlockState(pos.west()).getBlock().isFullCube(world.getBlockState(pos.west()));

        IBlockState newState = this.getDefaultState()
                .with(NORTHWEST, !northTable && !westTable)
                .with(NORTHEAST,  !northTable && !eastTable)
                .with(SOUTHEAST, !southTable && !eastTable)
                .with(SOUTHWEST,  !southTable && !westTable);
        return newState;
    }

    @Override
    @Deprecated
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return connectedState(world, currentPos);
    }

    @Override
    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return connectedState(context.getWorld(), context.getPos());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(NORTHEAST, NORTHWEST, SOUTHEAST, SOUTHWEST);
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isTopSolid(IBlockState state)
    {
        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}
