package blarknes.codle.ui.screen.home;

import org.springframework.beans.factory.annotation.Autowired;

import blarknes.codle.ui.asset.CodleIcon;
import blarknes.codle.ui.player.SettingsService;
import blarknes.codle.ui.screen.Screen;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lombok.RequiredArgsConstructor;
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

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((event) -> {
            // TODO: think about a way to use settings service here
            System.out.println("Button clicked");
        });

        root.getChildren().addAll(todo, icon, btn);
        return new Scene(root);
    }

}
