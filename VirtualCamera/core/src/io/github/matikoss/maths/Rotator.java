package io.github.matikoss.maths;

public class Rotator {
    public static void rotateAxisX(float angle, Vector3f vector) {
        Vector3f tmpVector = new Vector3f(vector.getX(), vector.getY(), vector.getZ());
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        vector.setY(cos * tmpVector.getY() - sin * tmpVector.getZ());
        vector.setZ(sin * tmpVector.getY() + cos * tmpVector.getZ());
    }

    public static void rotateAxisY(double angle, Vector3f vector) {
        Vector3f tmpVector = new Vector3f(vector.getX(), vector.getY(), vector.getZ());
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        vector.setX(cos * tmpVector.getX() + sin * tmpVector.getZ());
        vector.setZ(-sin * tmpVector.getX() + cos * tmpVector.getZ());
    }

    public static void rotateAxisZ(double angle, Vector3f vector) {
        Vector3f tmpVector = new Vector3f(vector.getX(), vector.getY(), vector.getZ());
        float sin = (float) Math.sin(angle);
        float cos = (float) Math.cos(angle);
        vector.setX(cos * tmpVector.getX() - sin * tmpVector.getY());
        vector.setY(sin * tmpVector.getX() + cos * tmpVector.getY());
    }
}
