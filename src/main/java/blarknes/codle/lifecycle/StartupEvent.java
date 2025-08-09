package blarknes.codle.lifecycle;

import org.springframework.context.ApplicationEvent;

import javafx.stage.Stage;
import lombok.Getter;

/**
 * Event sent to the Spring context after the initialization of JavaFX.
 */
@Getter
public class StartupEvent extends ApplicationEvent {

    private Stage stage;

    public StartupEvent(final Stage stage) {
        super(stage);
        this.stage = stage;
    }

}
