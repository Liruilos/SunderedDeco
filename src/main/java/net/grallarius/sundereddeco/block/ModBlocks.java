package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.counter.BlockCounter;
import net.grallarius.sundereddeco.block.counter.TileEntityCounter;
import net.grallarius.sundereddeco.block.garden.BlockShrine;
import net.grallarius.sundereddeco.block.garden.flowerbeds.*;
import net.grallarius.sundereddeco.block.home.*;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockHedge;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.ContainerWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.shop.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = SunderedDeco.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(SunderedDeco.MODID)
public class ModBlocks {

    @ObjectHolder("sundereddeco:counter")
    public static final BlockCounter COUNTER = new BlockCounter();
    @ObjectHolder("sundereddeco:counter")
    public static TileEntityType<TileEntityCounter> COUNTER_TILE;

    @ObjectHolder("sundereddeco:windowbox")
    public static TileEntityType<TileEntityWindowbox> WINDOWBOX_TILE;
    @ObjectHolder("sundereddeco:windowbox")
    public static ContainerType<ContainerWindowbox> WINDOWBOX_CONTAINER;
    @ObjectHolder("sundereddeco:flowerbed")
    public static TileEntityType<TileEntityFlowerbed> FLOWERBED_TILE;
    @ObjectHolder("sundereddeco:flowerbed")
    public static ContainerType<ContainerFlowerbed> FLOWERBED_CONTAINER;
    @ObjectHolder("sundereddeco:denseflowerbed")
    public static TileEntityType<TileEntityDenseFlowerbed> DENSE_FLOWERBED_TILE;
    @ObjectHolder("sundereddeco:denseflowerbed")
    public static ContainerType<ContainerDenseFlowerbed> DENSE_FLOWERBED_CONTAINER;

    //SHOP
    public static final BlockCrate crate_closed = new BlockCrate("crate_closed", true);
    public static final BlockCrate crate_apple = new BlockCrate("crate_apple");
    public static final BlockCrate crate_berry = new BlockCrate("crate_berry");
    public static final BlockCrate crate_carrot = new BlockCrate("crate_carrot");
    public static final BlockCrate crate_fish = new BlockCrate("crate_fish");
    public static final BlockCrate crate_grain = new BlockCrate("crate_grain");
    public static final BlockCrate crate_ingot = new BlockCrate("crate_ingot");
    public static final BlockCrate crate_potato = new BlockCrate("crate_potato");
    public static final BlockCrate crate_sugar = new BlockCrate("crate_sugar");

    public static final BlockDisplayCrate displayCrateApple = new BlockDisplayCrate("display_crate_apple");
    public static final BlockDisplayCrate displayCrateBerry = new BlockDisplayCrate("display_crate_berry");
    public static final BlockDisplayCrate displayCrateCarrot = new BlockDisplayCrate("display_crate_carrot");
    public static final BlockDisplayCrate displayCrateFish = new BlockDisplayCrate("display_crate_fish");
    public static final BlockDisplayCrate displayCrateGrain = new BlockDisplayCrate("display_crate_grain");
    public static final BlockDisplayCrate displayCrateIngot = new BlockDisplayCrate("display_crate_ingot");
    public static final BlockDisplayCrate displayCratePotato = new BlockDisplayCrate("display_crate_potato");
    public static final BlockDisplayCrate displayCrateSugar = new BlockDisplayCrate("display_crate_sugar");

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

    public static final BlockShopSign signApothecary = new BlockShopSign("sign_apothecary");
    public static final BlockShopSign signArmoury = new BlockShopSign("sign_armoury");
    public static final BlockShopSign signBakery = new BlockShopSign("sign_bakery");
    public static final BlockShopSign signBlacksmith = new BlockShopSign("sign_blacksmith");
    public static final BlockShopSign signBrewery = new BlockShopSign("sign_brewery");
    public static final BlockShopSign signClinic = new BlockShopSign("sign_clinic");
    public static final BlockShopSign signClothing = new BlockShopSign("sign_clothing");
    public static final BlockShopSign signDiner = new BlockShopSign("sign_diner");
    public static final BlockShopSign signExotics = new BlockShopSign("sign_exotics");
    public static final BlockShopSign signFishery = new BlockShopSign("sign_fishery");
    public static final BlockShopSign signFlorist = new BlockShopSign("sign_florist");
    public static final BlockShopSign signFurniture = new BlockShopSign("sign_furniture");
    public static final BlockShopSign signGeneral = new BlockShopSign("sign_general");
    public static final BlockShopSign signInn = new BlockShopSign("sign_inn");
    public static final BlockShopSign signJeweller = new BlockShopSign("sign_jeweller");
    public static final BlockShopSign signMusic = new BlockShopSign("sign_music");
    public static final BlockShopSign signPetshop = new BlockShopSign("sign_petshop");
    public static final BlockShopSign signPostal = new BlockShopSign("sign_postal");
    public static final BlockShopSign signPub = new BlockShopSign("sign_pub");
    public static final BlockShopSign signWeapons = new BlockShopSign("sign_weapons");

