package io.github.matikoss.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.github.matikoss.VirtualCamera;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Virtual Camera";
        config.width = 1280;
        config.height = 720;
        config.forceExit = false;
        new LwjglApplication(new VirtualCamera(), config);
    }
}