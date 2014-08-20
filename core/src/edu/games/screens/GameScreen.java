package edu.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import edu.games.LettersGame;

/**
 * Created by mohheader on 20/08/14.
 */
public class GameScreen extends BaseScreen {
    enum State{
        PAUSE,PLAY,GAMEOVER
    }
    State currentState = State.PAUSE;
    OrthographicCamera camera;

    public GameScreen(LettersGame game) {
        super(game);
        camera = new OrthographicCamera(320, 480);
    }

    @Override
    protected void updateWorld(float delta) {

    }

    @Override
    protected void renderWorld() {
        Gdx.gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        game.getBatch().setProjectionMatrix(camera.combined);


    }
}
