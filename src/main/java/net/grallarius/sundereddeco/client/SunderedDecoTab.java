package net.grallarius.sundereddeco.client;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SunderedDecoTab extends ItemGroup {

    public SunderedDecoTab() {
        super(SunderedDeco.MODID);
        //setBackgroundImageName("item_search.png");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.itemBlocks.get(0));
    }
}
