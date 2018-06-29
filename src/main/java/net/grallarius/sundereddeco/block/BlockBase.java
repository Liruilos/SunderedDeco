package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.InvModel;
import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

import static net.grallarius.sundereddeco.SunderedDeco.BLOCK_REGISTRY;
import static net.grallarius.sundereddeco.SunderedDeco.ITEM_REGISTRY;


public class BlockBase extends Block {

    protected String name;

    public BlockBase(Material material, String name) {
        super(material);

        this.name = name;

        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(SunderedDeco.creativeTab);
    }

    public void register(Item item) {
        BLOCK_REGISTRY.register(this);
        ITEM_REGISTRY.register(item);
        InvModel.add(item,0, name);
    }

    public void register() {
        register(new ItemBlock(this).setRegistryName(getRegistryName()));
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
