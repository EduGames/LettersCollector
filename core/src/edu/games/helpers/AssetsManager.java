package edu.games.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by mohheader on 20/08/14.
 */
public class AssetsManager {
    public static BitmapFont font;
    public static Texture bucketImage;
    public static void load(){
        font = new BitmapFont();
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
    }

    public static void dispose(){

    }
}
