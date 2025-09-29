package de.gcat.gcpo.client.mixins;


import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Particle.class)
public interface ParticlesAccessor {
    @Accessor("velocityX")
    void setVelocityX(double x);

    @Accessor("velocityY")
    void setVelocityY(double y);

    @Accessor("velocityZ")
    void setVelocityZ(double z);

    @Accessor("age") int getAge();
    @Accessor("age") void setAge(int age);
    @Accessor("maxAge") int getMaxAge();
}
