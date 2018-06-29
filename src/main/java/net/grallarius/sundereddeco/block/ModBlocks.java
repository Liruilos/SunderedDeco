package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.counter.BlockCounter;
import net.grallarius.sundereddeco.block.furniture.*;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.pedestal.BlockPedestal;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");
    public static BlockFountain fountain = new BlockFountain("fountain");
    public static BlockPlanterbox planterbox = new BlockPlanterbox("planterbox");
    public static BlockTable table = new BlockTable();
    public static BlockSittable stool = new BlockSittable("stool");
    public static BlockChair chair = new BlockChair("chair");
    public static BlockConnectedChair parkbench = new BlockConnectedChair();
    public static BlockCounter counter = new BlockCounter();
    public static BlockPedestal pedestal = new BlockPedestal();

    public static void preInit() {
                oreCopper.register();
                fountain.register();
                planterbox.register();
                table.register();
                stool.register();
                chair.register();
                parkbench.register();
                counter.register();
                pedestal.register();

    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
