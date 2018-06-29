package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPlanterbox extends BlockBase {



    public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);

    public BlockPlanterbox(String name){
        super(Material.WOOD, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, EnumShape.SINGLE));
    }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        EnumShape shape = getShape(state, worldIn, pos);
        return state.withProperty(SHAPE, shape);
    }

    public static EnumShape getShape(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        /** Working out which type of model to place so all are connected correctly, end = |_|    straight = | |
         * corner = |_     side = _     centre =     */

        boolean northPlanter = worldIn.getBlockState(pos.north()).getBlock() instanceof BlockPlanterbox;
        boolean southPlanter = worldIn.getBlockState(pos.south()).getBlock() instanceof BlockPlanterbox;
        boolean eastPlanter = worldIn.getBlockState(pos.east()).getBlock() instanceof BlockPlanterbox;
        boolean westPlanter = worldIn.getBlockState(pos.west()).getBlock() instanceof BlockPlanterbox;

        if (!northPlanter && !westPlanter && !southPlanter && !eastPlanter) {
            return EnumShape.SINGLE;
        } else if (!northPlanter && westPlanter && !southPlanter && !eastPlanter) {
            return EnumShape.ENDE;
        } else if (northPlanter && !westPlanter && !southPlanter && !eastPlanter) {
            return EnumShape.ENDS;
        } else if (!northPlanter && !westPlanter && !southPlanter && eastPlanter) {
            return EnumShape.ENDW;
        } else if (!northPlanter && !westPlanter && southPlanter && !eastPlanter) {
            return EnumShape.ENDN;
        } else if (!northPlanter && westPlanter && !southPlanter && eastPlanter) {
            return EnumShape.STRAIGHTEW;
        } else if (northPlanter && !westPlanter && southPlanter && !eastPlanter) {
            return EnumShape.STRAIGHTNS;
        } else if (northPlanter && westPlanter && !southPlanter && !eastPlanter) {
            return EnumShape.CORNERNW;
        } else if (northPlanter && eastPlanter && !southPlanter && !westPlanter) {
            return EnumShape.CORNERNE;
        } else if (southPlanter && eastPlanter && !northPlanter && !westPlanter) {
            return EnumShape.CORNERSE;
        } else if (southPlanter && westPlanter && !northPlanter && !eastPlanter) {
            return EnumShape.CORNERSW;
        } else if (westPlanter && northPlanter && southPlanter && !eastPlanter) {
            return EnumShape.SIDEE;
        } else if (northPlanter && westPlanter && eastPlanter && !southPlanter) {
            return EnumShape.SIDES;
        } else if (eastPlanter && northPlanter && southPlanter && !westPlanter) {
            return EnumShape.SIDEW;
        } else if (southPlanter && westPlanter && eastPlanter && !northPlanter) {
            return EnumShape.SIDEN;
        } else if (southPlanter && westPlanter && eastPlanter && northPlanter) {
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

    @Override
    public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable){ return true;}

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
