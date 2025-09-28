package com.ishland.fixkeyboardonlinux;

import io.netty.util.internal.PlatformDependent;
import net.fabricmc.api.ModInitializer;
import org.lwjgl.glfw.GLFW;

public class TheMod implements ModInitializer {

    public static final int KEY_LEFT_CTRL = PlatformDependent.isOsx() ? GLFW.GLFW_KEY_LEFT_SUPER : GLFW.GLFW_KEY_LEFT_CONTROL;
    public static final int KEY_RIGHT_CTRL = PlatformDependent.isOsx() ? GLFW.GLFW_KEY_RIGHT_SUPER : GLFW.GLFW_KEY_RIGHT_CONTROL;

    @Override
    public void onInitialize() {

    }
}