    public static final BlockClutterPlate plateMuffins = new BlockClutterPlate("plate_muffins");
    public static final BlockClutterPlate plateCroissants = new BlockClutterPlate("plate_croissants");

    //GARDEN
    public static final BlockLantern lantern_candle = new BlockLantern("lantern_candle");
    public static final BlockLantern lantern_blue = new BlockLantern("lantern_blue");
    public static final BlockLantern lantern_green = new BlockLantern("lantern_green");
    public static final BlockLantern lantern_red = new BlockLantern("lantern_red");
    public static final BlockLantern lantern_yellow = new BlockLantern("lantern_yellow");

    public static final BlockHedge hedge = new BlockHedge("hedge");
    public static final BlockFountain fountain = new BlockFountain("fountain");
    public static final BlockPlanterbox largeplanterbox = new BlockPlanterbox("largeplanterbox");
    public static final BlockShrine shrine = new BlockShrine("shrine");

    @ObjectHolder("sundereddeco:windowbox")
    public static final BlockWindowbox windowbox = new BlockWindowbox("windowbox");
    @ObjectHolder("sundereddeco:flowerbed")
    public static final BlockFlowerbed flowerbed = new BlockFlowerbed("flowerbed");
    @ObjectHolder("sundereddeco:denseflowerbed")
    public static final BlockDenseFlowerbed denseflowerbed = new BlockDenseFlowerbed("denseflowerbed");


    //HOME
    public static final BlockSidetable sidetable = new BlockSidetable("sidetable");
    public static final BlockSittable stool = new BlockSittable(Block.Properties.create(Material.WOOD),"stool");
    public static final BlockChair chair = new BlockChair("chair");
    public static final BlockTable table = new BlockTable("table");

    public static final BlockWindow window = new BlockWindow(Material.WOOD,"window");
    public static final BlockConnectedChair parkbench = new BlockConnectedChair("parkbench");



    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(

                //SHOP
            crate_closed, crate_apple, crate_berry, crate_carrot, crate_fish, crate_grain, crate_ingot, crate_potato, crate_sugar,
                displayCrateApple, displayCrateBerry, displayCrateCarrot, displayCrateFish, displayCrateGrain,
                displayCrateIngot, displayCratePotato, displayCrateSugar,
                basket_apple, basket_berry, basket_carrot, basket_fish, basket_grain, basket_ingot, basket_potato, basket_sugar,
                basket_large_apple, basket_large_berry, basket_large_carrot, basket_large_fish, basket_large_grain,
                basket_large_ingot, basket_large_potato, basket_large_sugar,
                signApothecary, signArmoury, signBakery, signBlacksmith,signBrewery, signClinic, signClothing,
                signDiner, signExotics, signFishery, signFlorist, signFurniture, signGeneral, signInn, signJeweller,
                signMusic, signPetshop, signPostal, signPub, signWeapons,
                plateMuffins, plateCroissants,

                //GARDEN
                lantern_candle, lantern_blue, lantern_green, lantern_red, lantern_yellow,
                hedge, fountain, largeplanterbox, shrine, windowbox, flowerbed, denseflowerbed,

                //HOME
                sidetable, stool, chair, table,

                window, parkbench,

                COUNTER
        );
    }


/*


    public static BlockDirectional scales = new BlockDirectional(Material.IRON, "scales");
    public static BlockBottle bottlePlaced = new BlockBottle("bottle_placed");

    public static BlockDirectional coinpurse = new BlockDirectional(Material.CARPET, "coinpurse");
    //public static BlockPedestal bookPedestal = new BlockPedestal("book_pedestal");


    */
/** garden block *//*


    */
/** shop block *//*





*/

}
