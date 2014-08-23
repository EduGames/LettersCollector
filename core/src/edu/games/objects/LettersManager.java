package edu.games.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

import edu.games.helpers.AssetsManager;
import edu.games.screens.GameScreen;

/**
 * Created by thedreamer on 8/23/14.
 */
public class LettersManager {
    private long lastDropTime;
    private Array<Letter> raindrops;
    private MainLetter mainLetter;
    private GameScreen game;
    public LettersManager(GameScreen game, MainLetter mainLetter){
        raindrops = new Array<Letter>();
        this.game = game;
        this.mainLetter = mainLetter;
        spawnRaindrop();
    }
    private void spawnRaindrop() {
        Letter raindrop = new Letter(mainLetter);
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }
    public void update(Bucket bucket){
        if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
        Iterator<Letter> iter = raindrops.iterator();
        while(iter.hasNext()) {
            Letter raindrop = iter.next();
            raindrop.update();
            if(raindrop.bounds.overlaps(bucket.bounds) ) {
                if(raindrop.letter.equals(mainLetter.getLetter())){
                    AssetsManager.dropSound.play();
                    iter.remove();
                }else{
                    game.setGameOver();
                }
            }
            if(raindrop.position.y + 64 < 0) {
                if(raindrop.letter.equals(mainLetter.getLetter())){
                    game.setGameOver();
                }else{
                    iter.remove();
                }
            }
        }
    }
    public void render(SpriteBatch batch){
        for(Letter raindrop: raindrops) {
            raindrop.render(batch);
        }
    }

}
