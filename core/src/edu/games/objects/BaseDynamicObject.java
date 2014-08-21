package edu.games.objects;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by mohheader on 21/08/14.
 */
public abstract class BaseDynamicObject extends BaseObject {
    public final Vector2 velocity;
    public final Vector2 accel;

    public BaseDynamicObject (float x, float y, float width, float height) {
        super(x, y, width, height);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
