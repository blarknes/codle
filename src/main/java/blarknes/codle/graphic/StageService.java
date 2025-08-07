package blarknes.codle.graphic;

import static blarknes.codle.string.StringUtilities.EMPTY_STRING;
import static javafx.scene.input.KeyCombination.NO_MATCH;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import blarknes.codle.graphic.asset.CodleIcon;
import blarknes.codle.settings.SettingsService;
import javafx.stage.Screen;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class StageService {

    private final MainStage mainStage;
    private final SettingsService settingsService;

    @Value("${spring.application.name}")
    private String title;

    private static final int MINIMUM_STAGE_WIDTH = 1024;
    private static final int MINIMUM_STAGE_HEIGHT = 576;

    public void initialize() {
        val stage = mainStage.get();

        val icon = new CodleIcon().asImage();
        stage.getIcons().add(icon);
        stage.setTitle(title);

        applyDisplayMode(stage);
        centerStageOnScreen(stage);
    }

    private void centerStageOnScreen(final Stage stage) {
        val bounds = Screen.getPrimary().getVisualBounds();
        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() - stage.getHeight()) / 2);
    }

    private void applyDisplayMode(final Stage stage) {
        val isFullScreen = shouldBeFullScreen();

        if (isFullScreen) {
            enterFullScreen();
        } else {
            enterWindowed();
        }
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
        val stage = mainStage.get();
        stage.setFullScreen(true);
        stage.setFullScreenExitHint(EMPTY_STRING);
        stage.setFullScreenExitKeyCombination(NO_MATCH);
    }

    private void enterWindowed() {
        val stage = mainStage.get();
        val settings = settingsService.getSettings();

        stage.setWidth(settings.getStageWidth());
        stage.setHeight(settings.getStageHeight());

        stage.setMinWidth(MINIMUM_STAGE_WIDTH);
        stage.setMinHeight(MINIMUM_STAGE_HEIGHT);
    }

}
