package blarknes.codle.graphics;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import blarknes.codle.graphics.screens.game.GameScreen;
import blarknes.codle.graphics.screens.home.HomeScreen;
import blarknes.codle.graphics.stage.MainStage;
import blarknes.codle.graphics.stage.StageService;
import blarknes.codle.lifecycle.StartupEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * Manages and performs routing operations to deletage what is displayed on the
 * screen.
 */
@Component
@RequiredArgsConstructor
public class Router {

    private final MainStage mainStage;
    private final HomeScreen homeScreen;
    private final GameScreen gameScreen;
    private final StageService stageService;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        val stage = event.getStage();
        mainStage.set(stage);

        stageService.initialize();
        showHomeScreen();

        stage.show();
    }

    /**
     * Renders the home screen on the stage.
     */
    public void showHomeScreen() {
        homeScreen.show();
    }

    /**
     * Renders the game screen on the stage.
     */
    public void showGameScreen() {
        gameScreen.show();
    }

}
