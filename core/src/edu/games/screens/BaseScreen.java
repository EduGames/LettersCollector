package edu.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import edu.games.LettersGame;

/**
 * Created by mohheader on 20/08/14.
 */
public abstract class BaseScreen implements Screen {
    LettersGame game;
    int width,height;
    public BaseScreen(LettersGame game){
        this.game = game;
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
    }

    @Override
    public void show() {

    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
    @Override
    public void render(float delta) {
        updateWorld(delta);
        renderWorld();
    }

    protected abstract void renderWorld();
    protected abstract void updateWorld(float delta);
}
