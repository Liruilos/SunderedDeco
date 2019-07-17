package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;

public class BlockWindow extends DoorBlock {

    protected String name;

    public BlockWindow(Material material, String name){
        super(Properties.create(material));
        this.name = name;
        setRegistryName(SunderedDeco.MODID, name);

        ModItems.itemBlocks.add(new BlockItem(this, new BlockItem.Properties().group(SunderedDeco.creativeTab)).setRegistryName(SunderedDeco.MODID, name));

    }

}
