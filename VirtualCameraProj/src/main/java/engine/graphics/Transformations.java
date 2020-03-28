package engine.graphics;

import engine.maths.Matrix4f;
import engine.maths.Rotator;
import engine.maths.Vector3f;
import engine.maths.Vector4f;

public class Transformations {
    public static void TranslateRight(Vector3f vector) {
        vector.setX(vector.getX() + 0.01f);
    }

    public static void TranslateLeft(Vector3f vector) {
        vector.setX(vector.getX() - 0.01f);
    }

    public static void TranslateUp(Vector3f vector) {
        vector.setY(vector.getY() + 0.01f);
    }

    public static void TranslateDown(Vector3f vector) {
        vector.setY(vector.getY() - 0.01f);
    }

    public static void rotateRight(Vector3f vector) {
        Rotator.rotateAxisY(0.01f, vector);
    }

    public static void rotateLeft(Vector3f vector) {
        Rotator.rotateAxisY(-0.01f, vector);
    }

}
