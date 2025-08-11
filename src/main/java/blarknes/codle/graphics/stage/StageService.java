package blarknes.codle.graphics.stage;

import static javafx.scene.input.KeyCombination.NO_MATCH;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import blarknes.codle.graphics.assets.CodleIcon;
import blarknes.codle.persistence.settings.SettingsService;
import javafx.stage.Screen;
import lombok.RequiredArgsConstructor;
import lombok.val;

// TODO: add javadoc
@Service
@RequiredArgsConstructor
public class StageService {

    private final MainStage mainStage;
    private final SettingsService settingsService;

    @Value("${spring.application.name}")
    private String title;

    private static final int MINIMUM_STAGE_WIDTH = 1024;
    private static final int MINIMUM_STAGE_HEIGHT = 576;

    // TODO: add javadoc
    public void initialize() {
        setupStageBasics();
        applyDisplayMode();
        centerOnScreen();
    }

    private void setupStageBasics() {
        val stage = mainStage.get();

        stage.getIcons().add(new CodleIcon().asImage());
        stage.setTitle(title);
    }

    private void applyDisplayMode() {
        val enterFullScreen = shouldBeFullScreen();
        if (enterFullScreen) {
            enterFullScreen();
        } else {
            enterWindowed();
        }
    }

    private void centerOnScreen() {
        val stage = mainStage.get();
        val bounds = Screen.getPrimary().getVisualBounds();

        stage.setX((bounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() - stage.getHeight()) / 2);
    }

    private void enterFullScreen() {
        val stage = mainStage.get();

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreenExitKeyCombination(NO_MATCH);
    }

    private void enterWindowed() {
        val stage = mainStage.get();
        val settings = settingsService.get();

        stage.setWidth(settings.getStageWidth());
        stage.setHeight(settings.getStageHeight());
        stage.setMinWidth(MINIMUM_STAGE_WIDTH);
        stage.setMinHeight(MINIMUM_STAGE_HEIGHT);
    }

    private boolean shouldBeFullScreen() {
        val settings = settingsService.get();
        if (settings.isFullScreen()) {
            return true;
        }

        val bounds = Screen.getPrimary().getVisualBounds();
        val hasWidthOverflow = bounds.getWidth() < settings.getStageWidth();
        val hasHeightOverflow = bounds.getHeight() < settings.getStageHeight();

        return hasWidthOverflow || hasHeightOverflow;
    }

}
