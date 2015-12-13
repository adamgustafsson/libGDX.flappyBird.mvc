package com.slakke.bird.controller;

import com.slakke.bird.model.GameModel;
import com.slakke.bird.view.GameView;
import com.slakke.bird.view.InputHandler;
import com.slakke.bird.view.SoundHandler;

/**
 * Created by slakké on 2015-10-07.
 * - Main controller for the game.
 * - Checks for user input via the GameView.
 */
public class GameController {

    private GameModel gameModel;
    private GameView gameView;

    public GameController(GameView view, GameModel model){
        this.gameModel = model;
        this.gameView = view;
    }

    /**
     * Method for handling user input and updating the
     * GameView and GameModel.
     * @param dt delta time
     */
    public void update (float dt){

        //Collecting user input
        if(InputHandler.userJustTouched())
        {
            gameModel.getPlayer().jump();
            SoundHandler.playSound(SoundHandler.SoundID.JUMP, 0.2f);
        }
        //Updating game logic
        gameModel.update(dt);
        //Draws the game
        gameView.updateAndRender(dt);
    }

    public void dispose() {
        gameView.dispose();
    }
}
