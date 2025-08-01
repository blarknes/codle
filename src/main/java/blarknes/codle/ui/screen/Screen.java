package blarknes.codle.ui.screen;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.val;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Screen {

    private final Stage stage;

    public void show() {
        val scene = getScene();
        this.stage.setScene(scene);
    }

    public abstract Scene getScene();

}
