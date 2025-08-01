package blarknes.codle.ui.screen.home;

import blarknes.codle.ui.asset.CodleIcon;
import blarknes.codle.ui.screen.Screen;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lombok.val;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class HomeScreen extends Screen {

    public Scene getScene() {
        // TODO: update this
        val root = new StackPane();
        final CodleIcon codleIcon = new CodleIcon();
        val icon = codleIcon.asPane();
        val todo = new Text("TODO: implement this screen");
        root.getChildren().addAll(todo, icon);
        return new Scene(root);
    }

}
