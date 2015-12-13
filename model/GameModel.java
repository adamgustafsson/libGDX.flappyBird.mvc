package com.slakke.bird.model;

import com.badlogic.gdx.math.Vector2;
import com.slakke.bird.model.obstacle.Tube;
import com.slakke.bird.model.unit.Player;

import java.util.List;

/**
 * Created by slakké on 2015-10-07.
 * - Main model layer class for the game.
 * - All game logic is distributed and updated from here.
 */
public class GameModel {

    private Player player;
    private PlayerLogic playerLogic;
    private ObstacleLogic obstacleLogic;

    public GameModel(){
        player = new Player(new Vector2(50f, 300f));
        playerLogic = new PlayerLogic(player);
        obstacleLogic = new ObstacleLogic(player);
    }

    /**
     * Method for updating the logic of all model layer instances.
     * @param dt delta time.
     */
    public void update (float dt){
        obstacleLogic.update(dt);
        playerLogic.update(dt);
    }

    /**
     * Gets the player object.
     * @return the player object.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets a list of obstacles (tubes).
     * @return a list of tube objects.
     */
    public List<Tube> getObstacles(){
        return obstacleLogic.getObstacles();
    }
}
