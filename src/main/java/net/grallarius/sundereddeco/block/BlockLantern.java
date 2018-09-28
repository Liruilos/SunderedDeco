package net.grallarius.sundereddeco.block;

import net.minecraft.block.material.Material;

public class BlockLantern extends BlockBase {

    public BlockLantern(String name){
        super(Material.GLASS, name);
        setHardness(1.0F);
        setResistance(10.0F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 1);
    }
}
