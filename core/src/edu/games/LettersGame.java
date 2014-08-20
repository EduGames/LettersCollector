package edu.games;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.games.helpers.AssetsManager;
import edu.games.screens.MainMenu;

public class LettersGame extends Game {
	private SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();
        AssetsManager.load();
        setScreen(new MainMenu(this));
	}

	@Override
	public void render () {
		super.render();
	}

    @Override
    public void dispose() {
        super.dispose();
        AssetsManager.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}