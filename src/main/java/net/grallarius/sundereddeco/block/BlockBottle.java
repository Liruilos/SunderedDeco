package net.grallarius.sundereddeco.block;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockBottle extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.2D, 0.0D,0.2D,0.75D,0.9D,0.75D);

    private static final Properties props = Properties.create(Material.GLASS)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.GLASS);

    public BlockBottle(String name){
        super(props, name);
    }

    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }

/*    @Override
    @Deprecated
    public VoxelShape func_196244_b(IBlockState p_196244_1_, IBlockReader p_196244_2_, BlockPos p_196244_3_) {
        return BOUNDING_BOX;
    }*/
}
