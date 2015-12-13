package com.slakke.bird.model;

import com.badlogic.gdx.math.Vector2;
import com.slakke.bird.model.unit.Player;

/**
 * Created by slakké on 2015-10-07.
 * - Model layer class for handling all player logic.
 */
public class PlayerLogic {

    private Player player;

    public PlayerLogic(Player player){
        this.player = player;
    }

    /**
     * Method for updating the player logic.
     * @param dt delta time.
     */
    public void update(float dt) {

        if(player.getPosition().y > 0)
            player.velocity.add(0, player.getGravity());

        player.velocity.scl(dt);
        player.position.add(player.getMovement() * dt, player.getVelocity().y);

        //Player collided with some obstacle (tubes or the ground)
        if(player.didCollide) {
            player.respawn(new Vector2(50f,300f));
            System.out.println("Player re-spawned at: " + player.getPosition());
        }

        player.velocity.scl(1/dt);
        player.bounds.setPosition(player.getPosition().x, player.getPosition().y);
    }
}
