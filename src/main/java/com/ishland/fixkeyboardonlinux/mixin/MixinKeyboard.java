package com.ishland.fixkeyboardonlinux.mixin;

import com.ishland.fixkeyboardonlinux.TheMod;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard {

    @Inject(method = "onChar", at = @At(value = "HEAD"), cancellable = true)
    private void beforeOnChar(CallbackInfo ci) {
        long handle = MinecraftClient.getInstance().getWindow().getHandle();

        if (GLFW.glfwGetKey(handle, TheMod.KEY_LEFT_CTRL) == GLFW.GLFW_PRESS ||
                GLFW.glfwGetKey(handle, TheMod.KEY_RIGHT_CTRL) == GLFW.GLFW_PRESS ||
                GLFW.glfwGetKey(handle, GLFW.GLFW_KEY_LEFT_ALT) == GLFW.GLFW_PRESS) {
            ci.cancel();
        }
    }

}
