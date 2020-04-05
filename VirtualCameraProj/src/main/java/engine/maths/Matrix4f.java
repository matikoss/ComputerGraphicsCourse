package engine.maths;

import java.util.Arrays;

public class Matrix4f {
    public static final int SIZE = 4;
    private float[] elements = new float[SIZE * SIZE];

    public static Matrix4f identity() {
        Matrix4f result = new Matrix4f();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result.set(i, j, 0);
            }
        }

        result.set(0, 0, 1);
        result.set(1, 1, 1);
        result.set(2, 2, 1);
        result.set(3, 3, 1);

        return result;
    }

    public static Matrix4f translate(Vector3f translate) {
        Matrix4f result = Matrix4f.identity();

        result.set(3, 0, translate.getX());
        result.set(3, 1, translate.getY());
        result.set(3, 2, translate.getZ());

        return result;
    }

    public static Matrix4f rotate(float angle, Vector3f axis) {
        Matrix4f result = Matrix4f.identity();

        float cos = (float) Math.cos(Math.toRadians(angle));
        float sin = (float) Math.sin(Math.toRadians(angle));
        float C = 1 - cos;


        result.set(0, 0, cos + axis.getX() * axis.getX() * C);
        result.set(0, 1, axis.getX() * axis.getY() * C - axis.getZ() * sin);
        result.set(0, 2, axis.getX() * axis.getZ() * C + axis.getY() * sin);
        result.set(1, 0, axis.getY() * axis.getX() * C + axis.getZ() * sin);
        result.set(1, 1, cos + axis.getY() * axis.getY() * C);
        result.set(1, 2, axis.getY() * axis.getZ() * C - axis.getX() * sin);
        result.set(2, 0, axis.getZ() * axis.getX() * C - axis.getY() * sin);
        result.set(2, 1, axis.getZ() * axis.getY() * C + axis.getX() * sin);
        result.set(2, 2, cos + axis.getZ() * axis.getZ() * C);

        return result;
    }

    public static Matrix4f scale(Vector3f scaler) {
        Matrix4f result = Matrix4f.identity();

        result.set(0, 0, scaler.getX());
        result.set(1, 1, scaler.getY());
        result.set(2, 2, scaler.getZ());

        return result;
    }

    public static Matrix4f transform(Vector3f position, Vector3f rotation, Vector3f scale) {
        Matrix4f result = Matrix4f.identity();

        Matrix4f translationMatrix = Matrix4f.translate(position);
        Matrix4f rotXMatrix = Matrix4f.rotate(rotation.getX(), new Vector3f(1, 0, 0));
        Matrix4f rotYMatrix = Matrix4f.rotate(rotation.getY(), new Vector3f(0, 1, 0));
        Matrix4f rotZMatrix = Matrix4f.rotate(rotation.getZ(), new Vector3f(0, 0, 1));
        Matrix4f scaleMatrix = Matrix4f.scale(scale);

        Matrix4f rotationMatrix = Matrix4f.multiply(rotXMatrix, Matrix4f.multiply(rotYMatrix, rotZMatrix));
        result = Matrix4f.multiply(translationMatrix, Matrix4f.multiply(rotationMatrix, scaleMatrix));

        return result;
    }

    public static Matrix4f projection(float fov, float aspect, float near, float far) {
        Matrix4f result = Matrix4f.identity();

        float tanFOV = (float) Math.tan(Math.toRadians(fov / 2));
        float range = far - near;

        result.set(0, 0, 1.0f / (aspect * tanFOV));
        result.set(1, 1, 1.0f / tanFOV);
        result.set(2, 2, -((far + near) / range));
        result.set(2, 3, -1.0f);
        result.set(3, 2, -((2 * far * near) / range));
        result.set(3, 3, 0.0f);


        return result;
    }

    public static Matrix4f perspectiveMatrix(float top, float bottom, float left, float right, float near, float far) {
        Matrix4f result = Matrix4f.identity();

        result.set(0, 0, 2 * near / (right - left));
        result.set(0, 2, (left + right) / (left - right));
        result.set(1, 1, 2 * near / (top - bottom));
        result.set(1, 2, (bottom + top) / (bottom - top));
        result.set(2, 2, (far + near) / (near - far));
        result.set(2, 3, (2 * far * near) / (far - near));
        result.set(3, 2, 1);
        result.set(3, 3, 0);

        return result;

    }

    public static Matrix4f viewport(float nx, float ny) {
        Matrix4f result = Matrix4f.identity();
        result.set(0, 0, nx / 2);
        result.set(0, 3, (nx - 1) / 2);
        result.set(1, 1, ny / 2);
        result.set(1, 3, (ny - 1) / 2);

        return result;
    }

    public static Matrix4f zoom(float value) {
        Matrix4f result = Matrix4f.identity();
        result.set(0, 0, value);
        result.set(1, 1, value);
        return result;
    }

    public static Matrix4f view(Vector3f position, Vector3f rotation) {
        Matrix4f result = Matrix4f.identity();

        Vector3f negative = new Vector3f(-position.getX(), -position.getY(), -position.getZ());

        Matrix4f translationMatrix = Matrix4f.translate(negative);
        Matrix4f rotXMatrix = Matrix4f.rotate(rotation.getX(), new Vector3f(1, 0, 0));
        Matrix4f rotYMatrix = Matrix4f.rotate(rotation.getY(), new Vector3f(0, 1, 0));
        Matrix4f rotZMatrix = Matrix4f.rotate(rotation.getZ(), new Vector3f(0, 0, 1));

        Matrix4f rotationMatrix = Matrix4f.multiply(rotZMatrix, Matrix4f.multiply(rotYMatrix, rotXMatrix));

        result = Matrix4f.multiply(translationMatrix, rotationMatrix);

        return result;
    }

    public static Matrix4f multiply(Matrix4f matrix, Matrix4f other) {
        Matrix4f result = Matrix4f.identity();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result.set(i, j, matrix.get(i, 0) * other.get(0, j) +
                        matrix.get(i, 1) * other.get(1, j) +
                        matrix.get(i, 2) * other.get(2, j) +
                        matrix.get(i, 3) * other.get(3, j));
            }
        }

        return result;
    }

    public static Vector4f matrixMultiplyVector(Matrix4f matrix4f, Vector4f vector4f) {
        Vector4f result = new Vector4f(vector4f.getX(), vector4f.getY(), vector4f.getZ(), vector4f.getW());

        Vector4f tmpVec = new Vector4f(vector4f.getX(), vector4f.getY(), vector4f.getZ(), vector4f.getW());
        Vector4f resultTmp = new Vector4f(1.0f, 1.0f, 1.0f, 1.0f);

        resultTmp.setX(matrix4f.get(0, 0) * tmpVec.getX() + matrix4f.get(0, 1) * tmpVec.getY() + matrix4f.get(0, 2) * tmpVec.getZ() + matrix4f.get(0, 3) * tmpVec.getW());
        resultTmp.setY(matrix4f.get(1, 0) * tmpVec.getX() + matrix4f.get(1, 1) * tmpVec.getY() + matrix4f.get(1, 2) * tmpVec.getZ() + matrix4f.get(1, 3) * tmpVec.getW());
        resultTmp.setZ(matrix4f.get(2, 0) * tmpVec.getX() + matrix4f.get(2, 1) * tmpVec.getY() + matrix4f.get(2, 2) * tmpVec.getZ() + matrix4f.get(2, 3) * tmpVec.getW());
        resultTmp.setW(matrix4f.get(3, 0) * tmpVec.getX() + matrix4f.get(3, 1) * tmpVec.getY() + matrix4f.get(3, 2) * tmpVec.getZ() + matrix4f.get(3, 3) * tmpVec.getW());

        result.set(resultTmp.getX(), resultTmp.getY(), resultTmp.getZ(), resultTmp.getW());

        return result;
    }

    public float get(int x, int y) {
        return elements[y * SIZE + x];
    }

    public void set(int x, int y, float value) {
        elements[y * SIZE + x] = value;
    }

    public float[] getAll() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix4f matrix4f = (Matrix4f) o;
        return Arrays.equals(elements, matrix4f.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
