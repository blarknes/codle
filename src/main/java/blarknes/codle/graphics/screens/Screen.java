package blarknes.codle.graphics.screens;

import blarknes.codle.graphics.stage.MainStage;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * Manages and performs actions related to the application's different screens.
 */
@RequiredArgsConstructor
public abstract class Screen {

    private final MainStage mainStage;

    /**
     * Displays the desired screen on the window stage.
     */
    public void show() {
        val stage = mainStage.get();
        val scene = getScene();

        stage.setScene(scene);
    }

    /**
     * Get the scene from a specific screen.
     *
     * @return The scene to be rendered.
     */
    protected abstract Scene getScene();

}
