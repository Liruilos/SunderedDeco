package net.grallarius.sundereddeco.block.furniture;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockTable extends BlockBase{

    /** Whether there should be a leg in the NW position */
    public static final PropertyBool NORTHWEST = PropertyBool.create("northwest");
    /** Whether there should be a leg in the NE position */
    public static final PropertyBool NORTHEAST = PropertyBool.create("northeast");
    /** Whether there should be a leg in the SE position */
    public static final PropertyBool SOUTHEAST = PropertyBool.create("southeast");
    /** Whether there should be a leg in the SW position */
    public static final PropertyBool SOUTHWEST = PropertyBool.create("southwest");

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.0D, 0.0D,0.0D,1.0D,1.0D,1.0D);

/*    public static final AxisAlignedBB TABLETOP_AABB = new AxisAlignedBB(0.0D, 0.8D, 0.0D, 1.0D, 1.0D, 1.0D);
    public static final AxisAlignedBB NORTHWEST_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.625D, 0.625D, 1.5D, 1.0D);
    public static final AxisAlignedBB NORTHEAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 0.375D, 1.5D, 0.625D);
    public static final AxisAlignedBB SOUTHEAST_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 0.625D, 1.5D, 0.375D);
    public static final AxisAlignedBB SOUTHWEST_AABB = new AxisAlignedBB(0.625D, 0.0D, 0.375D, 1.0D, 1.5D, 0.625D);
*/
    public BlockTable(String name) {
        super(Material.WOOD, name);
        setSoundType(SoundType.WOOD);
    }
/*
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean bool)
    {
        state = state.getActualState(worldIn, pos);
        addCollisionBoxToList(pos, entityBox, collidingBoxes, TABLETOP_AABB);

        if (state.getValue(NORTHWEST).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTHWEST_AABB);
        }
        if (((Boolean)state.getValue(NORTHEAST)).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, NORTHEAST_AABB);
        }
        if (((Boolean)state.getValue(SOUTHEAST)).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTHEAST_AABB);
        }
        if (((Boolean)state.getValue(SOUTHWEST)).booleanValue())
        {
            addCollisionBoxToList(pos, entityBox, collidingBoxes, SOUTHWEST_AABB);
        }
    }
*/
    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }

    /** If no other block of type table present in relevant 2 cardinal directions, add a leg in that corner */

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {

        boolean northTable = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockTable;
        boolean southTable = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockTable;
        boolean eastTable = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockTable;
        boolean westTable = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockTable;

        return state.withProperty(NORTHWEST, !northTable && !westTable)
                .withProperty(NORTHEAST,  !northTable && !eastTable)
                .withProperty(SOUTHEAST, !southTable && !eastTable)
                .withProperty(SOUTHWEST,  !southTable && !westTable);
    }



    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {NORTHWEST, NORTHEAST, SOUTHEAST, SOUTHWEST});
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos){return true;}

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
}
