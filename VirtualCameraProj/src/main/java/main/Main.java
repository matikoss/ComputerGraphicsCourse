package main;

import core.Renderers.MainRenderer;
import engine.graphics.Mesh;
import engine.graphics.Renderer;
import engine.graphics.Vertex;
import engine.io.Input;
import engine.io.Window;
import engine.maths.Vector3f;
import engine.objects.Camera;
import org.lwjgl.glfw.GLFW;

public class Main implements Runnable {
    public Thread game;
    public static Window window;
    public Renderer renderer;
    public MainRenderer mainRenderer;
    public Camera camera = new Camera(new Vector3f(0, 0, 0), new Vector3f(0, 0, 0));
    public final int WIDTH = 1280, HEIGHT = 720;

    public Mesh mesh = new Mesh(new Vertex[]{
            new Vertex(new Vector3f(-0.5f, 0.5f, 0.0f)),
            new Vertex(new Vector3f(0.5f, 0.5f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, 0.0f)),
            new Vertex(new Vector3f(-0.5f, -0.5f, 0.0f))
    }, new int[]{
            0, 1, 2,
            0, 3, 2
    });


    public void start() {
        game = new Thread(this, "game");
        game.start();
    }

    public void init() {
        System.out.println("Init");
        window = new Window(WIDTH, HEIGHT, "Virtual Camera");
        renderer = new Renderer();
        mainRenderer = new MainRenderer(WIDTH, HEIGHT);
        window.setBackgroundColor(0.0f, 0, 0);
        //window.setFullscreen(true);
        window.create();
        //mesh.create();
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
        //System.out.println("Update");
        mainRenderer.mainController.update();
        window.update();
    }

    private void render() {
        //System.out.println("Render");
        //renderer.renderMesh(mesh);
//        glBegin(GL_LINES);
//        glVertex3f(0.0f, 0.0f, 0.0f);
//        glVertex3f(0.1f, 0.0f, 0.0f);
//        glVertex3f(0.0f, 0.0f, 0.0f);
//        glVertex3f(0.0f, 0.1f, 0.0f);
//        glEnd();
        mainRenderer.render();
        window.swapBuffers();
    }

    public static void main(String[] args) {
        System.out.println("START");
        new Main().start();
    }
}
