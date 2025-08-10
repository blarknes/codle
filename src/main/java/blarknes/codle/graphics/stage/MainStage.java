package blarknes.codle.graphics.stage;

import org.springframework.stereotype.Component;

import blarknes.codle.graphics.stage.exception.MainStageAlreadyInitializedException;
import blarknes.codle.graphics.stage.exception.MainStageIsNullException;
import blarknes.codle.graphics.stage.exception.MainStageNotInitializedException;
import javafx.stage.Stage;

/**
 * Wrapper Component class to store the primary Stage from JavaFX so that it can
 * be used everywhere on the application as a singleton.
 */
@Component
public class MainStage {

    private Stage stage;
    private boolean initialized = false;

    /**
     * Stores the JavaFX's primary stage on the wrapped singleton variable.
     *
     * @param stage the JavaFX's primary stage
     */
    public synchronized void set(final Stage stage) {
        if (initialized) {
            throw new MainStageAlreadyInitializedException();
        }

        if (null == stage) {
            throw new MainStageIsNullException();
        }

        this.stage = stage;
        this.initialized = true;
    }

    /**
     * Gets the JavaFX's wrapped primary stage.
     *
     * @return The JavaFX primary stage.
     */
    public Stage get() {
        if (!initialized) {
            throw new MainStageNotInitializedException();
        }

        return this.stage;
    }

}
