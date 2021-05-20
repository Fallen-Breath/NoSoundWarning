package me.fallenbreath.nosoundwarning.mixins;

import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(targets = "net.minecraft.client.sound.SoundEngine$SourceSetImpl", priority = 10000)
public class SourceSetImplMixin
{
	@Redirect(
			method = "createSource()Lnet/minecraft/client/sound/Source;",
			at = @At(
					value = "INVOKE",
					target = "Lorg/apache/logging/log4j/Logger;warn(Ljava/lang/String;Ljava/lang/Object;)V",
					remap = false
			),
			require = 0
	)
	private void stopWarning(Logger logger, String message, Object p0)
	{
		// do nothing
	}
}
