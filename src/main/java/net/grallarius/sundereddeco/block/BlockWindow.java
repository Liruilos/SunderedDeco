package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class BlockWindow extends BlockDoor {

    protected String name;

    public BlockWindow(Material material, String name){
        super(Properties.create(material));
        this.name = name;
        setRegistryName(SunderedDeco.MODID, name);

        ModItems.itemBlocks.add(new ItemBlock(this, new ItemBlock.Properties().group(SunderedDeco.creativeTab)).setRegistryName(SunderedDeco.MODID, name));

    }

}
