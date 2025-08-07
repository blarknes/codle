package blarknes.codle.graphic.screen;

import blarknes.codle.graphic.MainStage;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;
import lombok.val;

@RequiredArgsConstructor
public abstract class Screen {

    private final MainStage mainStage;

    public void show() {
        val stage = mainStage.get();
        val scene = getScene();

        stage.setScene(scene);
    }

    public abstract Scene getScene();

}
