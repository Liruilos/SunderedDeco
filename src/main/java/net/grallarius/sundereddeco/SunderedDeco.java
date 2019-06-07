package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.client.ModColourManager;
import net.grallarius.sundereddeco.client.SunderedDecoTab;
import net.grallarius.sundereddeco.item.ModItems;
import net.grallarius.sundereddeco.proxy.ClientProxy;
import net.grallarius.sundereddeco.proxy.IProxy;
import net.grallarius.sundereddeco.proxy.ServerProxy;
import net.grallarius.sundereddeco.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
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

import java.util.stream.Collectors;

//@Mod(modid = SunderedDeco.MODID, name = SunderedDeco.NAME, version = SunderedDeco.VERSION)

@Mod(SunderedDeco.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)

public class SunderedDeco {
    public static final String MODID = "sundereddeco";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static IForgeRegistry<Block> BLOCK_REGISTRY = GameRegistry.findRegistry(Block.class);
    public static IForgeRegistry<Item> ITEM_REGISTRY  = GameRegistry.findRegistry(Item.class);

    //public static SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(SunderedDeco.MODID);

    public static final SunderedDecoTab creativeTab = new SunderedDecoTab();

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static SunderedDeco instance;

    public SunderedDeco(){

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ModColourManager.class);
    }

    private static byte packetId = 0;
    private void setup(final FMLCommonSetupEvent event){

        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        ModBlocks.preInit();
        ModItems.preInit();

/*        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
        wrapper.registerMessage(new PacketUpdatePedestal.Handler(), PacketUpdatePedestal.class, packetId++, Side.CLIENT);
        wrapper.registerMessage(new PacketRequestUpdatePedestal.Handler(), PacketRequestUpdatePedestal.class, packetId++, Side.SERVER);
        wrapper.registerMessage(new PacketUpdateWindowbox.Handler(), PacketUpdateWindowbox.class, packetId++, Side.CLIENT);
        wrapper.registerMessage(new PacketRequestUpdateWindowbox.Handler(), PacketRequestUpdateWindowbox.class, packetId++, Side.SERVER);
        wrapper.registerMessage(new PacketUpdateDenseFlowerbed.Handler(), PacketUpdateDenseFlowerbed.class, packetId++, Side.CLIENT);
        wrapper.registerMessage(new PacketRequestUpdateDenseFlowerbed.Handler(), PacketRequestUpdateDenseFlowerbed.class, packetId++, Side.SERVER);
        wrapper.registerMessage(new PacketUpdateFlowerbed.Handler(), PacketUpdateFlowerbed.class, packetId++, Side.CLIENT);
        wrapper.registerMessage(new PacketRequestUpdateFlowerbed.Handler(), PacketRequestUpdateFlowerbed.class, packetId++, Side.SERVER);
        proxy.registerRenderers();*/

        ModRecipes.init();

        proxy.setup(event);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
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

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

}
