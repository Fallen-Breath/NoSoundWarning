package me.fallenbreath.nosoundwarning.mixins;

import net.minecraft.client.sound.SoundSystem;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = SoundSystem.class, priority = 10000)
public abstract class SoundSystemMixin
{
	@Redirect(
			method = "play(Lnet/minecraft/client/sound/SoundInstance;)V",
			at = @At(
					value = "INVOKE",
					target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;)V",
					remap = false
			),
			require = 0
	)
	private void stopWarning(Logger logger, String message)
	{
		// do nothing
	}
}
