package net.grallarius.sundereddeco.block.furniture;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockFountain extends BlockBase {

    /** Whether there should be a leg in the NW position */
    public static final PropertyBool CORNERNW = PropertyBool.create("northwest");
    /** Whether there should be a leg in the NE position */
    public static final PropertyBool CORNERNE = PropertyBool.create("northeast");
    /** Whether there should be a leg in the SE position */
    public static final PropertyBool CORNERSE = PropertyBool.create("southeast");
    /** Whether there should be a leg in the SW position */
    public static final PropertyBool CORNERSW = PropertyBool.create("southwest");

    public BlockFountain() {
        super(Material.ROCK, "fountain");
    }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        boolean northFountain = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockFountain;
        boolean southFountain = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockFountain;
        boolean eastFountain = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockFountain;
        boolean westFountain = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockFountain;

        return state.withProperty(CORNERNW, northFountain && westFountain && !eastFountain && !southFountain)
                .withProperty(CORNERNE, northFountain && eastFountain && !westFountain && !southFountain)
                .withProperty(CORNERSE, southFountain && eastFountain && !westFountain && !northFountain)
                .withProperty(CORNERSW, southFountain && westFountain && !eastFountain && !northFountain);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CORNERNW, CORNERNE, CORNERSE, CORNERSW});
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

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
}
