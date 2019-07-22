package net.grallarius.sundereddeco.proxy;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.block.garden.windowbox.WindowboxRenderer;
import net.grallarius.sundereddeco.block.garden.windowbox.TileEntityWindowbox;
import net.grallarius.sundereddeco.block.garden.windowbox.WindowboxScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.grallarius.sundereddeco.SunderedDeco.MODID;

public class ClientProxy implements IProxy {


    @Override
    public void init() {
        //match containers with their guis
        ScreenManager.registerFactory(ModBlocks.WINDOWBOX_CONTAINER, WindowboxScreen::new);
    }

    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }

    @Override
    public PlayerEntity getClientPlayer() {
        return Minecraft.getInstance().player;
    }
    @Override
    public void setup(FMLCommonSetupEvent event){
        OBJLoader.INSTANCE.addDomain(MODID);

        registerRenderers();
        //ModColourManager.registerColourHandlers();
    }


    @Override
    public void registerRenderers() {
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedestal.class, new TESRPedestal());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindowbox.class, new WindowboxRenderer());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDenseFlowerbed.class, new TESRDenseFlowerbed());
        //ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFlowerbed.class, new TESRFlowerbed());
    }
}
