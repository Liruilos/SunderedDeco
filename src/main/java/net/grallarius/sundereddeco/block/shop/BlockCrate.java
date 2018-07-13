package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockCrate extends BlockBase {

    public BlockCrate(String name){
        super(Material.WOOD, name);
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

}
