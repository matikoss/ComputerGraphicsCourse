package io.github.matikoss.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.g3d.utils.RenderContext;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.utils.GdxRuntimeException;


public class CustomShader implements Shader {
    ShaderProgram program;
    Camera camera;
    RenderContext context;

    int projection, modelview, normalMat;
    int mode, ambientCoef, diffuseCoef, specularCoef, shininessVal;
    int ambientColor, diffuseColor, specularColor, lightPos;


    @Override
    public void init() {
        String vert = Gdx.files.internal("shaders/phong.vert.glsl").readString();
        String frag = Gdx.files.internal("shaders/phong.frag.glsl").readString();
        program = new ShaderProgram(vert, frag);
        if (!program.isCompiled()) {
            throw new GdxRuntimeException(program.getLog());
        }

        projection = program.getUniformLocation("projection");
        modelview = program.getUniformLocation("modelview");
        normalMat = program.getUniformLocation("normalMat");
        System.out.println(vert);
        System.out.println(projection);
        System.out.println(modelview);
        System.out.println(normalMat);
    }

    @Override
    public int compareTo(Shader other) {
        return 0;
    }

    @Override
    public boolean canRender(Renderable instance) {
        return false;
    }

    @Override
    public void begin(Camera camera, RenderContext context) {
        this.camera = camera;
        this.context = context;
        program.begin();
//        program.setUniformMatrix("projection", camera.projection);
//        program.setUniformMatrix("modelview", camera.view);
//        program.setUniformMatrix("normalMat", );

        program.setUniformi("mode", 0);


        program.setUniformf("Ka", 0.3f);
        program.setUniformf("Kd", 0.7f);
        program.setUniformf("Ks", 0.9f);
        program.setUniformf("shininessVal", 100.0f);

        program.setUniformf("ambientColor", 52.0f/255, 25.0f/255, 0.0f/255);
        program.setUniformf("diffuseColor", 1.0f, 0.8431f, 0.0f);
        program.setUniformf("specularColor", 255.0f/255, 255.0f/255, 255.0f/255);
        program.setUniformf("lightPos", 100.0f, 1.0f, -2.0f);

        context.setDepthTest(GL20.GL_LEQUAL);
        context.setCullFace(GL20.GL_BACK);
    }

    @Override
    public void render(Renderable renderable) {
        program.setUniformMatrix("projection", camera.projection);
        Matrix4 myMatrix = new Matrix4();
        myMatrix.set(camera.view);
        myMatrix.mul(renderable.worldTransform);
        program.setUniformMatrix("modelview", myMatrix);
        myMatrix.inv();
        myMatrix.tra();
        program.setUniformMatrix("normalMat", myMatrix);

        renderable.meshPart.render(program);
    }

    @Override
    public void end() {
        program.end();
    }

    @Override
    public void dispose() {
        program.dispose();
    }
}
