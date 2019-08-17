package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.item.Item;

public class FirstItem extends Item {

    public FirstItem() {
        super(new Item.Properties()
                .maxStackSize(1)
                .group(ModBlocks.sdTab.itemGroup));
        setRegistryName("firstitem");
    }
}
