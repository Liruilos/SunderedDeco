package net.grallarius.sundereddeco.block.home;

import net.grallarius.sundereddeco.block.BlockBase;
import net.grallarius.sundereddeco.entity.SittableEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.List;


public class BlockSittable extends BlockBase {

    private static final VoxelShape BOUNDING_BOX = Block.makeCuboidShape(2, 0, 2, 14, 10, 14);

    public BlockSittable(Properties properties, String name) {
        super(properties, name);
    }

    @Override
    @Deprecated
    public void onBlockClicked(BlockState state, World world, BlockPos pos, PlayerEntity player) {
        List<SittableEntity> sittables = world.getEntitiesWithinAABB(SittableEntity.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)), null);
        if (sittables.isEmpty()) {
            SittableEntity sittable = new SittableEntity(world, pos);
            world.addEntity(sittable);
            player.startRiding(sittable);
        }
    }

    @Override
    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return BOUNDING_BOX;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
