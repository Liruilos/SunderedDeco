package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
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

public class BlockHedge extends BlockBase {

    /** Whether the hedge should extend to the north */
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    /** Whether the hedge should extend to the east */
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    /** Whether the hedge should extend to the south */
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    /** Whether the hedge should extend to the west */
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    /** Similar logic for top hedge block */
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    public static final BooleanProperty TOPNORTH = BooleanProperty.create("topnorth");
    public static final BooleanProperty TOPEAST = BooleanProperty.create("topeast");
    public static final BooleanProperty TOPSOUTH = BooleanProperty.create("topsouth");
    public static final BooleanProperty TOPWEST = BooleanProperty.create("topwest");

    private static final VoxelShape CENTRE_BOX = Block.makeCuboidShape(2, 0, 2, 14, 16, 14);
    private static final VoxelShape NCONNECT_BOX = Block.makeCuboidShape(2, 0, 0, 14, 16, 2);
    private static final VoxelShape ECONNECT_BOX = Block.makeCuboidShape(14, 0, 2, 16, 16, 14);
    private static final VoxelShape SCONNECT_BOX = Block.makeCuboidShape(2, 0, 14, 14, 16, 16);
    private static final VoxelShape WCONNECT_BOX = Block.makeCuboidShape(0, 0, 2, 2, 16, 14);



    private static final Properties props = Properties.create(Material.LEAVES)
            .sound(SoundType.PLANT);

    public BlockHedge(){
        super(props);
        this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.FALSE).with(EAST, Boolean.FALSE)
                .with(SOUTH, Boolean.FALSE).with(WEST, Boolean.FALSE).with(TOP, Boolean.FALSE).with(TOPNORTH, Boolean.FALSE)
                .with(TOPEAST, Boolean.FALSE).with(TOPSOUTH, Boolean.FALSE).with(TOPWEST, Boolean.FALSE));

    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, TOP, TOPNORTH, TOPEAST, TOPSOUTH, TOPWEST);
    }
    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        VoxelShape COMBI_SHAPE = CENTRE_BOX;
        if (state.get(NORTH)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, NCONNECT_BOX);
        }
        if (state.get(EAST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, ECONNECT_BOX);
        }
        if (state.get(SOUTH)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, SCONNECT_BOX);
        }
        if (state.get(WEST)){
            COMBI_SHAPE = VoxelShapes.or(COMBI_SHAPE, WCONNECT_BOX);
        }
        return COMBI_SHAPE;
    }

    private BlockState connectedState(IWorld world, BlockPos pos){
        boolean northHedge = world.getBlockState(pos.north()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.north()).getBlock().isSolid(world.getBlockState(pos.north()))
                || world.getBlockState(pos.north()).getBlock() instanceof FenceGateBlock;
        boolean southHedge = world.getBlockState(pos.south()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.south()).getBlock().isSolid(world.getBlockState(pos.south()))
                || world.getBlockState(pos.south()).getBlock() instanceof FenceGateBlock;
        boolean eastHedge = world.getBlockState(pos.east()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.east()).getBlock().isSolid(world.getBlockState(pos.east()))
                || world.getBlockState(pos.east()).getBlock() instanceof FenceGateBlock;
        boolean westHedge = world.getBlockState(pos.west()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.west()).getBlock().isSolid(world.getBlockState(pos.west()))
                || world.getBlockState(pos.west()).getBlock() instanceof FenceGateBlock;
        boolean hedgeBelow = world.getBlockState(pos.down()).getBlock() instanceof BlockHedge;

        BlockState newState = this.getDefaultState()
                .with(NORTH, !hedgeBelow && northHedge)
                .with(EAST,  !hedgeBelow && eastHedge)
                .with(SOUTH, !hedgeBelow && southHedge)
                .with(WEST,  !hedgeBelow && westHedge)
                .with(TOP, hedgeBelow)
                .with(TOPNORTH, hedgeBelow && northHedge)
                .with(TOPEAST, hedgeBelow && eastHedge)
                .with(TOPSOUTH, hedgeBelow && southHedge)
                .with(TOPWEST, hedgeBelow && westHedge);
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


    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
