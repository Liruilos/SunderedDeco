package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCrate extends BlockBase {

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockCrate(String name){
        super(props, name);
    }

    public BlockCrate(Properties properties, String name){
        super(properties, name);
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


}
