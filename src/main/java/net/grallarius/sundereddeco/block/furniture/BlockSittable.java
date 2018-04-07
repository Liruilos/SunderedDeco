package net.grallarius.sundereddeco.block.furniture;

import net.grallarius.sundereddeco.block.BlockBase;
import net.grallarius.sundereddeco.entity.SittableEntity;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;


public class BlockSittable extends BlockBase {

    protected static final AxisAlignedBB BOUNDBOX = new AxisAlignedBB(0.125D, 0.0D,0.125D,0.875D,0.62D,0.875D);

    public BlockSittable() {
        super(Material.WOOD, "stool");
        setSoundType(SoundType.WOOD);
    }

    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state) {
        return false;
    }


    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
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
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BOUNDBOX;
    }
}
