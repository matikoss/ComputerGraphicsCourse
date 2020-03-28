package engine.geometry;

import engine.maths.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
    private float sizeX, sizeY, sizeZ;
    private Vector3f startingPoint;
    private Vector3f rotation;
    private Vector3f scale;
    private List<Line3d> cuboidLines;

    public Cuboid(float sizeX, float sizeY, float sizeZ, Vector3f startingPoint, Vector3f rotation, Vector3f scale) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;

        this.startingPoint = startingPoint;
        this.rotation = rotation;
        this.scale = scale;

        initLines();
    }

    private void initLines() {
        cuboidLines = new ArrayList<>();
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY(), startingPoint.getZ(), startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ()));
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY(), startingPoint.getZ(), startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ()));
        cuboidLines.add(new Line3d(startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ(), startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ()));
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ(), startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ()));

        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY(), startingPoint.getZ(), startingPoint.getX(), startingPoint.getY(), startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ(), startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ(), startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ(), startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ));

        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY(), startingPoint.getZ() + sizeZ, startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY(), startingPoint.getZ() + sizeZ, startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX() + sizeX, startingPoint.getY(), startingPoint.getZ() + sizeZ, startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ));
        cuboidLines.add(new Line3d(startingPoint.getX(), startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ, startingPoint.getX() + sizeX, startingPoint.getY() + sizeY, startingPoint.getZ() + sizeZ));
    }

    public void update() {

    }

    public List<Line3d> getCuboidLines() {
        return cuboidLines;
    }

    public Vector3f getRotation() {
        return rotation;
    }

    public Vector3f getScale() {
        return scale;
    }
}
