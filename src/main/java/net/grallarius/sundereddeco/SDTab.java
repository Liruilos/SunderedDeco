package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class SDTab {

    public ItemGroup itemGroup = new ItemGroup("sundereddeco") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.chair);
        }
    };

    public void init() {

    }
}
