package net.grallarius.sundereddeco.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLantern extends BlockBase {

    private static final Properties props = Properties.create(Material.GLASS)
            .lightValue(10)
            .hardnessAndResistance(1F, 10F)
            .sound(SoundType.GLASS);

    public BlockLantern(){
        super(props);
       /* setHardness(1.0F);
        setResistance(10.0F);
        this.setLightLevel(1.0F);
        this.setHarvestLevel("pickaxe", 1);*/
    }

/*    @Override
    @Deprecated
    public BlockFaceShape func_193383_a(IBlockReader p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
        return BlockFaceShape.UNDEFINED;
    }*/

/*    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }*/
}
