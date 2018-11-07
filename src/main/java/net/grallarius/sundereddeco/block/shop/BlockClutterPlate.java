package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockClutterPlate extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.1D, 0.0D,0.1D,0.75D,0.2D,0.9D);

    public BlockClutterPlate(String name){
        super(Material.WOOD, name);
    }

    @Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }
}
