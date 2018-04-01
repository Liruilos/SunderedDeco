package net.grallarius.sundereddeco.item.tool;

import net.grallarius.sundereddeco.InvModel;
import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.item.Item;

import static net.grallarius.sundereddeco.SunderedDeco.ITEM_REGISTRY;

public class ItemModSword extends net.minecraft.item.ItemSword {

    private String name;

    public ItemModSword(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name = name;

        register();
    }

    public void register() {
        ITEM_REGISTRY.register(this);
        InvModel.add(this, 0, name);
    }
}
