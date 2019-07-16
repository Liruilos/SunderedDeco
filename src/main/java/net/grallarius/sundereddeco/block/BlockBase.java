package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

    protected String name;

    public BlockBase(Properties properties, String name) {
        //TODO give each block a proper hardness and resistance
        super(properties.hardnessAndResistance(1.5F, 6.0F));

        this.name = name;
        setRegistryName(SunderedDeco.MODID, name);

        ModItems.itemBlocks.add(new ItemBlock(this, new ItemBlock.Properties().group(SunderedDeco.creativeTab)).setRegistryName(SunderedDeco.MODID, name));
        //setCreativeTab(SunderedDeco.creativeTab);
    }

}
