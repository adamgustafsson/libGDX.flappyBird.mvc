package com.slakke.bird.model.obstacle;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by slakké on 2015-10-06.
 * - Obstacle object representing a tube.
 * - All obstacle objects will have a constant size based on its sprite size,
 *   we will not handle any View content in the Model layer such as Textures.
 */
public class Tube {

    //Tube textures: 52x320.
    public static final float TUBE_WIDTH = 52f;
    private static final float TUBE_HEIGHT = 320f;

    private static final int FLUCTUATION = 130;
    private static final int TUBE_GAP = 130;
    private static final int LOWEST_OPENING = 130;

    private Vector2 posTopTube, posBotTube;
    private Rectangle boundsTop, boundsBottom;
    private Random random;

    public Tube(float x){
        random = new Random();
        posTopTube = new Vector2(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube = new Vector2(x, posTopTube.y - TUBE_GAP - TUBE_HEIGHT);

        boundsTop = new Rectangle(posTopTube.x, posTopTube.y, TUBE_WIDTH, TUBE_HEIGHT);
        boundsBottom = new Rectangle(posBotTube.x, posBotTube.y, TUBE_WIDTH, TUBE_HEIGHT);
    }

    /**
     * Gets the bottom tube position.
     * @return Vector2 position.
     */
    public Vector2 getPosBotTube() { return posBotTube; }

    /**
     * Gets the top tube position.
     * @return Vector2 position.
     */
    public Vector2 getPosTopTube() { return posTopTube;  }

    /**
     * Method for repositioning the object.
     * @param x the new x position.
     */
    public void reposition(float x){
        posTopTube.set(x, random.nextInt(FLUCTUATION) + TUBE_GAP + LOWEST_OPENING);
        posBotTube.set(x, posTopTube.y - TUBE_GAP - TUBE_HEIGHT);

        boundsTop.setPosition(posTopTube.x, posTopTube.y);
        boundsBottom.setPosition(posBotTube.x, posBotTube.y);
    }

    /**
     * Method for determining if a unit collides with this object.
     * @param unitBounds
     * @return
     */
    public boolean collides(Rectangle unitBounds){
        return unitBounds.overlaps(boundsTop) || unitBounds.overlaps(boundsBottom);
    }
}
