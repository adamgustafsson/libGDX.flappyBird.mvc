package com.slakke.bird.model.unit;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by slakke on 2015-10-07.
 * - Inherits from the Unit base class.
 * - All unit objects will have a constant size based on its sprite size,
 *   we will not handle any View content in the Model layer such as Textures.
 */
public class Player extends Unit {

    //Bird.png (32x24)
    private static final Vector2 SIZE = new Vector2(32f, 24f);
    public boolean didCollide;

    public Player(Vector2 startPos) {
        super(startPos,
                //Velocity
                new Vector2(0,0),
                //Bounds
                new Rectangle(startPos.x, startPos.y, SIZE.x, SIZE.y),
                //Gravity and speed
                -15, 100);
    }

    /**
     * Jump method.
     */
    public void jump(){
        velocity.y = 250;
    }

    /**
     * Respawn method, resets all properties to default.
     */
    public void respawn(Vector2 pos){
        position = pos;
        velocity = new Vector2(0,0);
        bounds.x = pos.x;
        bounds.y = pos.y;
        gravity = -15;
        movement = 100;
    }
}
