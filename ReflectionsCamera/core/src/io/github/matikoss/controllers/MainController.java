package io.github.matikoss.controllers;

import com.badlogic.gdx.math.Vector3;
import io.github.matikoss.objects.*;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public List<Polygon> polygons;
    public List<Cuboid> cuboids;
    public List<Rectangle> rectangles;
    public List<Sphere> spheres;

    public MainController() {
        polygons = new ArrayList<>();
        rectangles = new ArrayList<>();
        cuboids = new ArrayList<>();
        spheres = new ArrayList<>();
        cuboids.add(new Cuboid(new Vector3(20f, 0f, 20f), new Vector3(20f, 20f, 20f)));
        cuboids.add(new Cuboid(new Vector3(-20f, 0f, 20f), new Vector3(20f, 20f, 20f)));
        cuboids.add(new Cuboid(new Vector3(20f, 0f, 60f), new Vector3(20f, 60f, 20f)));
        cuboids.add(new Cuboid(new Vector3(-20f, 0f, 60f), new Vector3(20f, 40f, 20f)));
        spheres.add(new Sphere(new Vector3(40f, 20f, 20f), 5f));
        for (Cuboid cuboid : cuboids) {
            rectangles.addAll(cuboid.getRectangles());
        }
    }

    public void update() {

    }
}
