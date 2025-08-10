package blarknes.codle.graphics.stage.exception;

/**
 * {@code MainStageIsNullException} Is the exception thrown when trying to set
 * the main stage as null.
 */
public class MainStageIsNullException extends IllegalArgumentException {

    public MainStageIsNullException() {
        super("The Main Stage provided when initializing is null");
    }

}
