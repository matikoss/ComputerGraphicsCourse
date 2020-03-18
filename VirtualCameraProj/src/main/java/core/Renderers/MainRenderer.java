package core.Renderers;

import core.Controllers.MainController;
import engine.geometry.Cuboid;
import engine.geometry.Line3d;
import engine.maths.Vector3f;
import org.lwjgl.opengl.GL11;

public class MainRenderer {
    public MainController mainController;

    public MainRenderer() {
        mainController = new MainController();
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
            drawLine(lineToDraw.getStartingPoint(), lineToDraw.getEndingPoint());
        }
    }

    private void drawLine(Vector3f start, Vector3f end) {
        GL11.glBegin(GL11.GL_LINES);
        GL11.glVertex3f(start.getX(), start.getY(), start.getZ());
        GL11.glVertex3f(end.getX(), end.getY(), end.getZ());
        GL11.glEnd();
    }
}
