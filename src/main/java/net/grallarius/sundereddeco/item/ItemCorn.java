package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraftforge.oredict.OreDictionary;

public class ItemCorn extends ItemFood {

    public  ItemCorn() {
        super(3, 0.6f, false);
        setUnlocalizedName("corn");
        setRegistryName("corn");
        setCreativeTab(SunderedDeco.creativeTab);
    }

    public void registerItemModel(Item item) {
        SunderedDeco.proxy.registerItemRenderer(this, 0, "corn");
    }

    public void initOreDict() {
        OreDictionary.registerOre("cropCorn", this);
    }
}
