package io.github.matikoss.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import io.github.matikoss.HiddenSurfaceRemoval;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Hidden Surface Removal Test";
        config.width = 1280;
        config.height = 720;
        config.forceExit = false;
        new LwjglApplication(new HiddenSurfaceRemoval(), config);
    }
}
