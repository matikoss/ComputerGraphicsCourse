package engine.geometry;

import engine.maths.Vector3f;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
    private float sizeX, sizeY, sizeZ;
    private Vector3f startingPoint;
    private List<Line3d> cuboidLines;
    private int r, g, b;

    public Cuboid(float sizeX, float sizeY, float sizeZ, Vector3f startingPoint, int r, int g, int b) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;

        this.startingPoint = startingPoint;

        this.r = r;
        this.g = g;
        this.b = b;

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

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }
}
