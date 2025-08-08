package blarknes.codle.graphic;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.graphic.screen.HomeScreen;
import blarknes.codle.lifecycle.StartupEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;

@Component
@RequiredArgsConstructor
public class Router {

    private final MainStage mainStage;
    private final StageService stageService;
    private final HomeScreen homeScreen;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        val stage = event.getStage();
        mainStage.set(stage);

        stageService.initialize();
        showHomeScreen();

        stage.show();
    }

    public void showHomeScreen() {
        homeScreen.show();
        // HomeScreen.builder()
        //         .stage(stage)
        //         .settingsService(settingsService)
        //         .build()
        //         .show();
    }

    public void showGameScreen() {
        // HomeScreen.builder()
        //         .stage(stage)
        //         .settingsService(settingsService)
        //         .build()
        //         .show();
    }

}
