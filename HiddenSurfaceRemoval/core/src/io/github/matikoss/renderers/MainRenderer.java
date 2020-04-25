package io.github.matikoss.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import io.github.matikoss.controllers.CamerController;
import io.github.matikoss.controllers.MainController;
import io.github.matikoss.objects.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainRenderer {
    private MainController controller;
    private CamerController camerController;
    private PerspectiveCamera camera;
    private ShapeRenderer shapeRenderer;
    private PolygonSprite poly;
    PolygonSpriteBatch polyBatch;
    Texture textureSolid;

    public MainRenderer(MainController controller) {
        this.controller = controller;
        shapeRenderer = new ShapeRenderer();
        initCamera();
        camerController = new CamerController(camera);
        polyBatch = new PolygonSpriteBatch();
    }

    private void initCamera() {
        camera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(0f, 0f, -50f);
        camera.lookAt(0f, 0f, 0f);
        camera.near = 0.01f;
        camera.far = 1000f;
        camera.update();
    }

    public void render() {
//        renderPolygons();
        renderRectangles();
//        renderCuboids();
    }

    public void update() {
        camerController.update();
        for (Rectangle rectangle : controller.rectangles) {
            rectangle.calculateDistanceFromCamera(camera.position);
        }
        Collections.sort(controller.rectangles, Collections.reverseOrder());
    }

    public void dispose() {
        shapeRenderer.dispose();
        polyBatch.dispose();
    }

    private void renderPolygons() {
        for (Polygon polygon : controller.polygons) {
            drawPolygon(polygon);
        }
    }


    private void drawPolygon(Polygon polygon) {
        for (Line3d line : polygon.getLines()) {
            Vector3 startTmp = new Vector3(line.getStart());
            Vector3 endTmp = new Vector3(line.getEnd());
            camera.project(startTmp);
            camera.project(endTmp);
            drawLine2d(startTmp, endTmp);
        }
    }


    private void drawLine2d(Vector3 start, Vector3 end) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(255, 255, 255, 1);
        shapeRenderer.line(start.x, start.y, end.x, end.y);
        shapeRenderer.end();
    }

    private void renderRectangles() {
        for (Rectangle rectangle : controller.rectangles) {
            drawFilledRectangle(rectangle);
        }
    }

    private void renderCuboids() {
        for (Cuboid cuboid : controller.cuboids) {
            for (Rectangle rectangle : cuboid.getRectangles()) {
                drawFilledRectangle(rectangle);
            }
        }
    }

    private void drawFilledRectangle(Rectangle rectangle) {
        Vector3 v1, v2, v3, v4;
        v1 = new Vector3(rectangle.v00);
        v2 = new Vector3(rectangle.v10);
        v3 = new Vector3(rectangle.v11);
        v4 = new Vector3(rectangle.v01);
        camera.project(v1);
        camera.project(v2);
        camera.project(v3);
        camera.project(v4);
        Pixmap pix = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        pix.setColor(new Color(rectangle.r, rectangle.g, rectangle.b, 1));
        pix.fill();
        textureSolid = new Texture(pix);
        PolygonRegion polyReg = new PolygonRegion(new TextureRegion(textureSolid),
                new float[]{
                        v1.x, v1.y,
                        v2.x, v2.y,
                        v3.x, v3.y,
                        v4.x, v4.y
                },
                new short[]{
                        0, 1, 2,
                        1, 3, 2
                }
        );
        poly = new PolygonSprite(polyReg);
        polyBatch.begin();
        poly.draw(polyBatch);
        polyBatch.end();
    }
}
