package com.slakke.bird.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by slakke on 2015-10-07.
 * - View layer class for handling all animations.
 */
public class Animation {

    private Array<TextureRegion> frames;
    private float maxFrameTime, currentFrameTime;
    private int frameCount, frame;

    public Animation(TextureRegion region, int frameCount, float cycleTime){
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;

        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }

        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    /**
     * Updates the frame position.
     * @param dt delta time.
     */
    public void update(float dt){
        currentFrameTime += dt;
        if(currentFrameTime > maxFrameTime){
            frame++;
            currentFrameTime = 0;
        }
        if(frame >= frameCount)
            frame = 0;
    }

    /**
     * Gets the frames texture region.
     * @return TextureRegion object.
     */
    public TextureRegion getFrame(){
        return frames.get(frame);
    }

}
