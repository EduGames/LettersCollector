package edu.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import edu.games.LettersGame;

/**
 * Created by mohheader on 20/08/14.
 */
public class MainMenu extends BaseScreen {

    public MainMenu(LettersGame game) {
        super(game);
    }

    @Override
    protected void updateWorld(float delta) {
        if (Gdx.input.justTouched()){
            game.setScreen(new GameScreen(game));
        }
    }

    @Override
    protected void renderWorld() {
        Gdx.gl.glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    }
}
