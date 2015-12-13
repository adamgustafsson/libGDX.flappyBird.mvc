package com.slakke.bird.model.unit;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by slakké on 2015-10-07.
 * - Base class for unit objects such as players, enemies and npc.
 */
public class Unit {

    public Vector2 position, velocity;
    public Rectangle bounds;
    public int gravity, movement;

    public Unit(Vector2 startPos, Vector2 velocity, Rectangle bounds, int gravity, int movement){
        position = startPos;
        this.velocity = velocity;
        this.bounds = bounds;
        this.gravity = gravity;
        this.movement = movement;
    }

    /**
     * Gets the units movement.
     * @return movement value as integer.
     */
    public int getMovement() {
        return movement;
    }

    /**
     * Gets the units position.
     * @return position as Vector2.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * Gets the units velocity.
     * @return velocity as Vector2.
     */
    public Vector2 getVelocity() {
        return velocity;
    }

    /**
     * Gets the units bounds.
     * @return bounds as a Rectangle object.
     */
    public Rectangle getBounds() {
        return bounds;
    }

    /**
     * Gets the units gravity.
     * @return gravity value as integer.
     */
    public int getGravity() {
        return gravity;
    }
}
