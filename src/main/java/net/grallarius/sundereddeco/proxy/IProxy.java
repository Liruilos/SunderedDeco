package net.grallarius.sundereddeco.proxy;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public interface IProxy {

    void init();

    World getClientWorld();

    PlayerEntity getClientPlayer();

    void setup(final FMLCommonSetupEvent event);

    public void registerRenderers();
}
