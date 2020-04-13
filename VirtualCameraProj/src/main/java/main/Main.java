package main;

import core.Renderers.MainRenderer;
import engine.io.Input;
import engine.io.Window;
import org.lwjgl.glfw.GLFW;

public class Main implements Runnable {
    public Thread game;
    public static Window window;
    public MainRenderer mainRenderer;
    public final int WIDTH = 1280, HEIGHT = 720;


    public void start() {
        game = new Thread(this, "game");
        game.start();
    }

    public void init() {
        System.out.println("Init");
        window = new Window(WIDTH, HEIGHT, "Virtual Camera");
        mainRenderer = new MainRenderer(WIDTH, HEIGHT);
        window.setBackgroundColor(0.0f, 0, 0);
        window.create();
    }

    public void run() {
        init();
        while (!window.shouldClose() && !Input.isKeyDown(GLFW.GLFW_KEY_ESCAPE)) {
            update();
            render();
        }
        window.destroyInput();
    }

    private void update() {
        mainRenderer.mainController.update();
        window.update();
    }

    private void render() {
        mainRenderer.render();
        window.swapBuffers();
    }

    public static void main(String[] args) {
        System.out.println("START");
        new Main().start();
    }
}
