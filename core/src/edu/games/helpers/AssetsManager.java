package edu.games.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by mohheader on 20/08/14.
 */
public class AssetsManager {
    public static BitmapFont font;
    public static Texture bucketImage;
    public static Sound dropSound;
    public static void load(){
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/shoroq.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = ArabicLetters.letters;
        parameter.size = 32;
        font = generator.generateFont(parameter);
        generator.dispose();
        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.wav"));
        bucketImage = new Texture(Gdx.files.internal("bucket.png"));
    }

    public static void dispose(){

    }
}
