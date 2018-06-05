package net.grallarius.sundereddeco;

import net.grallarius.sundereddeco.client.SunderedDecoTab;
import net.grallarius.sundereddeco.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = SunderedDeco.MODID, name = SunderedDeco.NAME, version = SunderedDeco.VERSION)

public class SunderedDeco {
    public static final String MODID = "sundereddeco";
    public static final String NAME = "Sundered Deco";
    public static final String VERSION = "1.0";

    public static IForgeRegistry<Block> BLOCK_REGISTRY = GameRegistry.findRegistry(Block.class);
    public static IForgeRegistry<Item> ITEM_REGISTRY  = GameRegistry.findRegistry(Item.class);

    public static final SunderedDecoTab creativeTab = new SunderedDecoTab();
    public static final Item.ToolMaterial copperToolMaterial = EnumHelper.addToolMaterial("COPPER", 2, 500, 6, 2,14);

    @Mod.Instance(MODID)
    public static SunderedDeco instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @SidedProxy(serverSide = "net.grallarius.sundereddeco.proxy.ServerProxy",
            clientSide = "net.grallarius.sundereddeco.proxy.ClientProxy",
            modId = MODID)
    public static ServerProxy proxy;
}
