package net.grallarius.sundereddeco.block;


import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockConnectableHorizontal extends BlockBase {

    public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);

    public BlockConnectableHorizontal(String name){
        super(Material.ROCK, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.SINGLE));
    }


    public EnumShape getShape(IBlockState state, IBlockAccess worldIn, BlockPos pos, Class cls) {

        /** Working out which type of model to place so all are connected correctly, end = |_|    straight = | |
         * corner = |_     side = _     centre =     */

        boolean northConnectable = worldIn.getBlockState(pos.north()).getBlock() == this;
        boolean southConnectable = worldIn.getBlockState(pos.south()).getBlock() == this;
        boolean eastConnectable = worldIn.getBlockState(pos.east()).getBlock() == this;
        boolean westConnectable = worldIn.getBlockState(pos.west()).getBlock() == this;

        if (!northConnectable && !westConnectable && !southConnectable && !eastConnectable) {
            return EnumShape.SINGLE;
        } else if (!northConnectable && westConnectable && !southConnectable && !eastConnectable) {
            return EnumShape.ENDE;
        } else if (northConnectable && !westConnectable && !southConnectable && !eastConnectable) {
            return EnumShape.ENDS;
        } else if (!northConnectable && !westConnectable && !southConnectable && eastConnectable) {
            return EnumShape.ENDW;
        } else if (!northConnectable && !westConnectable && southConnectable && !eastConnectable) {
            return EnumShape.ENDN;
        } else if (!northConnectable && westConnectable && !southConnectable && eastConnectable) {
            return EnumShape.STRAIGHTEW;
        } else if (northConnectable && !westConnectable && southConnectable && !eastConnectable) {
            return EnumShape.STRAIGHTNS;
        } else if (northConnectable && westConnectable && !southConnectable && !eastConnectable) {
            return EnumShape.CORNERNW;
        } else if (northConnectable && eastConnectable && !southConnectable && !westConnectable) {
            return EnumShape.CORNERNE;
        } else if (southConnectable && eastConnectable && !northConnectable && !westConnectable) {
            return EnumShape.CORNERSE;
        } else if (southConnectable && westConnectable && !northConnectable && !eastConnectable) {
            return EnumShape.CORNERSW;
        } else if (westConnectable && northConnectable && southConnectable && !eastConnectable) {
            return EnumShape.SIDEE;
        } else if (northConnectable && westConnectable && eastConnectable && !southConnectable) {
            return EnumShape.SIDES;
        } else if (eastConnectable && northConnectable && southConnectable && !westConnectable) {
            return EnumShape.SIDEW;
        } else if (southConnectable && westConnectable && eastConnectable && !northConnectable) {
            return EnumShape.SIDEN;
        } else if (southConnectable && westConnectable && eastConnectable && northConnectable) {
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
