package net.grallarius.sundereddeco;


import net.grallarius.sundereddeco.block.ModBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

import java.util.ArrayList;

public class InvModel {
    private static final ArrayList<InvModel> models = new ArrayList<>();

    public static void add(Item item, int meta, String name) {
        System.out.println("model " + name + " is being registered");
        models.add(new InvModel(item, 0, name));
    }

    private final Item item;
    private final int meta;
    private final String name;

    public InvModel(Item item, int meta, String name) {
        this.item = item;
        this.meta = meta;
        this.name = name;
    }

    public static void register() {

/*        System.out.println("model registry is called");

        for(InvModel invmodel : models){
            ModelLoader.setCustomModelResourceLocation(invmodel.item, invmodel.meta,
                    new ModelResourceLocation(SunderedDeco.MODID + ":" + invmodel.name, "inventory"));

            ModBlocks.window.initModel();
        }*/
    }
}
