package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockShopSign extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX_NS = new AxisAlignedBB(0.4D, 0.125D,0.065D,0.6D,1.0D,0.935D);
    protected static final AxisAlignedBB BOUNDBOX_EW = new AxisAlignedBB(0.065D, 0.125D,0.4D,0.935D,1.0D,0.6D);

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockShopSign(String name){
        super(props, name);
    }

/*    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos)
    {
        switch (state.getValue(FACING))
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
    }*/
}
