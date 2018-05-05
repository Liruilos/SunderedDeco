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
    public static final PropertyBool CORNERNE = PropertyBool.create("northeast");
    public static final PropertyBool CORNERSE = PropertyBool.create("southeast");
    public static final PropertyBool CORNERSW = PropertyBool.create("southwest");
    public static final PropertyBool SIDEW = PropertyBool.create("west");
    public static final PropertyBool SIDEN = PropertyBool.create("north");
    public static final PropertyBool SIDEE = PropertyBool.create("east");
    public static final PropertyBool SIDES = PropertyBool.create("south");
    public static final PropertyBool CENTRE = PropertyBool.create("centre");

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
        boolean northwestFountain = worldIn.getBlockState(pos.add(-1,0,-1)).getBlock() instanceof BlockFountain;
        boolean northeastFountain = worldIn.getBlockState(pos.add(1,0,-1)).getBlock() instanceof BlockFountain;
        boolean southeastFountain = worldIn.getBlockState(pos.add(1,0,1)).getBlock() instanceof BlockFountain;
        boolean southwestFountain = worldIn.getBlockState(pos.add(-1,0,1)).getBlock() instanceof BlockFountain;

        return state.withProperty(CORNERNW, northFountain && westFountain && northwestFountain && !southFountain && !eastFountain)
                .withProperty(CORNERNE, northFountain && eastFountain && northeastFountain && !southFountain && !westFountain)
                .withProperty(CORNERSE, southFountain && eastFountain && southeastFountain && !northFountain && ! westFountain)
                .withProperty(CORNERSW, southFountain && westFountain && southwestFountain && !northFountain && !eastFountain)
                .withProperty(SIDEW, westFountain && northFountain && southFountain && !eastFountain)
                .withProperty(SIDEN, northFountain && westFountain && eastFountain && !southFountain)
                .withProperty(SIDEE, eastFountain && northFountain && southFountain && !westFountain)
                .withProperty(SIDES, southFountain && westFountain && eastFountain && !northFountain)
                .withProperty(CENTRE, southFountain && westFountain && eastFountain && northFountain && southwestFountain && southeastFountain && northeastFountain && northwestFountain);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CORNERNW, CORNERNE, CORNERSE, CORNERSW, SIDEW, SIDEN, SIDEE, SIDES, CENTRE});
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
