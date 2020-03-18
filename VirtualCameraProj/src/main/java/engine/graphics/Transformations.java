package engine.graphics;

import engine.maths.Vector3f;

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
}
