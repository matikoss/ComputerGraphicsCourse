package io.github.matikoss.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import io.github.matikoss.maths.Transformations;
import io.github.matikoss.maths.Vector3f;
import io.github.matikoss.objects.Cuboid;
import io.github.matikoss.objects.Line3d;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<Cuboid> cuboidList;

    public MainController() {
        cuboidList = new ArrayList<>();
        cuboidList.add(new Cuboid(200, 200, -200, new Vector3f(300, 300, 500)));
        cuboidList.add(new Cuboid(200, 200, -200, new Vector3f(900, 300, 500)));
        cuboidList.add(new Cuboid(200, 200, -200, new Vector3f(300, 400, 800)));
        cuboidList.add(new Cuboid(200, 200, -200, new Vector3f(900, 300, 800)));
    }

    public void init() {

    }

    public void update(float deltaTime) {
        checkInput();
    }

    private void checkInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateDown(lineToTranslate.getStartingPoint());
                    Transformations.TranslateDown(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateUp(lineToTranslate.getStartingPoint());
                    Transformations.TranslateUp(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateRight(lineToTranslate.getStartingPoint());
                    Transformations.TranslateRight(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.TranslateLeft(lineToTranslate.getStartingPoint());
                    Transformations.TranslateLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateRight(lineToTranslate.getStartingPoint());
                    Transformations.rotateRight(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateLeft(lineToTranslate.getStartingPoint());
                    Transformations.rotateLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateBottom(lineToTranslate.getStartingPoint());
                    Transformations.rotateBottom(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateTop(lineToTranslate.getStartingPoint());
                    Transformations.rotateTop(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Z)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateWheelRight(lineToTranslate.getStartingPoint());
                    Transformations.rotateWheelRight(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.X)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.rotateWheelLeft(lineToTranslate.getStartingPoint());
                    Transformations.rotateWheelLeft(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.T)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.zoomIn(lineToTranslate.getStartingPoint());
                    Transformations.zoomIn(lineToTranslate.getEndingPoint());
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.G)) {
            for (Cuboid cuboidToTranslate : cuboidList) {
                for (Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()) {
                    Transformations.zoomOut(lineToTranslate.getStartingPoint());
                    Transformations.zoomOut(lineToTranslate.getEndingPoint());
                }
            }
        }

    }

    public List<Cuboid> getCuboidList() {
        return cuboidList;
    }
}
