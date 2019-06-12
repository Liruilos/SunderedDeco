package net.grallarius.sundereddeco.block.furniture;

import net.grallarius.sundereddeco.block.BlockBase;
import net.grallarius.sundereddeco.entity.SittableEntity;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
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
    public boolean onBlockActivated(IBlockState state, World world, BlockPos pos, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        List<SittableEntity> sittables = world.getEntitiesWithinAABB(SittableEntity.class, new AxisAlignedBB(pos, pos.add(1, 1, 1)));
        if (sittables.isEmpty()) {
            SittableEntity sittable = new SittableEntity(world, pos);
            world.spawnEntity(sittable);
            player.startRiding(sittable);
        }
        return true;
    }

    @Override
    @Deprecated
    public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
        return BOUNDING_BOX;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}
