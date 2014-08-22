package edu.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import edu.games.LettersGame;
import edu.games.helpers.InputHandler;
import edu.games.objects.Bucket;
import edu.games.objects.MainLetter;

/**
 * Created by mohheader on 20/08/14.
 */
public class GameScreen extends BaseScreen {
    public enum State{
        PAUSE,PLAY,GAMEOVER
    }

    public State getCurrentState() {
        return currentState;
    }

    State currentState = State.PAUSE;
    OrthographicCamera camera;
    MainLetter mainLetter;

    public Bucket getBucket() {
        return bucket;
    }

    private Bucket bucket;

    public GameScreen(LettersGame game) {
        super(game);
        Gdx.input.setInputProcessor(new InputHandler(this));
        setCamera();
        resetGame();
    }

    private void setCamera() {
        camera= new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getBatch().setProjectionMatrix(camera.combined);
        game.getBatch().getProjectionMatrix().setToOrtho2D(0f,0f,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        camera.update();
    }

    private void resetGame() {
        mainLetter = new MainLetter(game.getBatch());
        bucket = new Bucket(64,64);
    }

    @Override
    protected void updateWorld(float delta) {
        if(currentState == State.PAUSE){
            if(Gdx.input.justTouched()){
                currentState = State.PLAY;
            }
        }
    }

    @Override
    protected void renderWorld() {
        if(currentState == State.PAUSE) {
            Gdx.gl.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        }else if(currentState == State.PLAY) {
            Gdx.gl.glClearColor(0.0f, 1.0f, 1.0f, 1.0f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        }
        camera.update();
        game.getBatch().begin();
        mainLetter.render();
        bucket.render(game.getBatch());
        game.getBatch().end();
    }
}
