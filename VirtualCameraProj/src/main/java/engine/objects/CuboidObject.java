package engine.objects;

import engine.geometry.Cuboid;
import engine.maths.Vector3f;

public class CuboidObject {
    private Cuboid cuboid;
    private Vector3f position, rotation, scale;

    public CuboidObject(Cuboid cuboid, Vector3f position, Vector3f rotation, Vector3f scale) {
        this.cuboid = cuboid;
        this.position = position;
        this.rotation = rotation;
        this.scale = scale;
    }
}
