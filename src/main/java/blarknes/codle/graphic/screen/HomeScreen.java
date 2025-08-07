package blarknes.codle.graphic.screen;

import org.springframework.stereotype.Component;

import blarknes.codle.graphic.MainStage;
import blarknes.codle.graphic.asset.CodleIcon;
import blarknes.codle.settings.SettingsService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import lombok.val;

@Component
public class HomeScreen extends Screen {

    private final SettingsService settingsService;

    public HomeScreen(final MainStage mainStage, final SettingsService settingsService) {
        super(mainStage);
        this.settingsService = settingsService;
    }

    public Scene getScene() {
        val root = new StackPane();
        val icon = new CodleIcon().asPane();
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
