package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

public class Rectangle extends SceneElement {
    public Vector3 v00, v10, v01, v11;
    public int r, g, b;

    public Rectangle(Vector3 v00, Vector3 v10, Vector3 v01, Vector3 v11, int r, int g, int b) {
        super();
        this.v00 = v00;
        this.v10 = v10;
        this.v01 = v01;
        this.v11 = v11;
        this.r = r;
        this.g = g;
        this.b = b;
        calculateAvgPos();
    }

    public Rectangle(Vector3 v00, Vector3 size, int r, int g, int b) {
        super();
        this.v00 = v00;
        if (size.z == 0) {
            v10 = new Vector3(v00);
            v10.x += size.x;
            v11 = new Vector3(v00);
            v11.y += size.y;
            v01 = new Vector3(v00);
            v01.x += size.x;
            v01.y += size.y;
        }
        if (size.y == 0) {
            v10 = new Vector3(v00);
            v10.x += size.x;
            v11 = new Vector3(v00);
            v11.z += size.z;
            v01 = new Vector3(v00);
            v01.x += size.x;
            v01.z += size.z;
        }
        if (size.x == 0) {
            v10 = new Vector3(v00);
            v10.y += size.y;
            v11 = new Vector3(v00);
            v11.z += size.z;
            v01 = new Vector3(v00);
            v01.y += size.y;
            v01.z += size.z;
        }
        this.r = r;
        this.g = g;
        this.b = b;
        calculateAvgPos();
    }

    private void calculateAvgPos() {
        avgPosition = new Vector3((v00.x + v01.x + v11.x + v10.x) / 4, (v00.y + v01.y + v11.y + v10.y) / 4, (v00.z + v01.z + v11.z + v10.z) / 4);
    }

}
