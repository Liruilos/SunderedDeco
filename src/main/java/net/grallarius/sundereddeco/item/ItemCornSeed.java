package net.grallarius.sundereddeco.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;

public class ItemCornSeed extends ItemSeeds {

    public ItemCornSeed() {
        super(ModBlocks.cropCorn, Blocks.FARMLAND);
        setUnlocalizedName("corn_seed");
        setRegistryName("corn_seed");
        setCreativeTab(SunderedDeco.creativeTab);
    }

    public void registerItemModel(Item item) {
        SunderedDeco.proxy.registerItemRenderer(item, 0, "corn_seed");
    }

}
