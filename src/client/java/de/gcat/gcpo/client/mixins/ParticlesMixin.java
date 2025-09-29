package de.gcat.gcpo.client.mixins;


import net.minecraft.client.particle.DustColorTransitionParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import de.gcat.gcpo.client.mixins.ParticlesAccessor;

@Mixin(Particle.class)
public abstract class ParticlesMixin {
    //private static final Logger LOGGER = LoggerFactory.getLogger("gcpo");
    @Shadow public abstract int getMaxAge();

    @Shadow public abstract ParticleTextureSheet getType();

    @Shadow public abstract String toString();

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        // Cast to the accessor interface, not to the mixin

        ParticlesAccessor accessor = (ParticlesAccessor) (Object) this;
        //LOGGER.info(this.getType().toString());

        accessor.setVelocityX(0);
        accessor.setVelocityY(0);
        accessor.setVelocityZ(0);
        if(accessor.getAge() >= 1) {
            accessor.setAge(getMaxAge());
        }

    }
}