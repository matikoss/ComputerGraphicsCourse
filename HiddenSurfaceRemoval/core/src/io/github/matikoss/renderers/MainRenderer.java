package io.github.matikoss.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import io.github.matikoss.controllers.CamerController;
import io.github.matikoss.controllers.MainController;
import io.github.matikoss.objects.Line3d;
import io.github.matikoss.objects.Polygon;

public class MainRenderer {
    private MainController controller;
    private CamerController camerController;
    private PerspectiveCamera camera;
    private ShapeRenderer shapeRenderer;

    public MainRenderer(MainController controller) {
        this.controller = controller;
        shapeRenderer = new ShapeRenderer();
        camera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 0f, -50f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.01f;
        camera.far = 1000f;
        camera.update();
        camerController = new CamerController(camera);
    }

    private void init() {

    }

    public void render() {
        renderPolygons();
    }

    public void update() {
        //camera.update();
        camerController.update();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }

    private void renderPolygons() {
        for (Polygon polygon : controller.polygons) {
            drawPolygon(polygon);
        }
    }

    private void drawPolygon(Polygon polygon) {
        for (Line3d line : polygon.getLines()) {
            Vector3 startTmp = new Vector3(line.getStart());
            Vector3 endTmp = new Vector3(line.getEnd());
            camera.project(startTmp);
            camera.project(endTmp);
            drawLine2d(startTmp, endTmp);
        }
    }


    private void drawLine2d(Vector3 start, Vector3 end) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255, 255, 255, 1);
        shapeRenderer.line(start.x, start.y, end.x, end.y);
        shapeRenderer.end();
    }

}
