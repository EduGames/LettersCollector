package edu.games.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import edu.games.helpers.ArabicLetters;
import edu.games.helpers.AssetsManager;

/**
 * Created by mohheader on 20/08/14.
 */
public class Letter extends BaseDynamicObject{
    String letter;

    public Letter(MainLetter mainLetter){
        super(MathUtils.random(0, Gdx.graphics.getWidth() - 20),480,20,20);
        this.letter = ArabicLetters.getRandomLetter(mainLetter.getLetter());
    }

    public void update() {
        position.y -= 200 * Gdx.graphics.getDeltaTime();
        bounds.setPosition(position);
    }

    public void render(SpriteBatch batch) {
        AssetsManager.font.draw(batch, letter, position.x, position.y);
    }
}
