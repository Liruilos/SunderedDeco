package net.grallarius.sundereddeco.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

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

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isTopSolid(IBlockState state)
    {
        return false;
    }

    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
}
