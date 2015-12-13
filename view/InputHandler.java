package com.slakke.bird.view;

import com.badlogic.gdx.Gdx;

/**
 * Created by slakke on 2015-10-07.
 * View layer class for detecting all user input.
 */
public class InputHandler {

    public static boolean userJustTouched(){
        return Gdx.input.justTouched();
    }
}
