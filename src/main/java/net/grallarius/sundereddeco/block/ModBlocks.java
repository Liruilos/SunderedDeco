package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.block.furniture.*;
import net.grallarius.sundereddeco.block.garden.BlockHedge;
import net.grallarius.sundereddeco.block.garden.flowerbeds.BlockDenseFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.BlockFlowerbed;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox;
import net.grallarius.sundereddeco.block.pedestal.BlockPedestal;
import net.grallarius.sundereddeco.block.shop.*;
import net.minecraft.block.material.Material;

public class ModBlocks {

    /*public static BlockOre oreCopper = new BlockOre("ore_copper", "oreCopper");*/

    public static BlockTable table = new BlockTable("table");
    public static BlockSittable stool = new BlockSittable("stool");
    public static BlockChair chair = new BlockChair("chair");
    public static BlockConnectedChair parkbench = new BlockConnectedChair();

    public static BlockDirectional sidetable = new BlockDirectional(Material.WOOD, "sidetable");
    public static BlockDirectional scales = new BlockDirectional(Material.IRON, "scales");
    public static BlockBottle bottlePlaced = new BlockBottle("bottle_placed");
    public static BlockDirectional plateMuffins = new BlockDirectional(Material.WOOD, "plate_muffins");
    public static BlockDirectional plateCroissants = new BlockDirectional(Material.WOOD, "plate_croissants");
    public static BlockDirectional coinpurse = new BlockDirectional(Material.CARPET, "coinpurse");
    public static BlockPedestal bookPedestal = new BlockPedestal("book_pedestal");
    public static BlockDirectional shrine = new BlockDirectional(Material.ROCK, "shrine");

    public static BlockDirectional roofShinglesRed = new BlockDirectional(Material.WOOD, "roof_shingles_red");
    public static BlockDirectional roofShinglesRedConcave = new BlockDirectional(Material.WOOD,"roof_shingles_red_concave");
    public static BlockDirectional roofShinglesRedConvex = new BlockDirectional(Material.WOOD, "roof_shingles_red_convex");

    //TODO for now is registering itself and model registry happening in InvModel
    public static BlockWindow window = new BlockWindow(Material.WOOD,"window");




    /** garden blocks */
    public static BlockFountain fountain = new BlockFountain("fountain");
    public static BlockHedge hedge = new BlockHedge("hedge");
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

    public static BlockDisplayCrate displayCrateApple = new BlockDisplayCrate("display_crate_apple");
    public static BlockDisplayCrate displayCrateBerry = new BlockDisplayCrate("display_crate_berry");
    public static BlockDisplayCrate displayCrateCarrot = new BlockDisplayCrate("display_crate_carrot");
    public static BlockDisplayCrate displayCrateFish = new BlockDisplayCrate("display_crate_fish");
    public static BlockDisplayCrate displayCrateGrain = new BlockDisplayCrate("display_crate_grain");
    public static BlockDisplayCrate displayCrateIngot = new BlockDisplayCrate("display_crate_ingot");
    public static BlockDisplayCrate displayCratePotato = new BlockDisplayCrate("display_crate_potato");
    public static BlockDisplayCrate displayCrateSugar = new BlockDisplayCrate("display_crate_sugar");

    public static BlockBasket basketApple = new BlockBasket("basket_apple");
    public static BlockBasket basketBerry = new BlockBasket("basket_berry");
    public static BlockBasket basketCarrot = new BlockBasket("basket_carrot");
    public static BlockBasket basketFish = new BlockBasket("basket_fish");
    public static BlockBasket basketGrain = new BlockBasket("basket_grain");
    public static BlockBasket basketIngot = new BlockBasket("basket_ingot");
    public static BlockBasket basketPotato = new BlockBasket("basket_potato");
    public static BlockBasket basketSugar = new BlockBasket("basket_sugar");

