package net.grallarius.sundereddeco.client;

import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.BlockItem;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModColourManager {
    private static final Minecraft minecraft = Minecraft.getInstance();

    @SubscribeEvent
    public static void registerBlockColors(final ColorHandlerEvent.Block event)
    {
        final IBlockColor grassColourHandler = (state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                return BiomeColors.getGrassColor(blockAccess, pos);
            }

            return GrassColors.get(0.5D, 1.0D);
        };

        final IBlockColor waterColourHandler = (state, blockAccess, pos, tintIndex) -> {
            if (blockAccess != null && pos != null) {
                return BiomeColors.getWaterColor(blockAccess, pos);
            }

            //TODO actually return an appropriate water colour
            return GrassColors.get(0.5D, 1.0D);
        };

        event.getBlockColors().register(grassColourHandler, ModBlocks.hedge);
        event.getBlockColors().register(waterColourHandler, ModBlocks.fountain);
    }

    @SubscribeEvent
    public static void registerItemColours(final ColorHandlerEvent.Item event){
        final BlockColors blockColors = minecraft.getBlockColors();
        final IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            final BlockState state = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
            return blockColors.getColor(state, null, null);
        };


        event.getItemColors().register(itemBlockColourHandler, ModBlocks.hedge);
        event.getItemColors().register(itemBlockColourHandler, ModBlocks.fountain);

    }

}