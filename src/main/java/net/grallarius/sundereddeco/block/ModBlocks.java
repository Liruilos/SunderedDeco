package net.grallarius.sundereddeco.block;


import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking.BlockCounter;
import net.grallarius.sundereddeco.block.counterUseOnlyToGetTEsWorking.TileEntityCounter;
import net.grallarius.sundereddeco.block.furniture.*;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockHedge;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.shop.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SunderedDeco.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(SunderedDeco.MODID)
public class ModBlocks {


    //SHOP
    public static final BlockCrate crate_closed = new BlockCrate("crate_closed");
    public static final BlockCrate crate_apple = new BlockCrate("crate_apple");
    public static final BlockCrate crate_berry = new BlockCrate("crate_berry");
    public static final BlockCrate crate_carrot = new BlockCrate("crate_carrot");
    public static final BlockCrate crate_fish = new BlockCrate("crate_fish");
    public static final BlockCrate crate_grain = new BlockCrate("crate_grain");
    public static final BlockCrate crate_ingot = new BlockCrate("crate_ingot");
    public static final BlockCrate crate_potato = new BlockCrate("crate_potato");
    public static final BlockCrate crate_sugar = new BlockCrate("crate_sugar");

    public static final BlockBasket basket_berry = new BlockBasket("basket_berry");
    public static final BlockBasket basket_apple = new BlockBasket("basket_apple");
    public static final BlockBasket basket_carrot = new BlockBasket("basket_carrot");
    public static final BlockBasket basket_fish = new BlockBasket("basket_fish");
    public static final BlockBasket basket_grain = new BlockBasket("basket_grain");
    public static final BlockBasket basket_ingot = new BlockBasket("basket_ingot");
    public static final BlockBasket basket_potato = new BlockBasket("basket_potato");
    public static final BlockBasket basket_sugar = new BlockBasket("basket_sugar");

    public static final BlockLargeBasket basket_large_apple = new BlockLargeBasket("basket_large_apple");
    public static final BlockLargeBasket basket_large_berry = new BlockLargeBasket("basket_large_berry");
    public static final BlockLargeBasket basket_large_carrot = new BlockLargeBasket("basket_large_carrot");
    public static final BlockLargeBasket basket_large_fish = new BlockLargeBasket("basket_large_fish");
    public static final BlockLargeBasket basket_large_grain = new BlockLargeBasket("basket_large_grain");
    public static final BlockLargeBasket basket_large_ingot = new BlockLargeBasket("basket_large_ingot");
    public static final BlockLargeBasket basket_large_potato = new BlockLargeBasket("basket_large_potato");
    public static final BlockLargeBasket basket_large_sugar = new BlockLargeBasket("basket_large_sugar");


    //GARDEN
    public static final BlockLantern lantern_candle = new BlockLantern("lantern_candle");
    public static final BlockLantern lantern_blue = new BlockLantern("lantern_blue");
    public static final BlockLantern lantern_green = new BlockLantern("lantern_green");
    public static final BlockLantern lantern_red = new BlockLantern("lantern_red");
    public static final BlockLantern lantern_yellow = new BlockLantern("lantern_yellow");

    public static final BlockHedge hedge = new BlockHedge("hedge");
    public static final BlockFountain fountain = new BlockFountain("fountain");

    public static final BlockWindowbox windowbox = new BlockWindowbox("windowbox");

    //HOME
    public static final BlockDirectional sidetable = new BlockDirectional(Block.Properties.create(Material.WOOD), "sidetable");
    public static final BlockSittable stool = new BlockSittable(Block.Properties.create(Material.WOOD),"stool");


