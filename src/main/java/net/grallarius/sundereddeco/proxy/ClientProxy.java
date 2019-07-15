package net.grallarius.sundereddeco.proxy;
import net.grallarius.sundereddeco.block.garden.windowbox.TESRWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.grallarius.sundereddeco.SunderedDeco.MODID;

public class ClientProxy implements IProxy {

    @Override
    public void setup(FMLCommonSetupEvent event){
        OBJLoader.INSTANCE.addDomain(MODID);

        registerRenderers();
        //ModColourManager.registerColourHandlers();
    }


    @Override
    public void registerRenderers() {
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindowbox.class, new TESRWindowbox());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDenseFlowerbed.class, new TESRDenseFlowerbed());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlowerbed.class, new TESRFlowerbed());
    }
}
