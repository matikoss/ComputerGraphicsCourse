package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

public class Sphere {
    private Vector3 position;
    private float radius;

    public Sphere(Vector3 position, float radius) {
        this.position = position;
        this.radius = radius;
    }

    public Vector3 getPosition() {
        return position;
    }

    public float getRadius() {
        return radius;
    }
}
