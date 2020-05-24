package io.github.matikoss.objects;

import com.badlogic.gdx.math.Vector3;

public class SceneElement implements Comparable<SceneElement> {
    public Vector3 avgPosition;
    public float avgDistanceFromCamera;

    public void calculateDistanceFromCamera(Vector3 cameraPosition) {
        float tmpX, tmpY, tmpZ;
        tmpX = cameraPosition.x - avgPosition.x;
        tmpY = cameraPosition.y - avgPosition.y;
        tmpZ = cameraPosition.z - avgPosition.z;
        avgDistanceFromCamera = (float) Math.sqrt(
                Math.pow(tmpX, 2) + Math.pow(tmpY, 2) + Math.pow(tmpZ, 2)
        );
    }

    @Override
    public int compareTo(SceneElement sceneElement) {
        if (this.avgDistanceFromCamera > sceneElement.avgDistanceFromCamera) {
            return 1;
        } else if (this.avgDistanceFromCamera < sceneElement.avgDistanceFromCamera) {
            return -1;
        } else {
            return 1;
        }
    }
}
