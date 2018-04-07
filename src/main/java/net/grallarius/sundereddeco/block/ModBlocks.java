package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.furniture.BlockChair;
import net.grallarius.sundereddeco.block.furniture.BlockPedestal;
import net.grallarius.sundereddeco.block.furniture.BlockSittable;
import net.grallarius.sundereddeco.block.furniture.BlockTable;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
    public static BlockPedestal pedestal = new BlockPedestal();
    public static BlockTable table = new BlockTable();
    public static BlockSittable stool = new BlockSittable();
//    public static BlockChair chair = new BlockChair();

    public static void preInit() {
                oreCopper.register();
                pedestal.register();
                table.register();
                stool.register();
//                chair.register();
    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
