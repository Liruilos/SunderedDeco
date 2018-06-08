package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFountain extends BlockBase {

    /** Working out which type of model to place so all are connected correctly, open means the fountain connects in
     * that/those direction(s), side means it connects to that entire side */

    public static final PropertyBool OPENW = PropertyBool.create("openwest");
    public static final PropertyBool OPENN = PropertyBool.create("opennorth");
    public static final PropertyBool OPENE = PropertyBool.create("openeast");
    public static final PropertyBool OPENS = PropertyBool.create("opensouth");
    public static final PropertyBool OPENEW = PropertyBool.create("openeastwest");
    public static final PropertyBool OPENNS = PropertyBool.create("opennorthsouth");
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
        super(Material.ROCK, "fountain"); }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        boolean northFountain = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockFountain;
        boolean southFountain = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockFountain;
        boolean eastFountain = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockFountain;
        boolean westFountain = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockFountain;

        return state.withProperty(OPENW, !northFountain && westFountain && !southFountain && !eastFountain)
                .withProperty(OPENN, northFountain && !westFountain && !southFountain && !eastFountain)
                .withProperty(OPENE, !northFountain && !westFountain && !southFountain && eastFountain)
                .withProperty(OPENS, !northFountain && !westFountain && southFountain && !eastFountain)
                .withProperty(OPENEW, !northFountain && westFountain && !southFountain && eastFountain)
                .withProperty(OPENNS, northFountain && !westFountain && southFountain && !eastFountain)
                .withProperty(CORNERNW, northFountain && westFountain && !southFountain && !eastFountain)
                .withProperty(CORNERNE, northFountain && eastFountain && !southFountain && !westFountain)
                .withProperty(CORNERSE, southFountain && eastFountain && !northFountain && !westFountain)
                .withProperty(CORNERSW, southFountain && westFountain && !northFountain && !eastFountain)
                .withProperty(SIDEW, westFountain && northFountain && southFountain && !eastFountain)
                .withProperty(SIDEN, northFountain && westFountain && eastFountain && !southFountain)
                .withProperty(SIDEE, eastFountain && northFountain && southFountain && !westFountain)
                .withProperty(SIDES, southFountain && westFountain && eastFountain && !northFountain)
                .withProperty(CENTRE, southFountain && westFountain && eastFountain && northFountain);
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {OPENW, OPENN, OPENE, OPENS, OPENEW, OPENNS, CORNERNW, CORNERNE, CORNERSE, CORNERSW, SIDEW, SIDEN, SIDEE, SIDES, CENTRE});
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

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (this == ModBlocks.fountain)
        {
            if (blockState != iblockstate)
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }

        return (block != this) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }
}
