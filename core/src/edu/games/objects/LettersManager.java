package edu.games.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

/**
 * Created by thedreamer on 8/23/14.
 */
public class LettersManager {
    private long lastDropTime;
    private Array<Letter> raindrops;
    private MainLetter mainLetter;
    public LettersManager(MainLetter mainLetter){
        raindrops = new Array<Letter>();
        this.mainLetter = mainLetter;
        spawnRaindrop();
    }
    private void spawnRaindrop() {
        Letter raindrop = new Letter(mainLetter);
        raindrops.add(raindrop);
        lastDropTime = TimeUtils.nanoTime();
    }
    public void update(){
        if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRaindrop();
        Iterator<Letter> iter = raindrops.iterator();
        while(iter.hasNext()) {
            Letter raindrop = iter.next();
            raindrop.position.y -= 200 * Gdx.graphics.getDeltaTime();
            if(raindrop.position.y + 64 < 0) iter.remove();
        }
    }
    public void render(SpriteBatch batch){
        for(Letter raindrop: raindrops) {
            raindrop.render(batch);
        }
    }

}
