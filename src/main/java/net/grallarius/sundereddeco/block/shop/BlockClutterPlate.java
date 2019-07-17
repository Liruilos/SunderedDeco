package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockClutterPlate extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.1D, 0.0D,0.1D,0.75D,0.2D,0.9D);

    private static final Properties props = Properties.create(Material.ROCK)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.STONE);

    public BlockClutterPlate(String name){
        super(props, name);
    }

    //@Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(BlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }
}
