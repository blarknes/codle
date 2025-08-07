package blarknes.codle.graphic;

import org.springframework.stereotype.Component;

import javafx.stage.Stage;

@Component
public class MainStage {

    private Stage stage;
    private boolean initialized = false;

    public synchronized void set(final Stage stage) {
        if (initialized) {
            // throw TODO: add throw
        }

        if (null == stage) {
            // throw TODO: add throw
        }

        this.stage = stage;
        this.initialized = true;
    }

    public Stage get() {
        if (!initialized) {
            // throw TODO: add throw
        }

        return this.stage;
    }

}
