package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.InvModel;
import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.item.Item;

import static net.grallarius.sundereddeco.SunderedDeco.ITEM_REGISTRY;

public class ItemBase extends Item {

    protected String name;

    public ItemBase(String name, Item.Properties properties) {
        super(properties);
        this.name = name;
        setRegistryName(SunderedDeco.MODID, name);
        //setCreativeTab(SunderedDeco.creativeTab);

        //register();
    }

    public void register() {
        //ITEM_REGISTRY.register(this);
        //InvModel.add(this, 0, name);
    }

}
