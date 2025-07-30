package blarknes.codle.ui;

import static blarknes.codle.string.StringUtilities.EMPTY_STRING;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.lifecycle.StartupEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import lombok.val;

@Component
public class WindowManager {

    @Value("${spring.application.name}")
    private String title;

    private static final CodleIcon codleIcon = new CodleIcon();

    @EventListener
    public void onStartupEvent(final StartupEvent event) throws IOException {
        final Stage stage = event.getStage();

        stage.setTitle(title);
        stage.setFullScreenExitHint(EMPTY_STRING);
        stage.setWidth(300);
        stage.setHeight(250);
        stage.setMinWidth(300);
        stage.setMinHeight(250);
        stage.getIcons().add(codleIcon.asImage());
        // stage.centerOnScreen(); // TODO: this method does not work as expected, find
        // stage.setFullScreen(true); // TODO: get this from last chosen user option

        val root = new StackPane();

        val icon = codleIcon.asSVG();
        val todo = new Text("TODO: implement this screen");

        root.getChildren().addAll(todo, icon);

        stage.setScene(new Scene(root));
        stage.show();
    }

}
