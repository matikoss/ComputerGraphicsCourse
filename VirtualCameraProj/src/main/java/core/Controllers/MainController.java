package core.Controllers;

import engine.geometry.Cuboid;
import engine.geometry.Line3d;
import engine.graphics.Transformations;
import engine.io.Input;
import engine.maths.Vector3f;
import org.lwjgl.glfw.GLFW;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<Cuboid> cuboidsList;

    public MainController() {
        cuboidsList = new ArrayList<>();
        cuboidsList.add(new Cuboid(0.5f, 0.5f, 0.5f, new Vector3f(0.0f, 0.0f, 0.0f)));
    }

    public void update() {
        checkInput();
    }

    public List<Cuboid> getCuboidsList() {
        return cuboidsList;
    }

    private void checkInput() {
        if(Input.isKeyDown(GLFW.GLFW_KEY_W)){
            for(Cuboid cuboidToTranslate : cuboidsList){
                for(Line3d lineToTranslate : cuboidToTranslate.getCuboidLines()){
                    Transformations.TranslateUp(lineToTranslate.getStartingPoint());
                    Transformations.TranslateUp(lineToTranslate.getEndingPoint());
                }
            }
        }
        if(Input.isKeyDown(GLFW.GLFW_KEY_S)){

        }
        if(Input.isKeyDown(GLFW.GLFW_KEY_A)){

        }
        if(Input.isKeyDown(GLFW.GLFW_KEY_D)){

        }
    }

}
