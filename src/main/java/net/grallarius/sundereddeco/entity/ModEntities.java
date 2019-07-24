package net.grallarius.sundereddeco.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.grallarius.sundereddeco.SunderedDeco.MODID;

public class ModEntities {

    public static final EntityType<SittableEntity> SITTABLE_ENTITY = buildType(new ResourceLocation(MODID, "sittable"), EntityType.Builder.<SittableEntity>create((type, world) -> new SittableEntity(world), EntityClassification.MISC).size(0.0F, 0.0F).setCustomClientFactory((spawnEntity, world) -> new SittableEntity(world)));

    private static <T extends Entity> EntityType<T> buildType(ResourceLocation id, EntityType.Builder<T> builder)
    {
        EntityType<T> type = builder.build(id.toString());
        type.setRegistryName(id);
        return type;
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void register(final RegistryEvent.Register<EntityType<?>> event)
        {
            event.getRegistry().register(SITTABLE_ENTITY);
        }
    }
}
