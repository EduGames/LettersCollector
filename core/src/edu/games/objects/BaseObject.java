package edu.games.objects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by mohheader on 21/08/14.
 */
public abstract class BaseObject {
    public final Vector2 position;
    public final Rectangle bounds;

    public BaseObject (float x, float y, float width, float height) {
        this.position = new Vector2(x, y);
        this.bounds = new Rectangle(x - width / 2, y - height / 2, width, height);
        bounds.setPosition(position);
    }
}
