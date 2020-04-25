package io.github.matikoss.controllers;

import com.badlogic.gdx.math.Vector3;
import io.github.matikoss.objects.*;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public List<Polygon> polygons;
    public List<Cuboid> cuboids;
    public List<Rectangle> rectangles;

    public MainController() {
        polygons = new ArrayList<>();
        rectangles = new ArrayList<>();
        cuboids = new ArrayList<>();
        rectangles.add(new Rectangle(new Vector3(-100f, -10f, 100f), new Vector3(200f, 100f, 0f), 255, 102, 102));
        rectangles.add(new Rectangle(new Vector3(100f, -10f, 20f), new Vector3(0f, 100f, 80f), 255, 102, 102));
        cuboids.add(new Cuboid(new Vector3(20f, 0f, 20), new Vector3(20f, 20f, 20f)));
        cuboids.add(new Cuboid(new Vector3(-20f, 0f, 20f), new Vector3(20f, 20f, 20f)));
        cuboids.add(new Cuboid(new Vector3(20f, 0f, 60f), new Vector3(20f, 60f, 20f)));
        cuboids.add(new Cuboid(new Vector3(-20f, 0f, 60f), new Vector3(20f, 40f, 20f)));
        for (Cuboid cuboid : cuboids) {
            rectangles.addAll(cuboid.getRectangles());
        }
    }

    public void update() {

    }
}
