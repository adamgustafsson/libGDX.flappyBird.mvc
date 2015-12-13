package com.slakke.bird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.profiling.GLProfiler;
import com.slakke.bird.controller.GameController;
import com.slakke.bird.controller.ScreenController;
import com.slakke.bird.model.GameModel;
import com.slakke.bird.view.GameView;
import com.slakke.bird.view.ScreenView;
import com.slakke.bird.view.SoundHandler;

/**
 * Created by slakké on 2015-10-07.
 * - Master controller class for the game.
 * - Runs and updates the Game and Screen controllers.
 * - Extends the ApplicationAdapter class.
 */
public class MasterController extends ApplicationAdapter {

    private GameModel gameModel;
    private GameView gameView;
    private GameController gameController;
    private ScreenView screenView;
    private ScreenController screenController;
    private SoundHandler soundHandler;
    private FPSLogger logger = new FPSLogger();
    private SpriteBatch sb;

    @Override
    public void create () {
        //Profiler for performance checks.
        //GLProfiler.enable();

        //The only instance of sb for the whole game.
        sb = new SpriteBatch();
        //Initializes the SoundHandler (used by bot the Game and Screen view)
        soundHandler = new SoundHandler();

        //Separate controller/view for screen handling.
        screenView = new ScreenView(sb);
        screenController = new ScreenController(screenView);

        //Instantiating game MVC components
        gameModel = new GameModel();
        gameView = new GameView(sb, gameModel);
        gameController = new GameController(gameView, gameModel);
    }

    /**
     * Main render method. Updates and renders the game via the Screen - and GameController.
     */
    @Override
    public void render () {

        float dt = Gdx.graphics.getDeltaTime();

        screenController.update(dt);

        if(screenController.externalScreenIsActive())
            screenController.render(dt);
        else
            gameController.update(dt);

        logger.log();
    }

    @Override
    public void dispose() {
        super.dispose();
        gameController.dispose();
        soundHandler.dispose();
        //System.out.println(GLProfiler.drawCalls);
        //System.out.println(GLProfiler.calls);
        //System.out.println(GLProfiler.textureBindings);
    }

}
