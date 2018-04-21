package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.furniture.*;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
    public static BlockPedestal pedestal = new BlockPedestal();
    public static BlockTable table = new BlockTable();
    public static BlockSittable stool = new BlockSittable("stool");
    public static BlockChair chair = new BlockChair("chair");
    public static BlockConnectedChair parkbench = new BlockConnectedChair();

    public static void preInit() {
                oreCopper.register();
                pedestal.register();
                table.register();
                stool.register();
                chair.register();
                parkbench.register();
    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
