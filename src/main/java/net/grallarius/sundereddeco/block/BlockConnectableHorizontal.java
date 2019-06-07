package net.grallarius.sundereddeco.block;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;

import javax.annotation.Nullable;

public class BlockConnectableHorizontal extends BlockBase {

    public static final EnumProperty<EnumShape> SHAPE = EnumProperty.create("shape", EnumShape.class);

    public BlockConnectableHorizontal(Properties properties, String name){
        super(properties, name);
        this.setDefaultState(this.stateContainer.getBaseState().with(SHAPE, EnumShape.SINGLE));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
        builder.add(SHAPE);
    }

    /** Working out which type of model to place so all are connected correctly, end = |_|    straight = | |
     * corner = |_     side = _     centre =     */
    private IBlockState connectedState(IWorld world, BlockPos pos){
        boolean northConnectable = world.getBlockState(pos.north()).getBlock() == this;
        boolean southConnectable = world.getBlockState(pos.south()).getBlock() == this;
        boolean eastConnectable = world.getBlockState(pos.east()).getBlock() == this;
        boolean westConnectable = world.getBlockState(pos.west()).getBlock() == this;

        if (!northConnectable && !westConnectable && !southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.SINGLE);
        } else if (!northConnectable && westConnectable && !southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.ENDE);
        } else if (northConnectable && !westConnectable && !southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.ENDS);
        } else if (!northConnectable && !westConnectable && !southConnectable && eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.ENDW);
        } else if (!northConnectable && !westConnectable && southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.ENDN);
        } else if (!northConnectable && westConnectable && !southConnectable && eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.STRAIGHTEW);
        } else if (northConnectable && !westConnectable && southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.STRAIGHTNS);
        } else if (northConnectable && westConnectable && !southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.CORNERNW);
        } else if (northConnectable && eastConnectable && !southConnectable && !westConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.CORNERNE);
        } else if (southConnectable && eastConnectable && !northConnectable && !westConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.CORNERSE);
        } else if (southConnectable && westConnectable && !northConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.CORNERSW);
        } else if (westConnectable && northConnectable && southConnectable && !eastConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.SIDEE);
        } else if (northConnectable && westConnectable && eastConnectable && !southConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.SIDES);
        } else if (eastConnectable && northConnectable && southConnectable && !westConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.SIDEW);
        } else if (southConnectable && westConnectable && eastConnectable && !northConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.SIDEN);
        } else if (southConnectable && westConnectable && eastConnectable && northConnectable) {
            return this.getDefaultState().with(SHAPE, EnumShape.CENTRE);
        }
        return this.getDefaultState().with(SHAPE, EnumShape.SINGLE);
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

    //@Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
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
