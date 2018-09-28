package net.grallarius.sundereddeco.client;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SunderedDecoTab extends CreativeTabs {

    public SunderedDecoTab() {
        super(SunderedDeco.MODID);
        //setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack getTabIconItem() {
        return  new ItemStack(ModBlocks.fountain);
    }

}
