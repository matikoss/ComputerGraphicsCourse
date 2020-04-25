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
//        List<Line3d> tmp = new ArrayList<>();
//        tmp.add(new Line3d(new Vector3(-10f, -10f, 0f), new Vector3(10f, -10f, 0f)));
//        tmp.add(new Line3d(new Vector3(10f, -10f, 0f), new Vector3(10f, 10f, 0f)));
//        tmp.add(new Line3d(new Vector3(10f, 10f, 0f), new Vector3(-10f, 10f, 0f)));
//        tmp.add(new Line3d(new Vector3(-10f, 10f, 0f), new Vector3(-10f, -10, 0f)));
//        polygons.add(new Polygon(new Vector3(-10f, -10f, 0f), tmp));
//        tmp = new ArrayList<>();
//        tmp.add(new Line3d(new Vector3(40f, 40f, 100f), new Vector3(50f, 50f, 100f)));
//        tmp.add(new Line3d(new Vector3(50f, 50f, 100f), new Vector3(50f, 60f, 100f)));
//        tmp.add(new Line3d(new Vector3(50f, 60f, 100f), new Vector3(60f, 60f, 100f)));
//        tmp.add(new Line3d(new Vector3(60f, 60f, 100f), new Vector3(75f, 65f, 100f)));
//        tmp.add(new Line3d(new Vector3(75f, 65f, 100f), new Vector3(40f, 40f, 100f)));
//        polygons.add(new Polygon(new Vector3(40f, 40f, 100f), tmp));
//        Rectangle rectangle = new Rectangle(
//                new Vector3(20f, 20f, 10f),
//                new Vector3(30f, 20f, 10f),
//                new Vector3(30f, 30f, 10f),
//                new Vector3(20f, 30f, 10f),
//                255, 255, 255
//        );
//        rectangles.add(rectangle);
//        rectangle = new Rectangle(new Vector3(50f, 50f, 50f), new Vector3(30f, 30f, 0f), 100, 100, 100);
//        rectangles.add(rectangle);
//        rectangle = new Rectangle(new Vector3(80, 50, 50), new Vector3(0f, 30f, 30f), 50, 50, 50);
//        rectangles.add(rectangle);
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
