package blarknes.codle.ui;

import static blarknes.codle.string.StringUtilities.EMPTY_STRING;
import static javafx.scene.input.KeyCombination.NO_MATCH;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import blarknes.codle.ui.asset.CodleIcon;
import blarknes.codle.ui.player.SettingsService;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.val;

@Component
@RequiredArgsConstructor
public class MainStage {

    private final SettingsService settingsService;

    @Value("${spring.application.name}")
    private String title;

    private Stage stage;

    private static final int MINIMUM_STAGE_WIDTH = 1024;
    private static final int MINIMUM_STAGE_HEIGHT = 576;

    public void initialize(final Stage stage) {
        this.stage = stage;

        val icon = new CodleIcon().asImage();
        this.stage.getIcons().add(icon);
        this.stage.setTitle(title);

        val isFullScreen = shouldBeFullScreen();
        if (isFullScreen) {
            enterFullScreen();
        } else {
            enterWindowed();
        }

        centerStageOnScreen();
    }

    private boolean shouldBeFullScreen() {
        val settings = settingsService.getSettings();
        val bounds = Screen.getPrimary().getVisualBounds();

        val hasWidthOverflow = bounds.getWidth() < settings.getStageWidth();
        val hasHeightOverflow = bounds.getHeight() < settings.getStageHeight();
        val hasSetFullScreen = settings.isFullScreen();
        val shouldEnterFullScreen = hasWidthOverflow || hasHeightOverflow || hasSetFullScreen;

        return shouldEnterFullScreen;
    }

    private void enterFullScreen() {
        this.stage.setFullScreen(true);
        this.stage.setFullScreenExitHint(EMPTY_STRING);
        this.stage.setFullScreenExitKeyCombination(NO_MATCH);
    }

    private void enterWindowed() {
        val settings = settingsService.getSettings();

        this.stage.setWidth(settings.getStageWidth());
        this.stage.setHeight(settings.getStageHeight());

        this.stage.setMinWidth(MINIMUM_STAGE_WIDTH);
        this.stage.setMinHeight(MINIMUM_STAGE_HEIGHT);
    }

    private void centerStageOnScreen() {
        val bounds = Screen.getPrimary().getVisualBounds();
        this.stage.setX((bounds.getWidth() - this.stage.getWidth()) / 2);
        this.stage.setY((bounds.getHeight() - this.stage.getHeight()) / 2);
    }

}
