package com.slakke.bird.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.slakke.bird.model.GameModel;
import com.slakke.bird.model.ObstacleLogic;
import com.slakke.bird.model.obstacle.Tube;

/**
 * Created by slakké on 2015-10-07.
 * - Main class for the View layer.
 * - All game graphics is handled from here.
 */
public class GameView {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 800;

    private SpriteBatch spriteBatch;
    private GameModel gameModel;
    private Texture playerTexture, bg, ground, topTube, bottomTube;
    private Animation playerAnimation;
    private OrthographicCamera cam;
    private Vector2 groundPos1, groundPos2;

    public GameView(SpriteBatch sb, GameModel gm){
        loadContent();
        spriteBatch = sb;
        gameModel = gm;
        playerAnimation = new Animation(new TextureRegion(playerTexture), 3, 0.2f);
        cam = new OrthographicCamera();
        cam.setToOrtho(false, WIDTH / 2, HEIGHT / 2);
        setInitialGroundPosition();
    }

    /**
     * Loads all game textures.
     */
    private void loadContent(){
        playerTexture = new Texture("birdanimation.png");
        bg = new Texture("bg.png");
        ground = new Texture("ground.png");
        topTube = new Texture("toptube.png");
        bottomTube = new Texture("bottomtube.png");
    }

    /**
     * Main method for updating and drawing the game graphics.
     * @param dt delta time.
     */
    public void updateAndRender(float dt) {
        //Update player animation
        playerAnimation.update(dt);
        //Update player camera
        updateCamera();
        //Update ground
        updateGround();
        //Set projection
        spriteBatch.setProjectionMatrix(cam.combined);
        //Draw
        spriteBatch.begin();

        spriteBatch.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        spriteBatch.draw(playerAnimation.getFrame(), gameModel.getPlayer().getPosition().x, gameModel.getPlayer().getPosition().y);
        for(Tube tube : gameModel.getObstacles()){
            spriteBatch.draw(topTube, tube.getPosTopTube().x, tube.getPosTopTube().y);
            spriteBatch.draw(bottomTube, tube.getPosBotTube().x, tube.getPosBotTube().y);
        }
        spriteBatch.draw(ground, groundPos1.x, groundPos1.y);
        spriteBatch.draw(ground, groundPos2.x, groundPos2.y);

        spriteBatch.end();
    }

    /**
     * Updates the ground sprites position.
     */
    private void updateGround(){
        if(gameModel.getPlayer().didCollide)
            setInitialGroundPosition();
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos1.x + ground.getWidth())
            groundPos1.add(ground.getWidth() * 2, 0);
        if(cam.position.x - (cam.viewportWidth / 2) > groundPos2.x + ground.getWidth())
            groundPos2.add(ground.getWidth() * 2, 0);
    }

    /**
     * Updates the camera position.
     */
    private void updateCamera(){
        cam.position.x = gameModel.getPlayer().getPosition().x + 80; //80 offset
        cam.update();
    }

    /**
     * Resets the initial ground sprite position.
     */
    private void setInitialGroundPosition() {
        groundPos1 = new Vector2(cam.position.x - cam.viewportWidth / 2, ObstacleLogic.GROUND_Y_OFFSET);
        groundPos2 = new Vector2((cam.position.x - cam.viewportWidth / 2) + ground.getWidth(), ObstacleLogic.GROUND_Y_OFFSET);
    }

    /**
     * Disposes all GameView textures.
     */
    public void dispose() {
        playerTexture.dispose();
        bg.dispose();
        ground.dispose();
        topTube.dispose();
        bottomTube.dispose();
        System.out.println("GameView content disposed");
    }
}
