package io.github.matikoss;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import io.github.matikoss.controllers.MainController;
import io.github.matikoss.renderers.MainRenderer;

public class HiddenSurfaceRemoval implements ApplicationListener {
    MainRenderer renderer;
    MainController controller;

    @Override
    public void create() {
        controller = new MainController();
        renderer = new MainRenderer(controller);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        controller.update();
        renderer.update();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        renderer.render();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
