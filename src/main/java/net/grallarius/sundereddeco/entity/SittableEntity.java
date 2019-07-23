package net.grallarius.sundereddeco.entity;

import net.grallarius.sundereddeco.block.home.BlockSittable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class SittableEntity extends Entity {
    public SittableEntity (World world, BlockPos pos) {
        //TODO find a better entity type
        super(EntityType.MINECART , world);
        setPosition(pos.getX() + 0.5, pos.getY() + 0.4, pos.getZ() + 0.5);
        //setSize(0F, 0F);
    }

    @Override
    public void tick() {
        BlockPos pos = getPosition();
        if (pos != null && !(getEntityWorld().getBlockState(pos).getBlock() instanceof BlockSittable)) {
            remove();
            return;
        }
        List<Entity> passengers = getPassengers();
        if (passengers.isEmpty()) {
            remove();
        }
        for (Entity e : passengers) {
            if (e.isSneaking()) {
                remove();
            }
        }
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return null;
    }

    @Override
    protected void registerData() {

    }

}
