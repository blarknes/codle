package blarknes.codle.graphic;

import org.springframework.stereotype.Component;

import javafx.stage.Stage;

/**
 * Wrapper class used to store the JavaFX's primary stage to have the ability of
 * using it as a singleton.
 */
@Component
public class MainStage {

    private Stage stage;
    private boolean initialized = false;

    public synchronized void set(final Stage stage) {
        if (initialized) {
            // throw TODO: add throw
            // IllegalState
        }

        if (null == stage) {
            // throw TODO: add throw
            // IllegalArgument
        }

        this.stage = stage;
        this.initialized = true;
    }

    public Stage get() {
        if (!initialized) {
            // throw TODO: add throw
            // IllegalState
        }

        return this.stage;
    }

}
