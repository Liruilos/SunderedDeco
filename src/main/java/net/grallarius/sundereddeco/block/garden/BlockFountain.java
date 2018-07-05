package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFountain extends BlockBase {

    public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);

    public BlockFountain(String name) {
        super(Material.ROCK, name); }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        EnumShape shape = getShape(state, worldIn, pos);
        return state.withProperty(SHAPE, shape);
    }

    public static EnumShape getShape(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        /** Working out which type of model to place so all are connected correctly, end = |_|    straight = | |
         * corner = |_     side = _     centre =     */

        boolean northFountain = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockFountain;
        boolean southFountain = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockFountain;
        boolean eastFountain = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockFountain;
        boolean westFountain = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockFountain;

        if (!northFountain && !westFountain && !southFountain && !eastFountain) {
            return EnumShape.SINGLE;
        } else if (!northFountain && westFountain && !southFountain && !eastFountain) {
            return EnumShape.ENDE;
        } else if (northFountain && !westFountain && !southFountain && !eastFountain) {
            return EnumShape.ENDS;
        } else if (!northFountain && !westFountain && !southFountain && eastFountain) {
            return EnumShape.ENDW;
        } else if (!northFountain && !westFountain && southFountain && !eastFountain) {
            return EnumShape.ENDN;
        } else if (!northFountain && westFountain && !southFountain && eastFountain) {
            return EnumShape.STRAIGHTEW;
        } else if (northFountain && !westFountain && southFountain && !eastFountain) {
            return EnumShape.STRAIGHTNS;
        } else if (northFountain && westFountain && !southFountain && !eastFountain) {
            return EnumShape.CORNERNW;
        } else if (northFountain && eastFountain && !southFountain && !westFountain) {
            return EnumShape.CORNERNE;
        } else if (southFountain && eastFountain && !northFountain && !westFountain) {
            return EnumShape.CORNERSE;
        } else if (southFountain && westFountain && !northFountain && !eastFountain) {
            return EnumShape.CORNERSW;
        } else if (westFountain && northFountain && southFountain && !eastFountain) {
            return EnumShape.SIDEE;
        } else if (northFountain && westFountain && eastFountain && !southFountain) {
            return EnumShape.SIDES;
        } else if (eastFountain && northFountain && southFountain && !westFountain) {
            return EnumShape.SIDEW;
        } else if (southFountain && westFountain && eastFountain && !northFountain) {
            return EnumShape.SIDEN;
        } else if (southFountain && westFountain && eastFountain && northFountain) {
            return EnumShape.CENTRE;
        }
        return EnumShape.SINGLE;
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {SHAPE});
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
    @Deprecated
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        if (this == ModBlocks.fountain)
        {
                return false;
        }

        return (block != this) && super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }

    public int getMetaFromState(IBlockState state)
    {
        return 0;
    }

    public enum EnumShape implements IStringSerializable {

        ENDE( 0, "endeast"),
        ENDS( 1, "endsouth"),
        ENDW(2, "endwest"),
        ENDN(3, "endnorth"),
        STRAIGHTEW(  4, "straighteastwest"),
        STRAIGHTNS( 5, "straightnorthsouth"),
        CORNERNW( 6, "northwest"),
        CORNERNE(7, "northeast"),
        CORNERSE( 7, "southeast"),
        CORNERSW( 8, "southwest"),
        SIDEE( 9, "sideeast"),
        SIDES( 10, "sidesouth"),
        SIDEW( 11, "sidewest"),
        SIDEN( 12, "sidenorth"),
        CENTRE( 13, "centre"),
        SINGLE(14, "single");

        private final int meta;
        private final String name;
        private static final EnumShape[] LOOKUP = new EnumShape[values().length];

        EnumShape(int meta, String name) {
            this.meta = meta;
            this.name = name;
        }

        static {
            for(EnumShape shape : values()) {
                LOOKUP[shape.getMetadata()] = shape;
            }
        }

        public static EnumShape byMetadata(int meta) {
            if(meta < 0 || meta >= LOOKUP.length) {
                meta = 0;
            }
            return LOOKUP[meta];
        }

        public int getMetadata() {
            return this.meta;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }

    }
}
