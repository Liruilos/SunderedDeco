package net.grallarius.sundereddeco.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

//TODO possibly remove this class since we can just retexture vanilla lamps now
public class BlockLamp extends BlockLantern {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.25D, 0.2D,0.25D,0.75D,0.8D,0.75D);

    public BlockLamp(String name){
        super(name);
    }

    //@Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }

}
