package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

import java.util.List;

public class Polygon {
    private Vector3 position;
    private List<Line3d> lines;

    public Polygon(Vector3 position, List<Line3d> lines) {
        this.position = position;
        this.lines = lines;
    }

    public Vector3 getPosition() {
        return position;
    }

    public List<Line3d> getLines() {
        return lines;
    }
}
