package com.quickbite.connector2;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

/**
 * Created by Paha on 1/24/2016.
 */
public class GH {
    public static Texture whitePixel = createPixel(Color.WHITE);

    /**
     * Lerps a float value from start to target.
     * @param curr The current value of the lerp.
     * @param start The start value of the lerp.
     * @param target The target value of the lerp.
     * @param seconds The time in seconds for the lerp to happen.
     * @return The value of the lerp after the calculated tick amount.
     */
    public static float lerpValue(float curr, float start, float target, float seconds){
        float amt = (Math.abs(start - target)/seconds)/60f;
        if(start < target) {
            curr += amt;
            if(curr >= target) curr = target;
        }else {
            curr -= amt;
            if(curr <= target) curr = target;
        }

        return curr;
    }

    public static String getLostReason(){
        String reason = "";
        if(GameStats.roundOverReason == GameStats.RoundOver.HitLine)
            reason = "Hit Line";
        if(GameStats.roundOverReason == GameStats.RoundOver.HitShape)
            reason = "Hit Wrong Shape";
        if(GameStats.roundOverReason == GameStats.RoundOver.OutOfTime)
            reason = "Out of Time";

        return reason;
    }

    public static void shuffleArray(Object[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = MathUtils.random(i);
            // Simple swap
            Object a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static Texture createPixel(Color color){
        return createPixel(color, 1, 1);
    }

    public static Texture createPixel(Color color, int width, int height) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(color.r, color.g, color.b, color.a);
        pixmap.fillRectangle( 0, 0, width, height );
        Texture pixmaptex = new Texture(pixmap);
        pixmap.dispose();

        return pixmaptex;
    }

    public static void incrementGameSettingsEvent(){
        String ID = "";
        switch(GameSettings.gameType){
            case Practice:
                ID = Constants.EVENT_PRACTICE;
                break;
            case Fastest:
                ID = Constants.EVENT_BEST;
                break;
            case Timed:
                ID = Constants.EVENT_TIMED;
                break;
            case Frenzy:
                ID = Constants.EVENT_FRENZY;
                break;
            case Nothing:
                break;
        }

        Game.resolver.submitEvent(ID);

        ID = "";
        switch(GameSettings.numShapes){
            case 3:
                ID = Constants.EVENT_3;
                break;
            case 4:
                ID = Constants.EVENT_4;
                break;
            case 5:
                ID = Constants.EVENT_5;
                break;
            case 6:
                ID = Constants.EVENT_6;
                break;
        }

        Game.resolver.submitEvent(ID);
    }

}
