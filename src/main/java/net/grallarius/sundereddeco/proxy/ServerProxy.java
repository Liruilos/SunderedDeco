package net.grallarius.sundereddeco.proxy;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.grallarius.sundereddeco.item.ModItems;
import net.grallarius.sundereddeco.recipe.ModRecipes;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ServerProxy {

    public void preInit(FMLPreInitializationEvent event) {
        ModBlocks.preInit();
        ModItems.preInit();
    }

    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
