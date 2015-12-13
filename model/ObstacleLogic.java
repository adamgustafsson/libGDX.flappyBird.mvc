package com.slakke.bird.model;

import com.slakke.bird.model.obstacle.Tube;
import com.slakke.bird.model.unit.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slakke on 2015-10-07.
 * - Model layer class for handling all obstacle logic.
 */
public class ObstacleLogic {

    private static final int TUBE_COUNT = 4;
    private static final int TUBE_SPACING = 125;
    public static final int GROUND_Y_OFFSET = -30;
    private static final int GROUND_HEIGHT = 112;

    private List<Tube> tubes;
    private Player player;

    public ObstacleLogic(Player player) {

        this.player = player;
        tubes = new ArrayList<Tube>(TUBE_COUNT);

        for(int i = 1; i <= TUBE_COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACING + Tube.TUBE_WIDTH)));
        }
    }

    /**
     * Method for updating obstacle logic.
     * @param dt delta time.
     */
    public void update(float dt) {

        player.didCollide = false;

        for(int i = 0; i < tubes.size(); i++){

            Tube tube = tubes.get(i);

            //Player collide with tube
            if(tube.collides(player.getBounds()))
                player.didCollide = true;

            //Repositioning tubes
            if(player.getPosition().x - 100 > tube.getPosBotTube().x)
                tube.reposition(tube.getPosTopTube().x + ((Tube.TUBE_WIDTH + TUBE_SPACING) * TUBE_COUNT));
        }

        //Player collide with ground
        if(player.getPosition().y <= GROUND_HEIGHT + GROUND_Y_OFFSET)
            player.didCollide = true;

        if(player.didCollide)
            resetTubePositions();
    }

    /**
     * Resets the tube positions to the default.
     */
    private void resetTubePositions() {
        for(int i = 1; i <= tubes.size(); i++) {
            tubes.get(i-1).reposition(i * (TUBE_SPACING + Tube.TUBE_WIDTH));
        }
    }

    /**
     * @return a list of tube objects.
     */
    public List<Tube> getObstacles(){
        return tubes;
    }
}
