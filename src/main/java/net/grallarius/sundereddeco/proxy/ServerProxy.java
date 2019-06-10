package net.grallarius.sundereddeco.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ServerProxy implements IProxy{

    @Override
    public void setup(FMLCommonSetupEvent event){

    }

/*    public String localize(String unlocalized, Object... args) {
        return I18n.translateToLocalFormatted(unlocalized, args);
    }*/

    public void registerRenderers() {
    }
}
