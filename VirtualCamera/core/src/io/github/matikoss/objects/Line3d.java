package io.github.matikoss.objects;

import io.github.matikoss.maths.Vector3f;

public class Line3d {
    private Vector3f startingPoint, endingPoint;

    public Line3d(Vector3f startingPoint, Vector3f endingPoint) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public Line3d(float stX, float stY, float stZ, float enX, float enY, float enZ) {
        this.startingPoint = new Vector3f(stX, stY, stZ);
        this.endingPoint = new Vector3f(enX, enY, enZ);
    }

    public Vector3f getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Vector3f startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Vector3f getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Vector3f endingPoint) {
        this.endingPoint = endingPoint;
    }
}
