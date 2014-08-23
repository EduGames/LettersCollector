package edu.games.helpers;

import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by thedreamer on 8/23/14.
 */
public class ArabicLetters {
    static String letters = "ابتثجحخدذرزسشصضطظعغفقكلمنهوي";
    static String[] lettersArray = letters.split("(?!^)");

    public static String getRandomLetter(){
        int idx = new Random().nextInt(lettersArray.length);
        return lettersArray[idx];
    }
    public static String getRandomLetter(String mostly){
        String[] ss = {getRandomLetter(),mostly};
        int idx = new Random().nextInt(ss.length);
        return ss[idx];
    }
}
