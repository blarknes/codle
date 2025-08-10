package blarknes.codle.graphics.stage.exception;

/**
 * {@code MainStageNotInitializedException} Is the exception thrown when trying
 * to get the main stage before initializing it.
 */
public class MainStageNotInitializedException extends IllegalStateException {

    public MainStageNotInitializedException() {
        super("The Main Stage was accessed before it's initialization");
    }

}
