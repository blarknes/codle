package blarknes.codle.ui.screen.home;

import blarknes.codle.ui.asset.CodleIcon;
import blarknes.codle.ui.player.SettingsService;
import blarknes.codle.ui.screen.Screen;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lombok.val;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class HomeScreen extends Screen {

    private final SettingsService settingsService;

    public Scene getScene() {
        val root = new StackPane();
        final CodleIcon codleIcon = new CodleIcon();
        val icon = codleIcon.asPane();
        val todo = new Text("TODO: implement this screen");

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((event) -> {
            System.out.println("Button clicked");
            settingsService.setStageWidth();
        });

        root.getChildren().addAll(todo, icon, btn);
        return new Scene(root);
    }

}
