package blarknes.codle.ui;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.lifecycle.StartupEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@Component
public class WindowCurator {

    @Value("${spring.application.name}")
    private String title;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        final Stage stage = event.getStage();

        // TODO: change the way the main stage is built
        stage.setTitle(title);
        stage.setWidth(300);
        stage.setHeight(250);
        StackPane root = new StackPane();
        root.getChildren().add(new Text("TODO: implement this screen"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
