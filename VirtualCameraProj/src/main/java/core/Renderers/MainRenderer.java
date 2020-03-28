package core.Renderers;

import core.Controllers.MainController;
import engine.geometry.Cuboid;
import engine.geometry.Line3d;
import engine.maths.Matrix4f;
import engine.maths.Vector3f;
import org.lwjgl.opengl.GL11;

public class MainRenderer {
    public MainController mainController;
    private float width, height;
    private Matrix4f projection;

    public MainRenderer(float width, float height) {
        mainController = new MainController();
        this.width = width;
        this.height = height;
        projection = Matrix4f.projection(70.0f, this.width / this.height, 0.1f, 1000.0f);
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
            Vector3f tmpStartPointProjection = Matrix4f.matrixMultiplyVector(projection, lineToDraw.getStartingPoint());
            Vector3f tmpEndPointProjection = Matrix4f.matrixMultiplyVector(projection, lineToDraw.getEndingPoint());
            drawLine(tmpStartPointProjection, tmpEndPointProjection);
//            drawLine(Matrix4f.matrixMultiplyVector(projection, lineToDraw.getStartingPoint()), Matrix4f.matrixMultiplyVector(projection, lineToDraw.getEndingPoint()));
//            drawLine(lineToDraw.getStartingPoint(), lineToDraw.getEndingPoint());
        }
    }

    private void drawLine(Vector3f start, Vector3f end) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3f(start.getX(), start.getY(), start.getZ());
        GL11.glVertex3f(end.getX(), end.getY(), end.getZ());
        GL11.glEnd();
    }

    public Matrix4f getProjection() {
        return projection;
    }
}
