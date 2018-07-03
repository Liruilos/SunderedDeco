package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWindowbox extends BlockBase {

    public static final PropertyEnum<EnumShape> SHAPE = PropertyEnum.create("shape", EnumShape.class);
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    
    public BlockWindowbox(String name){
        super(Material.ROCK, name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(SHAPE, EnumShape.SINGLE));

       /** still need to fix boundbox, place on walls only, and tile entity to take 2 flowers */
    }

    @Override
    @Deprecated
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    @Deprecated
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {

        /** Working out which type of model to place so all are connected correctly, end (openleft and openright) = |_|
         *    straight = | |   and single  */

        IBlockState blockleft = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateYCCW()));
        IBlockState blockright = worldIn.getBlockState(pos.offset(state.getValue(FACING).rotateY()));

        boolean leftMatch = blockleft.getBlock() instanceof BlockWindowbox && (state.getValue(FACING) == blockleft.getValue(FACING));
        boolean rightMatch = blockright.getBlock() instanceof BlockWindowbox && (state.getValue(FACING) == blockright.getValue(FACING));


        /** Check if no other windowboxes to the left and right in same facing, return single blockstates */
        if(!leftMatch && !rightMatch){ return state.withProperty(SHAPE, EnumShape.SINGLE); }

        /** Check if a windowboxe to the left in same facing but not the right, return endleft blockstates */
        else if(leftMatch && !rightMatch){ return state.withProperty(SHAPE, EnumShape.ENDLEFT); }

        /** Check if a windowboxe to the right in same facing but not the left, return endright blockstates */
        else if(!leftMatch && rightMatch){ return state.withProperty(SHAPE, EnumShape.ENDRIGHT); }

        /** Check if windowboxes exist to the left AND right in same facing, return straight blockstates */
        else{ return state.withProperty(SHAPE, EnumShape.STRAIGHT); }

    }


    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING, SHAPE});
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
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getFront(meta));
    }

    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    public enum EnumShape implements IStringSerializable {

        ENDLEFT( 0, "endleft"),
        STRAIGHT( 1, "straight"),
        ENDRIGHT( 2, "endright"),
        SINGLE( 3, "single");

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
