package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockShopSign extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX_NS = new AxisAlignedBB(0.4D, 0.125D,0.065D,0.6D,1.0D,0.935D);
    protected static final AxisAlignedBB BOUNDBOX_EW = new AxisAlignedBB(0.065D, 0.125D,0.4D,0.935D,1.0D,0.6D);


    public BlockShopSign(String name){
        super(Material.WOOD, name);
    }

    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case NORTH:
                return BOUNDBOX_NS;
            case SOUTH:
                return BOUNDBOX_NS;
            case WEST:
                return BOUNDBOX_EW;
            case EAST:
            default:
                return BOUNDBOX_EW;
        }
    }
}
