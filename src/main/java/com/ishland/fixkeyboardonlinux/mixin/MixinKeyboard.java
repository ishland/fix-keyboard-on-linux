package com.ishland.fixkeyboardonlinux.mixin;

import net.minecraft.client.Keyboard;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {

    @Inject(method = "onChar", at = @At(value = "HEAD"), cancellable = true)
    private void beforeOnChar(CallbackInfo ci) {
        if (Screen.hasControlDown() || Screen.hasAltDown()) ci.cancel();
    }

}
