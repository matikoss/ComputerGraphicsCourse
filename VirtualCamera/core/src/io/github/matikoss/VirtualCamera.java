package io.github.matikoss;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import io.github.matikoss.controllers.MainController;
import io.github.matikoss.renderers.MainRenderer;

public class VirtualCamera implements ApplicationListener {
    private MainController mainController;
    private MainRenderer mainRenderer;

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        mainController = new MainController();
        mainRenderer = new MainRenderer(mainController);
    }

    @Override
    public void resize(int width, int height) {
        mainRenderer.resize(width, height);
    }

    @Override
    public void render() {
        mainController.update(Gdx.graphics.getDeltaTime());
        mainRenderer.update();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainRenderer.render();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        mainRenderer.dispose();
    }
}
