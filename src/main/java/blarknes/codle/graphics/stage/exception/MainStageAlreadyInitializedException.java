package blarknes.codle.graphics.stage.exception;

/**
 * {@code MainStageAlreadyInitializedException} Is the exception thrown when
 * trying to set the main stage when it's already initialized.
 */
public class MainStageAlreadyInitializedException extends IllegalArgumentException {

    public MainStageAlreadyInitializedException() {
        super("The Main Stage is already initialized when trying to initialize it");
    }

}
