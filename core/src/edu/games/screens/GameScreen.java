package edu.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import edu.games.LettersGame;
import edu.games.helpers.InputHandler;
import edu.games.objects.Bucket;
import edu.games.objects.LettersManager;
import edu.games.objects.MainLetter;

/**
 * Created by mohheader on 20/08/14.
 */
public class GameScreen extends BaseScreen {


    public enum State{
        PAUSE,PLAY,GAMEOVER;
    }
    public State getCurrentState() {
        return currentState;
    }

    State currentState = State.PAUSE;

    OrthographicCamera camera;
    MainLetter mainLetter;
    LettersManager lettersManager;
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
        camera= new OrthographicCamera();
        camera.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.getBatch().setProjectionMatrix(camera.combined);
        camera.update();
    }

    private void resetGame() {
        mainLetter = new MainLetter(game.getBatch());
        lettersManager = new LettersManager(this, mainLetter);
        bucket = new Bucket((Gdx.graphics.getWidth() - 64) / 2,15);
    }

    public void setGameOver() {
        currentState = State.GAMEOVER;
    }

    @Override
    protected void updateWorld(float delta) {
        if(currentState == State.PAUSE){
            if(Gdx.input.justTouched()){
                currentState = State.PLAY;
            }
        }else if(currentState == State.PLAY){
            lettersManager.update(getBucket());
        }else if(currentState == State.GAMEOVER){
            if(Gdx.input.justTouched()){
                resetGame();
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
            Gdx.gl.glClearColor(0.0f, 0.0f, 1.0f, 1.0f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        }else return;
        camera.update();
        game.getBatch().begin();
        mainLetter.render();
        lettersManager.render(game.getBatch());
        bucket.render(game.getBatch());
        game.getBatch().end();
    }
}
