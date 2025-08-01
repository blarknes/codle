package blarknes.codle.ui.screen;

import org.springframework.stereotype.Component;

import blarknes.codle.ui.screen.home.HomeScreen;
import javafx.stage.Stage;

@Component
public class ScreenManager {

    public void showHomeScreen(final Stage stage) {
        HomeScreen.builder()
            .stage(stage)
            .build()
            .show();
    }

    public void showGameScreen(final Stage stage) {
        HomeScreen.builder()
            .stage(stage)
            .build()
            .show();
    }

}
