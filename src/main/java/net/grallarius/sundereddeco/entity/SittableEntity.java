package net.grallarius.sundereddeco.entity;

import net.grallarius.sundereddeco.block.furniture.BlockSittable;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SittableEntity extends Entity {
    public SittableEntity (World world, BlockPos pos) {
        super(world);
        setPosition(pos.getX() + 0.5, pos.getY() + 0.4, pos.getZ() + 0.5);
        setSize(0F, 0F);
    }

    @Override
    public void onUpdate() {
        BlockPos pos = getPosition();
        if (pos != null && !(getEntityWorld().getBlockState(pos).getBlock() instanceof BlockSittable)) {
            setDead();
            return;
        }
        List<Entity> passengers = getPassengers();
        if (passengers.isEmpty()) {
            setDead();
        }
        for (Entity e : passengers) {
            if (e.isSneaking()) {
                setDead();
            }
        }
    }

    @Override
    protected void entityInit() {}

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound) {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound) {}
}
