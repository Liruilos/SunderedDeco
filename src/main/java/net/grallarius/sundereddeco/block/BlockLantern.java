package net.grallarius.sundereddeco.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLantern extends BlockBase {

    private static final Properties props = Properties.create(Material.GLASS)
            .lightValue(10)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.GLASS);

    public BlockLantern(String name){
        super(props, name);
       /* setHardness(1.0F);
        setResistance(10.0F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 1);*/
    }
}
