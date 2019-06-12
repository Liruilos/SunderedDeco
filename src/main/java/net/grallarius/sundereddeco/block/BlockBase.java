package net.grallarius.sundereddeco.block;

import net.grallarius.sundereddeco.SunderedDeco;
import net.grallarius.sundereddeco.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

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

    @Override
    @Deprecated
    public BlockFaceShape getBlockFaceShape(IBlockReader worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    @Deprecated
    public boolean canEntitySpawn(IBlockState state, Entity entityIn) {
        return false;
    }


}
