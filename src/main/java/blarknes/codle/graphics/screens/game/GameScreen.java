package blarknes.codle.graphics.screens.game;

import org.springframework.stereotype.Component;

import blarknes.codle.graphics.screens.Screen;
import blarknes.codle.graphics.stage.MainStage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lombok.val;

/**
 * Wrapper for the game scene that renders visual components and performs
 * actions related to this screen.
 */
@Component
public class GameScreen extends Screen {

    public GameScreen(final MainStage mainStage) {
        super(mainStage);
    }

    protected void populate(final VBox root) {
        val todo = new Text("TODO: implement the game screen");
        root.getChildren().addAll(todo);
    }

}
