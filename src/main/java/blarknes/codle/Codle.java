package blarknes.codle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.val;

public class Codle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        val content = new StackPane(new Text("Hello World"));
        val scene = new Scene(content, 300, 300);

        stage.setScene(scene);
        stage.show();
    }

}