    //TODO TO BE REMOVED ONCE CODE EXAMPLES NO LONGER REQUIRED
    public static final BlockCounter counter = new BlockCounter();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(

                //SHOP
            crate_closed, crate_apple, crate_berry, crate_carrot, crate_fish, crate_grain, crate_ingot, crate_potato, crate_sugar,
                basket_berry, basket_apple, basket_carrot, basket_fish, basket_grain, basket_ingot, basket_potato, basket_sugar,
                basket_large_apple, basket_large_berry, basket_large_carrot, basket_large_fish, basket_large_grain,
                basket_large_ingot, basket_large_potato, basket_large_sugar,

                //GARDEN
                lantern_candle, lantern_blue, lantern_green, lantern_red, lantern_yellow,
                hedge, fountain, windowbox,

                //HOME
                sidetable, stool,

                //TODO TO BE REMOVED ONCE CODE EXAMPLES NO LONGER REQUIRED
                counter
        );
    }


/*

    public static BlockTable table = new BlockTable("table");
    public static BlockChair chair = new BlockChair("chair");
    public static BlockConnectedChair parkbench = new BlockConnectedChair();


    public static BlockDirectional scales = new BlockDirectional(Material.IRON, "scales");
    public static BlockBottle bottlePlaced = new BlockBottle("bottle_placed");
    public static BlockClutterPlate plateMuffins = new BlockClutterPlate("plate_muffins");
    public static BlockClutterPlate plateCroissants = new BlockClutterPlate("plate_croissants");
    public static BlockDirectional coinpurse = new BlockDirectional(Material.CARPET, "coinpurse");
    //public static BlockPedestal bookPedestal = new BlockPedestal("book_pedestal");

    public static BlockDirectional roofShinglesRed = new BlockDirectional(Material.WOOD, "roof_shingles_red");
    public static BlockDirectional roofShinglesRedConcave = new BlockDirectional(Material.WOOD,"roof_shingles_red_concave");
    public static BlockDirectional roofShinglesRedConvex = new BlockDirectional(Material.WOOD, "roof_shingles_red_convex");

    //TODO for now is registering itself and model registry happening in InvModel
    public static BlockWindow window = new BlockWindow(Material.WOOD,"window");




    */
/** garden block *//*

    public static BlockPlanterbox largeplanterbox = new BlockPlanterbox("largeplanterbox");
    //public static BlockWindowbox windowbox = new BlockWindowbox("windowbox");
    //public static BlockFlowerbed flowerbed = new BlockFlowerbed("flowerbed");
    //public static BlockDenseFlowerbed denseFlowerbed = new BlockDenseFlowerbed("denseflowerbed");
    public static BlockDirectional shrine = new BlockDirectional(Material.ROCK, "shrine");

    */
/** shop block *//*

    public static BlockDisplayCrate displayCrateApple = new BlockDisplayCrate("display_crate_apple");
    public static BlockDisplayCrate displayCrateBerry = new BlockDisplayCrate("display_crate_berry");
    public static BlockDisplayCrate displayCrateCarrot = new BlockDisplayCrate("display_crate_carrot");
    public static BlockDisplayCrate displayCrateFish = new BlockDisplayCrate("display_crate_fish");
    public static BlockDisplayCrate displayCrateGrain = new BlockDisplayCrate("display_crate_grain");
    public static BlockDisplayCrate displayCrateIngot = new BlockDisplayCrate("display_crate_ingot");
    public static BlockDisplayCrate displayCratePotato = new BlockDisplayCrate("display_crate_potato");
    public static BlockDisplayCrate displayCrateSugar = new BlockDisplayCrate("display_crate_sugar");



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

*/

    public static void preInit() {
/*

                bottlePlaced.register();
                plateMuffins.register();
                plateCroissants.register();

                //bookPedestal.register();

                lanternCandle.register();
                lanternBlue.register();
                lanternGreen.register();
                lanternRed.register();
                lanternYellow.register();

                roofShinglesRed.register();
                roofShinglesRedConcave.register();
                roofShinglesRedConvex.register();


        */
/** garden block *//*

        fountain.register();
        hedge.register();
        largeplanterbox.register();
        //windowbox.register();
        //flowerbed.register();
        //denseFlowerbed.register();
        parkbench.register();
        shrine.register();

        */
/** home block *//*

        table.register();
        stool.register();
        chair.register();
        sidetable.register();

        */
/** shop block *//*

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
*/

    }

    public static void registerBlocks() {

    }

    public static void registerItemBlocks() {

    }

    public static void registerModels() {

    }
}
