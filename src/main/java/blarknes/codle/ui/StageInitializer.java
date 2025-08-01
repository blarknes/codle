package blarknes.codle.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import blarknes.codle.ui.asset.CodleIcon;
import javafx.stage.Stage;
import lombok.val;

@Component
public class StageInitializer {

    @Value("${spring.application.name}")
    private String title;

    public void initialize(final Stage stage) {
        val icon = new CodleIcon().asImage();
        stage.getIcons().add(icon);

        stage.setTitle(title);

        setDimensions(stage);
        centerOnScreen(stage);
    }

    private void setDimensions(final Stage stage) {
        stage.setWidth(320); // TODO: calc this
        stage.setHeight(250); // TODO: calc this
        stage.setMinWidth(300); // TODO: move this to const based on contents on screen
        stage.setMinHeight(250); // TODO: move this to const based on contents on screen
        // stage.setFullScreen(true); // TODO: get this from last chosen user option
        // stage.setFullScreenExitHint(EMPTY_STRING);
    }

    private void centerOnScreen(final Stage stage) {
        // stage.centerOnScreen(); // TODO: this method does not work as expected, find
    }

}
