package net.grallarius.sundereddeco.proxy;

import net.grallarius.sundereddeco.InvModel;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TESRDenseFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TESRFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityDenseFlowerbed;
import net.grallarius.sundereddeco.block.garden.flowerbeds.TileEntityFlowerbed;
import net.grallarius.sundereddeco.block.garden.windowbox.TESRWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.pedestal.TESRPedestal;
import net.grallarius.sundereddeco.block.pedestal.TileEntityPedestal;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends ServerProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        InvModel.register();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public String localize(String unlocalized, Object... args) {
        return I18n.format(unlocalized, args);
    }

    @Override
    public void registerRenderers() {
/*        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());*/
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindowbox.class, new TESRWindowbox());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDenseFlowerbed.class, new TESRDenseFlowerbed());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlowerbed.class, new TESRFlowerbed());
    }
}
