package com.slakke.bird.controller;

import com.slakke.bird.view.InputHandler;
import com.slakke.bird.view.ScreenView;

/**
 * Created by slakké on 2015-10-07.
 * - Main controller for handling the rendering of external and internal screens.
 * - Handles user input when a screen is presented.
 */
public class ScreenController {

    private boolean startScreenIsActive;
    private ScreenView screenView;

    public ScreenController(ScreenView screenView){
        startScreenIsActive = true;
        this.screenView = screenView;
    }

    /**
     * Method for handling user input and updating the
     * ScreenView.
     * @param dt delta time
     */
    public void update(float dt){
        if(InputHandler.userJustTouched() && startScreenIsActive) {
            startScreenIsActive = false;
            screenView.disposeStartScreen();
        }
    }

    /**
     * Method for rendering active screens via the ScreenView.
     * @param dt delta time
     */
    public void render(float dt){
        if(startScreenIsActive)
            screenView.renderStartScreen();
    }

    /**
     * @return true if a screen is active.
     */
    public boolean externalScreenIsActive() {
        return startScreenIsActive;
    }
}
