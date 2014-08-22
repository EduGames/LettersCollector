package edu.games.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import edu.games.helpers.AssetsManager;

/**
 * Created by mohheader on 20/08/14.
 */
public class Bucket extends BaseObject {
    public Bucket(float x, float y){
        this(x, y, 64, 64);
    }
    public Bucket(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public void render(SpriteBatch batch){
        batch.draw(AssetsManager.bucketImage, position.x, position.y);
    }

    public void update() {
        position.set(Gdx.input.getX(), position.y);
        if(position.x < 0)  position.x = 0;
        if(position.x > Gdx.graphics.getWidth() - 64) position.x = Gdx.graphics.getWidth() - 64;
        bounds.setPosition(position);
    }

    public boolean containX(int screenX) {
        return screenX > position.x && screenX < position.x + bounds.width;
    }
}
