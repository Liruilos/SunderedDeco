package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SDTab;
import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.garden.BlockFountain;
import net.grallarius.sundereddeco.block.garden.BlockHedge;
import net.grallarius.sundereddeco.block.garden.BlockPlanterbox;
import net.grallarius.sundereddeco.block.garden.flowerbeds.*;
import net.grallarius.sundereddeco.block.garden.shrine.ShrineBlock;
import net.grallarius.sundereddeco.block.garden.shrine.ShrineContainer;
import net.grallarius.sundereddeco.block.garden.shrine.ShrineTileEntity;
import net.grallarius.sundereddeco.block.garden.windowbox.BlockWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.ContainerWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.home.*;
import net.grallarius.sundereddeco.block.shop.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = SunderedDeco.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static SDTab sdTab = new SDTab();


    private static final List<Block> BLOCKS = new ArrayList<>();
    private static final List<Item> ITEMBLOCKS = new ArrayList<>();

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
    @ObjectHolder("sundereddeco:shrine")
    public static TileEntityType<ShrineTileEntity> SHRINE_TILE;
    @ObjectHolder("sundereddeco:shrine")
    public static ContainerType<ShrineContainer> SHRINE_CONTAINER;

    //SHOP
    public static final Block crate_closed = register("crate_closed", new BlockCrate(true));
    public static final Block crate_apple = register("crate_apple", new BlockCrate());
    public static final Block crate_berry = register("crate_berry", new BlockCrate());
    public static final Block crate_carrot = register("crate_carrot", new BlockCrate());
    public static final Block crate_fish = register("crate_fish", new BlockCrate());
    public static final Block crate_grain = register("crate_grain", new BlockCrate());
    public static final Block crate_ingot = register("crate_ingot", new BlockCrate());
    public static final Block crate_potato = register("crate_potato", new BlockCrate());
    public static final Block crate_sugar = register("crate_sugar", new BlockCrate());

    public static final Block displayCrateApple = register("display_crate_apple", new BlockDisplayCrate());
    public static final Block displayCrateBerry = register("display_crate_berry", new BlockDisplayCrate());
    public static final Block displayCrateCarrot = register("display_crate_carrot", new BlockDisplayCrate());
    public static final Block displayCrateFish = register("display_crate_fish", new BlockDisplayCrate());
    public static final Block displayCrateGrain = register("display_crate_grain", new BlockDisplayCrate());
    public static final Block displayCrateIngot = register("display_crate_ingot", new BlockDisplayCrate());
    public static final Block displayCratePotato = register("display_crate_potato", new BlockDisplayCrate());
    public static final Block displayCrateSugar = register("display_crate_sugar", new BlockDisplayCrate());

    public static final Block basket_berry = register("basket_berry", new BlockBasket());
    public static final Block basket_apple = register("basket_apple", new BlockBasket());
    public static final Block basket_carrot = register("basket_carrot", new BlockBasket());
    public static final Block basket_fish = register("basket_fish", new BlockBasket());
    public static final Block basket_grain = register("basket_grain", new BlockBasket());
    public static final Block basket_ingot = register("basket_ingot", new BlockBasket());
    public static final Block basket_potato = register("basket_potato", new BlockBasket());
    public static final Block basket_sugar = register("basket_sugar", new BlockBasket());

    public static final Block basket_large_apple = register("basket_large_apple", new BlockLargeBasket());
    public static final Block basket_large_berry = register("basket_large_berry", new BlockLargeBasket());
    public static final Block basket_large_carrot = register("basket_large_carrot", new BlockLargeBasket());
    public static final Block basket_large_fish = register("basket_large_fish", new BlockLargeBasket());
    public static final Block basket_large_grain = register("basket_large_grain", new BlockLargeBasket());
    public static final Block basket_large_ingot = register("basket_large_ingot", new BlockLargeBasket());
    public static final Block basket_large_potato = register("basket_large_potato", new BlockLargeBasket());
    public static final Block basket_large_sugar = register("basket_large_sugar", new BlockLargeBasket());

    public static final Block signApothecary = register("sign_apothecary", new BlockShopSign());
    public static final Block signArmoury = register("sign_armoury", new BlockShopSign());
    public static final Block signBakery = register("sign_bakery", new BlockShopSign());
    public static final Block signBlacksmith = register("sign_blacksmith", new BlockShopSign());
    public static final Block signBrewery = register("sign_brewery", new BlockShopSign());
    public static final Block signClinic = register("sign_clinic", new BlockShopSign());
    public static final Block signClothing = register("sign_clothing", new BlockShopSign());
    public static final Block signDiner = register("sign_diner", new BlockShopSign());
    public static final Block signExotics = register("sign_exotics", new BlockShopSign());
    public static final Block signFishery = register("sign_fishery", new BlockShopSign());
    public static final Block signFlorist = register("sign_florist", new BlockShopSign());
    public static final Block signFurniture = register("sign_furniture", new BlockShopSign());
    public static final Block signGeneral = register("sign_general", new BlockShopSign());
    public static final Block signInn = register("sign_inn", new BlockShopSign());
    public static final Block signJeweller = register("sign_jeweller", new BlockShopSign());
    public static final Block signMusic = register("sign_music", new BlockShopSign());
    public static final Block signPetshop = register("sign_petshop", new BlockShopSign());
    public static final Block signPostal = register("sign_postal", new BlockShopSign());
    public static final Block signPub = register("sign_pub", new BlockShopSign());
    public static final Block signWeapons = register("sign_weapons", new BlockShopSign());

    public static final Block plateMuffins = register("plate_muffins", new BlockClutterPlate());
    public static final Block plateCroissants = register("plate_croissants", new BlockClutterPlate());

    public static final Block coinpurse = register("coinpurse", new BlockClutterObject(Material.CARPET));
    public static final Block scales = register("scales", new BlockClutterObject(Material.IRON));

    //public static final Block bottle = register("bottle", new BlockBottle());


    //GARDEN
    public static final Block lantern_candle = register("lantern_candle", new BlockLantern());
    public static final Block lantern_blue = register("lantern_blue", new BlockLantern());
    public static final Block lantern_green = register("lantern_green", new BlockLantern());
    public static final Block lantern_red = register("lantern_red", new BlockLantern());
    public static final Block lantern_yellow = register("lantern_yellow", new BlockLantern());

    public static final Block hedge = register("hedge", new BlockHedge());
    public static final Block fountain = register("fountain", new BlockFountain());
    public static final Block largeplanterbox = register("largeplanterbox", new BlockPlanterbox());

    @ObjectHolder("sundereddeco:windowbox")
    public static final Block windowbox = register("windowbox", new BlockWindowbox());
    @ObjectHolder("sundereddeco:flowerbed")
    public static final Block flowerbed = register("flowerbed", new BlockFlowerbed());
    @ObjectHolder("sundereddeco:denseflowerbed")
    public static final Block denseflowerbed = register("denseflowerbed", new BlockDenseFlowerbed());
    @ObjectHolder("sundereddeco:shrine")
    public static final Block shrine = register("shrine", new ShrineBlock());

    //HOME
    public static final Block sidetable = register("sidetable", new BlockSidetable());
    public static final Block stool = register("stool", new BlockSittable(Block.Properties.create(Material.WOOD)));
    public static final Block chair = register("chair", new BlockChair());
    public static final Block table = register("table", new BlockTable());

    public static final Block window = register("window", new BlockWindow(Material.WOOD));
    public static final Block parkbench = register("parkbench", new BlockConnectedChair());


    private static Block register(String name, Block block)
    {
        return register(name, block, new Item.Properties().group(sdTab.itemGroup));
    }

    private static Block register(String name, Block block, Item.Properties properties)
    {
        return register(name, block, new BlockItem(block, properties));
    }

    private static Block register(String name, Block block, BlockItem item)
    {
        block.setRegistryName(name);
        BLOCKS.add(block);
        if(block.getRegistryName() != null)
        {
            item.setRegistryName(name);
            ITEMBLOCKS.add(item);
        }
        return block;
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        BLOCKS.forEach(block -> event.getRegistry().register(block));
        BLOCKS.clear();
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        ITEMBLOCKS.forEach(item -> event.getRegistry().register(item));
        ITEMBLOCKS.clear();
    }
}
