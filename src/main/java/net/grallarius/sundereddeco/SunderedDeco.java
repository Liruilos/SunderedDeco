package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.block.counter.BlockCounter;
import net.grallarius.sundereddeco.block.counter.TileEntityCounter;
import net.grallarius.sundereddeco.block.garden.flowerbeds.ContainerFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityFlowerbed;
import net.grallarius.sundereddeco.block.garden.windowbox.ContainerWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.client.ModColourManager;
import net.grallarius.sundereddeco.client.SunderedDecoTab;
import net.grallarius.sundereddeco.proxy.ClientProxy;
import net.grallarius.sundereddeco.proxy.IProxy;
import net.grallarius.sundereddeco.proxy.ServerProxy;
import net.grallarius.sundereddeco.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Console;

@Mod(SunderedDeco.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class SunderedDeco {
    public static final String MODID = "sundereddeco";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static IForgeRegistry<Block> BLOCK_REGISTRY = GameRegistry.findRegistry(Block.class);
    public static IForgeRegistry<Item> ITEM_REGISTRY  = GameRegistry.findRegistry(Item.class);

    public static final SunderedDecoTab creativeTab = new SunderedDecoTab();

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static SunderedDeco instance;

    public SunderedDeco(){


        // Register methods for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ModColourManager.class);
    }

    private void setup(final FMLCommonSetupEvent event){

        ModRecipes.init();

        proxy.init();
        proxy.setup(event);

    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        //InterModComms.sendTo("sundereddeco", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
        //LOGGER.info("Got IMC {}", event.getIMCStream().
        //        map(m->m.getMessageSupplier().get()).
        //        collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        //event.getRegistry().register(new BlockCounter()); //alt way to register
    }

    @SubscribeEvent
    public static void onTileEntityRegistry(final RegistryEvent.Register<TileEntityType<?>> event) {
        event.getRegistry().register(TileEntityType.Builder.create(TileEntityCounter::new, ModBlocks.COUNTER).build(null).setRegistryName("counter"));
        event.getRegistry().register(TileEntityType.Builder.create(TileEntityWindowbox::new, ModBlocks.windowbox).build(null).setRegistryName("windowbox"));
        event.getRegistry().register(TileEntityType.Builder.create(TileEntityFlowerbed::new, ModBlocks.flowerbed).build(null).setRegistryName("flowerbed"));

    }

    @SubscribeEvent
    public static void onContainerRegistry(final RegistryEvent.Register<ContainerType<?>> event) {

        event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerWindowbox(windowId, SunderedDeco.proxy.getClientWorld(), pos, inv, SunderedDeco.proxy.getClientPlayer());
        }).setRegistryName("windowbox"));

        event.getRegistry().register(IForgeContainerType.create((windowId, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerFlowerbed(windowId, SunderedDeco.proxy.getClientWorld(), pos, inv, SunderedDeco.proxy.getClientPlayer());
        }).setRegistryName("flowerbed"));
    }


}
