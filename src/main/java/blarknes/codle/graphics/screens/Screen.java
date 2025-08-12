package blarknes.codle.graphics.screens;

import static javafx.geometry.Pos.CENTER;

import blarknes.codle.graphics.stage.MainStage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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
        val scene = buildScene();

        stage.setScene(scene);
    }

    /**
     * Create the Scene to be used on a specific screen.
     *
     * @return The scene to be rendered.
     */
    private Scene buildScene() {
        val root = new VBox();
        root.setAlignment(CENTER);

        populate(root);

        return new Scene(root);
    }

    /**
     * Add the contents to the root parent of the screen.
     *
     * @param root the root parent of the screen
     */
    protected abstract void populate(final VBox root);

}
