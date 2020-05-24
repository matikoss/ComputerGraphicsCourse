package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

public class Line3d {
    private Vector3 start;
    private Vector3 end;

    public Line3d(Vector3 start, Vector3 end) {
        this.start = start;
        this.end = end;
    }

    public Vector3 getStart() {
        return start;
    }

    public void setStart(Vector3 start) {
        this.start = start;
    }

    public Vector3 getEnd() {
        return end;
    }

    public void setEnd(Vector3 end) {
        this.end = end;
    }
}