    public static BlockLargeBasket basketLargeApple = new BlockLargeBasket("basket_large_apple");
    public static BlockLargeBasket basketLargeBerry = new BlockLargeBasket("basket_large_berry");
    public static BlockLargeBasket basketLargeCarrot = new BlockLargeBasket("basket_large_carrot");
    public static BlockLargeBasket basketLargeFish = new BlockLargeBasket("basket_large_fish");
    public static BlockLargeBasket basketLargeGrain = new BlockLargeBasket("basket_large_grain");
    public static BlockLargeBasket basketLargeIngot = new BlockLargeBasket("basket_large_ingot");
    public static BlockLargeBasket basketLargePotato = new BlockLargeBasket("basket_large_potato");
    public static BlockLargeBasket basketLargeSugar = new BlockLargeBasket("basket_large_sugar");

    public static BlockShopSign signApothecary = new BlockShopSign("sign_apothecary");
    public static BlockShopSign signArmoury = new BlockShopSign("sign_armoury");
    public static BlockShopSign signBakery = new BlockShopSign("sign_bakery");
    public static BlockShopSign signBlacksmith = new BlockShopSign("sign_blacksmith");
    public static BlockShopSign signBrewery = new BlockShopSign("sign_brewery");
    public static BlockShopSign signClinic = new BlockShopSign("sign_clinic");
    public static BlockShopSign signClothing = new BlockShopSign("sign_clothing");
    public static BlockShopSign signDiner = new BlockShopSign("sign_diner");
    public static BlockShopSign signExotics = new BlockShopSign("sign_exotics");
    public static BlockShopSign signFishery = new BlockShopSign("sign_fishery");
    public static BlockShopSign signFlorist = new BlockShopSign("sign_florist");
    public static BlockShopSign signFurniture = new BlockShopSign("sign_furniture");
    public static BlockShopSign signGeneral = new BlockShopSign("sign_general");
    public static BlockShopSign signInn = new BlockShopSign("sign_inn");
    public static BlockShopSign signJeweller = new BlockShopSign("sign_jeweller");
    public static BlockShopSign signMusic = new BlockShopSign("sign_music");
    public static BlockShopSign signPetshop = new BlockShopSign("sign_petshop");
    public static BlockShopSign signPostal = new BlockShopSign("sign_postal");
    public static BlockShopSign signPub = new BlockShopSign("sign_pub");
    public static BlockShopSign signWeapons = new BlockShopSign("sign_weapons");


    /*    public static BlockPedestal pedestal = new BlockPedestal();*/

    public static void preInit() {
                /*oreCopper.register();*/


                bottlePlaced.register();
                plateMuffins.register();
                plateCroissants.register();

                bookPedestal.register();

                roofShinglesRed.register();
                roofShinglesRedConcave.register();
                roofShinglesRedConvex.register();


        /** garden blocks */
        fountain.register();
        hedge.register();
        largeplanterbox.register();
        windowbox.register();
        flowerbed.register();
        denseFlowerbed.register();
        parkbench.register();
        shrine.register();

        /** home blocks */
        table.register();
        stool.register();
        chair.register();
        sidetable.register();

        /** shop blocks */
        coinpurse.register();
        scales.register();

        crateClosed.register();
        crateApple.register();
        crateBerry.register();
        crateCarrot.register();
        crateFish.register();
        crateGrain.register();
        crateIngot.register();
        cratePotato.register();
        crateSugar.register();

        displayCrateApple.register();
        displayCrateBerry.register();
        displayCrateCarrot.register();
        displayCrateFish.register();
        displayCrateGrain.register();
        displayCrateIngot.register();
        displayCratePotato.register();
        displayCrateSugar.register();

        basketApple.register();
        basketBerry.register();
        basketCarrot.register();
        basketFish.register();
        basketGrain.register();
        basketIngot.register();
        basketPotato.register();
        basketSugar.register();

        basketLargeApple.register();
        basketLargeBerry.register();
        basketLargeCarrot.register();
        basketLargeFish.register();
        basketLargeGrain.register();
        basketLargeIngot.register();
        basketLargePotato.register();
        basketLargeSugar.register();

        signApothecary.register();
        signArmoury.register();
        signBakery.register();
        signBlacksmith.register();
        signBrewery.register();
        signClinic.register();
        signClothing.register();
        signDiner.register();
        signExotics.register();
        signFishery.register();
        signFlorist.register();
        signFurniture.register();
        signGeneral.register();
        signInn.register();
        signJeweller.register();
        signMusic.register();
        signPetshop.register();
        signPostal.register();
        signPub.register();
        signWeapons.register();

    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
