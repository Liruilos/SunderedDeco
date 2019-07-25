package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BlockBase extends Block {

    protected String name;

    public BlockBase(Properties properties, String name) {
        //TODO give each block a proper hardness and resistance
        super(properties.hardnessAndResistance(1.5F, 6.0F));

        this.name = name;
        setRegistryName(SunderedDeco.MODID, name);

        ModItems.itemBlocks.add(new BlockItem(this, new BlockItem.Properties().group(SunderedDeco.creativeTab)).setRegistryName(SunderedDeco.MODID, name));
        //setCreativeTab(SunderedDeco.creativeTab);

        //addToRegistryListTextFile(this.name);
    }

    void addToRegistryListTextFile(String s){
        File dir = new File("D:\\Users\\Lauren\\Documents\\GitHub\\SunderedDeco\\helpertools\\src\\main\\resources");
        File file = new File(dir, "RegistryList.txt");
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(s + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
