package io.github.matikoss.controllers;

import com.badlogic.gdx.math.Vector3;
import io.github.matikoss.objects.Line3d;
import io.github.matikoss.objects.Polygon;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public List<Polygon> polygons;

    public MainController() {
        polygons = new ArrayList<>();
        List<Line3d> tmp = new ArrayList<>();
        tmp.add(new Line3d(new Vector3(-10f, -10f, 0f), new Vector3(10f, -10f, 0f)));
        tmp.add(new Line3d(new Vector3(10f, -10f, 0f), new Vector3(10f, 10f, 0f)));
        tmp.add(new Line3d(new Vector3(10f, 10f, 0f), new Vector3(-10f, 10f, 0f)));
        tmp.add(new Line3d(new Vector3(-10f, 10f, 0f), new Vector3(-10f, -10, 0f)));
        polygons.add(new Polygon(new Vector3(-10f, -10f, 0f), tmp));
        tmp = new ArrayList<>();
        tmp.add(new Line3d(new Vector3(40f, 40f, 100f), new Vector3(50f, 50f, 100f)));
        tmp.add(new Line3d(new Vector3(50f, 50f, 100f), new Vector3(50f, 60f, 100f)));
        tmp.add(new Line3d(new Vector3(50f, 60f, 100f), new Vector3(60f, 60f, 100f)));
        tmp.add(new Line3d(new Vector3(60f, 60f, 100f), new Vector3(75f, 65f, 100f)));
        tmp.add(new Line3d(new Vector3(75f, 65f, 100f), new Vector3(40f, 40f, 100f)));
        polygons.add(new Polygon(new Vector3(40f, 40f, 100f), tmp));

    }

    public void update() {
        System.out.println(polygons.get(0).getLines().get(0).getStart());
    }
}
