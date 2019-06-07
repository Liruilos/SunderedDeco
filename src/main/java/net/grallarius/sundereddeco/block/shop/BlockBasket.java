package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockBasket extends BlockDirectional {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.065D, 0.0D,0.065D,0.935D,0.4D,0.935D);
    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.WOOD);

    public BlockBasket(String name){
        super(props, name);
    }

/*    //@Override
    @Deprecated
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockReader source, BlockPos pos) {
        return BOUNDBOX;
    }*/

}
