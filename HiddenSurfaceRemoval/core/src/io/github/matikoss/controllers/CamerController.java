package io.github.matikoss.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

public class CamerController {
    private PerspectiveCamera camera;
    private Vector3 tmp = new Vector3();
    private Quaternion q = new Quaternion();
    private Matrix4 mtx = new Matrix4();

    public CamerController(PerspectiveCamera camera) {
        this.camera = camera;
    }

    public void update() {
        checkCameraInput();
        camera.update();
    }

    private void checkCameraInput() {
        float transStep = 0.1f;
        float rotStep = 0.1f;
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            tmp.set(camera.direction);
            camera.position.add(tmp.nor().scl(transStep));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            tmp.set(camera.direction);
            camera.position.add(tmp.nor().scl(-transStep));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            tmp.set(camera.direction);
            camera.position.add(tmp.crs(camera.up).nor().scl(-transStep));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tmp.set(camera.direction);
            camera.position.add(tmp.crs(camera.up).nor().scl(transStep));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            tmp.set(camera.direction);
            camera.position.add(tmp.crs(camera.up).nor().scl(transStep));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)) {
            tmp.set(camera.up).nor();
            tmp.scl(transStep);
            camera.position.add(tmp);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT)) {
            tmp.set(camera.up).nor().scl(-1f);
            tmp.scl(transStep);
            camera.position.add(tmp);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            camera.view.getRotation(q);
            q.setEulerAngles(-rotStep, 0f, 0f);
            mtx.set(q);
            camera.direction.prj(mtx);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            camera.view.getRotation(q);
            q.setEulerAngles(rotStep, 0f, 0f);
            mtx.set(q);
            camera.direction.prj(mtx);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.R)) {
            tmp.set(camera.direction);
            camera.direction.rotate(tmp.crs(camera.up), rotStep);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.F)) {
            tmp.set(camera.direction);
            camera.direction.rotate(tmp.crs(camera.up), -rotStep);
        }
    }
}
