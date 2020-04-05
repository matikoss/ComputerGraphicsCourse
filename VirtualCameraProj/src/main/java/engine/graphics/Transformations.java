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

    public static void GoForward(Vector3f vector) {
        vector.setZ(vector.getZ() + 0.01f);
    }

    public static void GoBackward(Vector3f vector) {
        vector.setZ(vector.getZ() - 0.01f);
    }

    public static void rotateRight(Vector3f vector) {
        Rotator.rotateAxisY(0.01f, vector);
    }

    public static void rotateLeft(Vector3f vector) {
        Rotator.rotateAxisY(-0.01f, vector);
    }

    public static void rotateTop(Vector3f vector) {
        Rotator.rotateAxisX(0.01f, vector);
    }

    public static void rotateBottom(Vector3f vector) {
        Rotator.rotateAxisX(-0.01f, vector);
    }

    public static void rotateWheelRight(Vector3f vector) {
        Rotator.rotateAxisZ(0.01f, vector);
    }

    public static void rotateWheelLeft(Vector3f vector) {
        Rotator.rotateAxisZ(-0.01f, vector);
    }

    public static void zoomIn(Vector3f vector) {
        Vector4f tmpVector = new Vector4f(vector, 1.0f);
        Vector4f result = Matrix4f.matrixMultiplyVector(Matrix4f.zoom(1.1f), tmpVector);
        vector.set(result.getX(), result.getY(), result.getZ());
    }

    public static void zoomOut(Vector3f vector) {
        Vector4f tmpVector = new Vector4f(vector, 1.0f);
        Vector4f result = Matrix4f.matrixMultiplyVector(Matrix4f.zoom(0.9f), tmpVector);
        vector.set(result.getX(), result.getY(), result.getZ());
    }

}
