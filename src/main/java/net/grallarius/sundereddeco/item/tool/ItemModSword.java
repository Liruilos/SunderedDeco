package net.grallarius.sundereddeco.item.tool;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.item.Item;

public class ItemModSword extends net.minecraft.item.ItemSword {

    private String name;

    public ItemModSword(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;
    }

    public void registerItemModel(Item item) {
        SunderedDeco.proxy.registerItemRenderer(this, 0, name);
    }
}
