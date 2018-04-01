package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.furniture.BlockPedestal;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
    public static BlockPedestal pedestal = new BlockPedestal();

    public static void preInit() {
                oreCopper.register();
                pedestal.register();
    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
