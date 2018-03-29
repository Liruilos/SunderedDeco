package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.client.SunderedDecoTab;
import net.grallarius.sundereddeco.proxy.CommonProxy;
import net.grallarius.sundereddeco.item.ModItems;
import net.grallarius.sundereddeco.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = SunderedDeco.MODID, name = SunderedDeco.NAME, version = SunderedDeco.VERSION)

public class SunderedDeco {
    public static final String MODID = "sundereddeco";
    public static final String NAME = "Sundered Deco";
    public static final String VERSION = "1.0";

    public static final SunderedDecoTab creativeTab = new SunderedDecoTab();
    public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("COPPER", 2, 500, 6, 2,14);

    @Mod.EventBusSubscriber
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void registerBlocks(RegistryEvent.Register<Block> event) {
            ModBlocks.register(event.getRegistry());
        }

        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            ModItems.register(event.getRegistry());
            ModBlocks.registerItemBlocks(event.getRegistry());
        }
        @SubscribeEvent
        public static void registerItems(ModelRegistryEvent event) {
            ModItems.registerModels();
            ModBlocks.registerModels();
        }
    }

    @Mod.Instance(MODID)
    public static SunderedDeco instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        System.out.println(NAME + " is loading!");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @SidedProxy(serverSide = "net.grallarius.sundereddeco.proxy.CommonProxy", clientSide = "net.grallarius.sundereddeco.proxy.ClientProxy")
    public static CommonProxy proxy;
}
