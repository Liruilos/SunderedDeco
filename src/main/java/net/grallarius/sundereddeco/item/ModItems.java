package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.tool.ItemModSword;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemOre ingotCopper = new ItemOre("ingot_copper", "ingotCopper");
    public static ItemModSword copperSword = new ItemModSword(SunderedDeco.copperToolMaterial, "copper_sword");

    public static void preInit() {
                ingotCopper.register();
                copperSword.register();
    }

    public static void registerModels() {
        ingotCopper.register();
        copperSword.register();
    }
}
