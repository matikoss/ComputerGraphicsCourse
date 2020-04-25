package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.List;

public class Cuboid {
    private Vector3 position;
    private Vector3 size;
    private List<Rectangle> rectangles;

    public Cuboid(Vector3 position, List<Rectangle> rectangles) {
        this.position = position;
        this.rectangles = rectangles;
    }

    public Cuboid(Vector3 position, Vector3 size) {
        rectangles = new ArrayList<>();
        Rectangle tmpRect = new Rectangle(position, new Vector3(size.x, size.y, 0f), 255, 0, 0);
        rectangles.add(tmpRect);
        tmpRect = new Rectangle(position, new Vector3(0f, size.y, size.z), 0, 255, 0);
        rectangles.add(tmpRect);
        tmpRect = new Rectangle(position, new Vector3(size.x, 0f, size.z), 0, 0, 255);
        rectangles.add(tmpRect);
        tmpRect = new Rectangle(new Vector3(position.x + size.x, position.y, position.z), new Vector3(0f, size.y, size.z), 255, 255, 0);
        rectangles.add(tmpRect);
        tmpRect = new Rectangle(new Vector3(position.x, position.y, position.z + size.z), new Vector3(size.x, size.y, 0f), 0, 255, 255);
        rectangles.add(tmpRect);
        tmpRect = new Rectangle(new Vector3(position.x, position.y + size.y, position.z), new Vector3(size.x, 0f, size.z), 255, 0, 255);
        rectangles.add(tmpRect);

    }

    public Vector3 getPosition() {
        return position;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }

    public void setRectangles(List<Rectangle> rectangles) {
        this.rectangles = rectangles;
    }
}
