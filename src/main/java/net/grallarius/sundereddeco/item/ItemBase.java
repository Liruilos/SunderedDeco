package net.grallarius.sundereddeco.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.grallarius.sundereddeco.SunderedDeco;

public class ItemBase extends Item{

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SunderedDeco.creativeTab);
    }

    public void registerItemModel () {
        SunderedDeco.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
