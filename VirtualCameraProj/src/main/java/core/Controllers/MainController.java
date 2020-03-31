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
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(-0.25f, -0.25f, -20.0f)));
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(-1.00f, -0.25f, -20.0f)));
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(-0.25f, -0.25f, -21.0f)));
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(-1.00f, -0.25f, -21.0f)));
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
        if (Input.isKeyDown(GLFW.GLFW_KEY_R)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateBottom(lineToTranslate.getStartingPoint());
                    Transformations.rotateBottom(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_F)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateTop(lineToTranslate.getStartingPoint());
                    Transformations.rotateTop(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_Z)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateWheelRight(lineToTranslate.getStartingPoint());
                    Transformations.rotateWheelRight(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_X)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateWheelLeft(lineToTranslate.getStartingPoint());
                    Transformations.rotateWheelLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_T)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.zoomIn(lineToTranslate.getStartingPoint());
                    Transformations.zoomIn(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Input.isKeyDown(GLFW.GLFW_KEY_G)) {
            for (Cuboid cuboidToTranslate : cuboidsList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.zoomOut(lineToTranslate.getStartingPoint());
                    Transformations.zoomOut(lineToTranslate.getEndingPoint());
                }
            }
        }
    }

}
