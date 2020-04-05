package core.Renderers;

import core.Controllers.MainController;
import engine.geometry.Cuboid;
import engine.geometry.Line3d;
import engine.maths.Matrix4f;
import engine.maths.Vector3f;
import engine.maths.Vector4f;
import org.lwjgl.opengl.GL11;

public class MainRenderer {
    public MainController mainController;
    private float width, height;
    private Matrix4f projection;
    private Matrix4f viewport;
    private Matrix4f finalMatrix;

    public MainRenderer(float width, float height) {
        mainController = new MainController();
        this.width = width;
        this.height = height;
//        projection = Matrix4f.projection(70.0f, 16.0f / 9.0f, 0.01f, 1000.0f);
//        viewport = Matrix4f.viewport(1.0f, 1.0f);
//        finalMatrix = Matrix4f.multiply(projection, viewport);
        projection = Matrix4f.perspectiveMatrix(-1.0f, 1.0f, 1.0f, -1.0f, 0.5f, 100.0f);
        viewport = Matrix4f.viewport(2.0f, 2.0f);
        finalMatrix = Matrix4f.multiply(projection, viewport);
    }

    public void render() {
        renderCuboids();
    }

    private void renderCuboids() {
        for (Cuboid cuboidToDraw : mainController.getCuboidsList()) {
            drawCuboid(cuboidToDraw);
        }
    }

    private void drawCuboid(Cuboid cuboid) {
        for (Line3d lineToDraw : cuboid.getCuboidLines()) {
            Vector4f startTmpVec = new Vector4f(lineToDraw.getStartingPoint(), 1.0f);
            Vector4f endTmpVec = new Vector4f(lineToDraw.getEndingPoint(), 1.0f);
            Vector4f tmpStartPointProjection = Matrix4f.matrixMultiplyVector(finalMatrix, startTmpVec);
            Vector4f tmpEndPointProjection = Matrix4f.matrixMultiplyVector(finalMatrix, endTmpVec);
//            Vector3f tmpStartPointView = Matrix4f.matrixMultiplyVector(viewport, tmpStartPointProjection);
//            Vector3f tmpEndPointView = Matrix4f.matrixMultiplyVector(viewport, tmpEndPointProjection);

            drawLine4f(tmpStartPointProjection, tmpEndPointProjection, cuboid.getR(), cuboid.getG(), cuboid.getB());
//            drawLine(Matrix4f.matrixMultiplyVector(projection, lineToDraw.getStartingPoint()), Matrix4f.matrixMultiplyVector(projection, lineToDraw.getEndingPoint()));
//            drawLine(lineToDraw.getStartingPoint(), lineToDraw.getEndingPoint());
//            drawLine(tmpStartPointView, tmpEndPointView);
        }
    }

    private void drawLine(Vector3f start, Vector3f end) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex2f(start.getX(), start.getY());
        GL11.glVertex2f(end.getX(), end.getY());
        GL11.glEnd();
    }

    private void drawLine4f(Vector4f start, Vector4f end, int r, int g, int b) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glColor3f(r, g, b);
        GL11.glVertex2f(start.getX() / start.getW(), start.getY() / start.getW());
        GL11.glVertex2f(end.getX() / end.getW(), end.getY() / end.getW());
        GL11.glEnd();
    }

    public Matrix4f getProjection() {
        return projection;
    }
}
