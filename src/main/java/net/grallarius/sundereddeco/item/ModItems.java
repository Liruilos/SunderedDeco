package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.SunderedDeco;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = SunderedDeco.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {

    public static final ArrayList<Item> itemBlocks = new ArrayList<>();


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        IForgeRegistry<Item> registry = event.getRegistry();

        for (Item i : itemBlocks){
            registry.register(i);
        }

        registry.registerAll(

                new ItemBase("tester_item", new Item.Properties().maxStackSize(32).group(ItemGroup.MISC))

        );
    }

}
