package net.grallarius.sundereddeco.block.shop;

import net.grallarius.sundereddeco.block.BlockBase;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class BlockCrate extends BlockBase {

    private static final Properties props = Properties.create(Material.WOOD)
            .hardnessAndResistance(2F, 10F)
            .sound(SoundType.WOOD);

    public BlockCrate(String name){
        super(props, name);
    }

    public BlockCrate(Properties properties, String name){
        super(properties, name);
    }

/*    @Override
    @Deprecated
    public BlockFaceShape func_193383_a(IBlockReader p_193383_1_, BlockState p_193383_2_, BlockPos p_193383_3_, Direction p_193383_4_) {
        return BlockFaceShape.UNDEFINED;
    }*/

/*    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }*/


}
