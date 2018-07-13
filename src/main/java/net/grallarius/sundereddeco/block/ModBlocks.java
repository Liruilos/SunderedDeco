package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.furniture.*;
import net.grallarius.sundereddeco.block.garden.flowerbeds.BlockDenseFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.BlockFlowerbed;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox;
import net.grallarius.sundereddeco.block.shop.BlockBasket;
import net.grallarius.sundereddeco.block.shop.BlockCrate;

public class ModBlocks {

    public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");

    public static BlockTable table = new BlockTable();
    public static BlockSittable stool = new BlockSittable("stool");
    public static BlockChair chair = new BlockChair("chair");
    public static BlockConnectedChair parkbench = new BlockConnectedChair();


    /** garden blocks */
    public static BlockFountain fountain = new BlockFountain("fountain");
    public static BlockPlanterbox largeplanterbox = new BlockPlanterbox("largeplanterbox");
    public static BlockWindowbox windowbox = new BlockWindowbox("windowbox");
    public static BlockFlowerbed flowerbed = new BlockFlowerbed("flowerbed");
    public static BlockDenseFlowerbed denseFlowerbed = new BlockDenseFlowerbed("denseflowerbed");

    /** shop blocks */
    public static BlockCrate crateClosed = new BlockCrate("crate_closed");
    public static BlockCrate crateApple = new BlockCrate("crate_apple");
    public static BlockCrate crateBerry = new BlockCrate("crate_berry");
    public static BlockCrate crateCarrot = new BlockCrate("crate_carrot");
    public static BlockCrate crateFish = new BlockCrate("crate_fish");
    public static BlockCrate crateGrain = new BlockCrate("crate_grain");
    public static BlockCrate crateIngot = new BlockCrate("crate_ingot");
    public static BlockCrate cratePotato = new BlockCrate("crate_potato");
    public static BlockCrate crateSugar = new BlockCrate("crate_sugar");

    public static BlockBasket basketApple = new BlockBasket("basket_apple");
    public static BlockBasket basketBerry = new BlockBasket("basket_berry");
    public static BlockBasket basketCarrot = new BlockBasket("basket_carrot");
    public static BlockBasket basketFish = new BlockBasket("basket_fish");
    public static BlockBasket basketGrain = new BlockBasket("basket_grain");
    public static BlockBasket basketIngot = new BlockBasket("basket_ingot");
    public static BlockBasket basketPotato = new BlockBasket("basket_potato");
    public static BlockBasket basketSugar = new BlockBasket("basket_sugar");


    /*    public static BlockPedestal pedestal = new BlockPedestal();*/

    public static void preInit() {
                oreCopper.register();

                table.register();
                stool.register();
                chair.register();
                parkbench.register();

        /** garden blocks */
        fountain.register();
        largeplanterbox.register();
        windowbox.register();
        flowerbed.register();
        denseFlowerbed.register();

/*                pedestal.register();*/

        /** shop blocks */
        crateClosed.register();
        crateApple.register();
        crateBerry.register();
        crateCarrot.register();
        crateFish.register();
        crateGrain.register();
        crateIngot.register();
        cratePotato.register();
        crateSugar.register();

        basketApple.register();
        basketBerry.register();
        basketCarrot.register();
        basketFish.register();
        basketGrain.register();
        basketIngot.register();
        basketPotato.register();
        basketSugar.register();

    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
