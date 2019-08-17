package net.grallarius.sundereddeco.block.garden;

import net.grallarius.sundereddeco.block.BlockConnectableHorizontal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockFountain extends BlockConnectableHorizontal {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(0, 0, 0, 16, 15, 16);
    private static final VoxelShape SINGLE_BOX = Block.makeCuboidShape(2, 0, 2, 14, 13, 14);

    private static final Block.Properties props = Block.Properties.create(Material.ROCK)
            .sound(SoundType.STONE);

    public BlockFountain() {
        super(props);
    }


    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockRenderLayer getRenderLayer() {
        return Minecraft.getInstance().gameSettings.fancyGraphics ? BlockRenderLayer.TRANSLUCENT : BlockRenderLayer.CUTOUT;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        if (state.get(SHAPE) == EnumShape.SINGLE) return SINGLE_BOX;
        else return BOUNDING_BOX;
    }

}
