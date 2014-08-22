package edu.games.helpers;

import com.badlogic.gdx.InputProcessor;

import edu.games.screens.GameScreen;

/**
 * Created by mohheader on 20/08/14.
 */
public class InputHandler implements InputProcessor{
    GameScreen screen;
    boolean isBucketTouchFromDown = false;
    public InputHandler(GameScreen screen){
        this.screen = screen;
    }
    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(screen.getCurrentState() != GameScreen.State.PLAY) return false;
        if( screen.getBucket().containX(screenX)) isBucketTouchFromDown = true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        isBucketTouchFromDown = false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if(isBucketTouchFromDown) screen.getBucket().update();
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
