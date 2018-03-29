package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.grallarius.sundereddeco.item.ModItems;

public class BlockCropCorn extends BlockCrops {

    public BlockCropCorn() {
        setUnlocalizedName("crop_corn");
        setRegistryName("crop_corn");
        setCreativeTab(SunderedDeco.creativeTab);
    }

    @Override
    protected Item getSeed() {
        return ModItems.cornSeed;
    }

    @Override
    protected Item getCrop() {
        return ModItems.corn;
    }
}
