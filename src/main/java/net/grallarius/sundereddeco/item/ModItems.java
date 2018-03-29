package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.tool.ItemModSword;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    public static ItemOre ingotCopper = new ItemOre("ingot_copper", "ingotCopper");
    public static ItemCornSeed cornSeed = new ItemCornSeed();
    public static ItemCorn corn = new ItemCorn();
    public static ItemModSword copperSword = new ItemModSword(SunderedDeco.copperToolMaterial, "copper_sword");

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                ingotCopper,
                cornSeed,
                corn,
                copperSword
        );
    }

    public static void registerModels() {
        ingotCopper.registerItemModel();
        cornSeed.registerItemModel(cornSeed);
        corn.registerItemModel(corn);
        copperSword.registerItemModel(copperSword);
    }
}
