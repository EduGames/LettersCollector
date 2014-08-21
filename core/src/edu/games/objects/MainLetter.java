package edu.games.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.games.helpers.AssetsManager;

/**
 * Created by mohheader on 20/08/14.
 */
public class MainLetter {
    private String letter;
    SpriteBatch batch;

    public MainLetter(SpriteBatch batch) {
        this.letter = "A";
        this.batch = batch;
    }

    public String getLetter() {
        return letter;
    }

    public void render(){
        AssetsManager.font.draw(batch, getLetter(), 0, Gdx.graphics.getHeight());
    }
}
