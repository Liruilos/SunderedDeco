package net.grallarius.sundereddeco.item;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
                //crate ItemBlocks for inventory model
/*                new ItemBlock(ModBlocks.crate_closed, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_closed"),
                new ItemBlock(ModBlocks.crate_apple, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_apple"),
                new ItemBlock(ModBlocks.crate_berry, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_berry"),
                new ItemBlock(ModBlocks.crate_carrot, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_carrot"),
                new ItemBlock(ModBlocks.crate_fish, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_fish"),
                new ItemBlock(ModBlocks.crate_grain, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_grain"),
                new ItemBlock(ModBlocks.crate_ingot, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_ingot"),
                new ItemBlock(ModBlocks.crate_potato, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_potato"),
                new ItemBlock(ModBlocks.crate_sugar, new ItemBlock.Properties().group(ItemGroup.MISC)).setRegistryName(SunderedDeco.MODID, "crate_sugar")*/

        );
    }

    public static void preInit() {
/*                ingotCopper.register();
                copperSword.register();*/
    }

    public static void registerModels() {
/*        ingotCopper.register();
        copperSword.register();*/
    }
}
