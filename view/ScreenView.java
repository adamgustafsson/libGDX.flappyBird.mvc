package com.slakke.bird.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by slakké on 2015-10-07.
 * - View layer class for drawing game screens.
 */
public class ScreenView {

    private SpriteBatch sb;
    private Texture background, playBtn;

    public ScreenView(SpriteBatch sb){
        this.sb = sb;
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    /**
     * Method for rendering the start screen.
     * Needs to be modified for Android.
     */
    public void renderStartScreen(){
        SoundHandler.playTrack(SoundHandler.TrackID.MAIN_THEME, 0.1f, true);
        //Android (Need to make the GameView camera static)
        //sb.setProjectionMatrix(GameView.cam.combined);
        sb.begin();
        sb.draw(background, 0,0, GameView.WIDTH, GameView.HEIGHT);
        //Android
        //sb.draw(background, 0,0);
        sb.draw(playBtn, (GameView.WIDTH / 2)  - (playBtn.getWidth() / 2), GameView.HEIGHT / 2);
        //Android
        //sb.draw(playBtn, GameView.cam.position.x - playBtn.getWidth() / 2, GameView.cam.position.y);
        sb.end();
    }

    /**
     * Disposes the start screen textures.
     */
    public void disposeStartScreen() {
        background.dispose();
        playBtn.dispose();
        System.out.println("Screen view disposed.");
    }
}
