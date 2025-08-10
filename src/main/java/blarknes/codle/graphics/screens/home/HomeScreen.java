package blarknes.codle.graphics.screens.home;

import org.springframework.stereotype.Component;

import blarknes.codle.graphics.screens.Screen;
import blarknes.codle.graphics.stage.MainStage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lombok.val;

/**
 * Wrapper for the home scene that renders visual components and performs
 * actions related to this screen.
 */
@Component
public class HomeScreen extends Screen {

    public HomeScreen(final MainStage mainStage) {
        super(mainStage);
    }

    protected Scene getScene() {
        val root = new StackPane();
        val todo = new Text("TODO: implement the home screen");
        root.getChildren().addAll(todo);

        return new Scene(root);
    }

}
