package core.Controllers;

import engine.geometry.Cuboid;
import engine.geometry.Line3d;
import engine.graphics.Transformations;
import engine.io.Input;
import engine.maths.Vector3f;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<Cuboid> cuboidsList;

    public MainController() {
        cuboidsList = new ArrayList<>();
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(-0.25f, -0.25f, -1.0f),
                new Vector3f(0, 0, 0), new Vector3f(1, 1, 1)));
    }

    public void update() {
        checkInput();
        for (Cuboid c : cuboidsList) {
            c.update();
        }
    }

    public List<Cuboid> getCuboidsList() {
        return cuboidsList;
    }

    private void checkInput() {
        if (Input.isKeyDown(GLFW.GLFW_KEY_W)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateDown(lineToTranslate.getStartingPoint());
                    Transformations.TranslateDown(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_S)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateUp(lineToTranslate.getStartingPoint());
                    Transformations.TranslateUp(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_A)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateRight(lineToTranslate.getStartingPoint());
                    Transformations.TranslateRight(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_D)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateLeft(lineToTranslate.getStartingPoint());
                    Transformations.TranslateLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_E)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateRight(lineToTranslate.getStartingPoint());
                    Transformations.rotateRight(lineToTranslate.getEndingPoint());
                }
            }
        }

        if (Input.isKeyDown(GLFW.GLFW_KEY_Q)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateLeft(lineToTranslate.getStartingPoint());
                    Transformations.rotateLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
    }

}
