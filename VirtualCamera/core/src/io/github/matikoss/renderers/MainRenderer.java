package io.github.matikoss.renderers;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.matikoss.controllers.MainController;
import io.github.matikoss.maths.Matrix4f;
import io.github.matikoss.maths.Vector3f;
import io.github.matikoss.maths.Vector4f;
import io.github.matikoss.objects.Cuboid;
import io.github.matikoss.objects.Line3d;

public class MainRenderer {
    private MainController mainController;
    private ShapeRenderer shapeRenderer;
    private Matrix4f perspective;
    private Matrix4f viewport;
    private Matrix4f finalMatrix;

    public MainRenderer(MainController mainController) {
        this.mainController = mainController;
        init();
    }

    private void init() {
        shapeRenderer = new ShapeRenderer();
        perspective = Matrix4f.perspectiveMatrix(720.0f, 0.0f, 0.0f, 1280.0f, 900.0f, 1000.0f);
        viewport = Matrix4f.viewport(1280.0f, 720.0f);
        finalMatrix = Matrix4f.multiply(perspective, viewport);
    }

    public void render() {
        renderCuboids();
    }

    public void dispose() {
        shapeRenderer.dispose();
    }

    public void resize(int width, int height) {

    }

    public void update() {

    }

    private void renderCuboids() {
        for (Cuboid cuboid : mainController.getCuboidList()) {
            drawCuboid(cuboid);
        }
    }

    private void drawCuboid(Cuboid cuboid) {
        for (Line3d line : cuboid.getCuboidLines()) {
            Vector4f startTmpVec = new Vector4f(line.getStartingPoint(), 1.0f);
            Vector4f endTmpVec = new Vector4f(line.getEndingPoint(), 1.0f);
            Vector4f startToDraw = Matrix4f.matrixMultiplyVector(finalMatrix, startTmpVec);
            Vector4f endToDraw = Matrix4f.matrixMultiplyVector(finalMatrix, endTmpVec);
            drawLine4f(startToDraw, endToDraw);
        }
    }

    private void drawLine(Vector3f start, Vector3f end) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255, 255, 255, 1);
        shapeRenderer.line(start.getX(), start.getY(), end.getX(), end.getY());
        shapeRenderer.end();
    }

    private void drawLine4f(Vector4f start, Vector4f end) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255, 255, 255, 1);
        shapeRenderer.line(start.getX() / start.getW(), start.getY() / start.getW(), end.getX() / end.getW(), end.getY() / end.getW());
        shapeRenderer.end();
    }


}
