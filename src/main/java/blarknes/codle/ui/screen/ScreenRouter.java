package blarknes.codle.ui.screen;

import org.springframework.stereotype.Component;

import blarknes.codle.ui.player.SettingsService;
import blarknes.codle.ui.screen.home.HomeScreen;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ScreenRouter {

    // TODO: I don't like this class, think about a better way to pass this settingsService down to the Screens

    private final SettingsService settingsService;

    public void showHomeScreen(final Stage stage) {
        HomeScreen.builder()
            .stage(stage)
            .settingsService(settingsService)
            .build()
            .show();
    }

    public void showGameScreen(final Stage stage) {
        HomeScreen.builder()
            .stage(stage)
            .settingsService(settingsService)
            .build()
            .show();
    }

}
