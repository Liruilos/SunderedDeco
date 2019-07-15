package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.125D, 0.0D,0.125D,0.875D,1.0D,0.875D);

    private static final Properties props = Properties.create(Material.LEAVES)
            .sound(SoundType.PLANT);

    public BlockHedge(String name){
        super(props, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, Boolean.FALSE).with(EAST, Boolean.FALSE)
                .with(SOUTH, Boolean.FALSE).with(WEST, Boolean.FALSE).with(TOP, Boolean.FALSE).with(TOPNORTH, Boolean.FALSE)
                .with(TOPEAST, Boolean.FALSE).with(TOPSOUTH, Boolean.FALSE).with(TOPWEST, Boolean.FALSE));

    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(NORTH, EAST, SOUTH, WEST, TOP, TOPNORTH, TOPEAST, TOPSOUTH, TOPWEST);
    }
/*
    //@Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }*/


    private IBlockState connectedState(IWorld world, BlockPos pos){
        boolean northHedge = world.getBlockState(pos.north()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.north()).getBlock().isFullCube(world.getBlockState(pos.north()))
                || world.getBlockState(pos.north()).getBlock() instanceof BlockFenceGate;
        boolean southHedge = world.getBlockState(pos.south()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.south()).getBlock().isFullCube(world.getBlockState(pos.south()))
                || world.getBlockState(pos.south()).getBlock() instanceof BlockFenceGate;
        boolean eastHedge = world.getBlockState(pos.east()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.east()).getBlock().isFullCube(world.getBlockState(pos.east()))
                || world.getBlockState(pos.east()).getBlock() instanceof BlockFenceGate;
        boolean westHedge = world.getBlockState(pos.west()).getBlock() instanceof BlockHedge
                || world.getBlockState(pos.west()).getBlock().isFullCube(world.getBlockState(pos.west()))
                || world.getBlockState(pos.west()).getBlock() instanceof BlockFenceGate;
        boolean hedgeBelow = world.getBlockState(pos.down()).getBlock() instanceof BlockHedge;

        IBlockState newState = this.getDefaultState()
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
    public IBlockState updatePostPlacement(IBlockState stateIn, EnumFacing facing, IBlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
        return connectedState(world, currentPos);
    }

    @Override
    @Nullable
    public IBlockState getStateForPlacement(BlockItemUseContext context) {
        return connectedState(context.getWorld(), context.getPos());
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer(){
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
