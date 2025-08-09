package blarknes.codle.lifecycle.shutdown;

import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.FAILURE;
import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.SUCCESS;

/**
 * The information of a shutdown to be used in the termination process.
 */
public record ShutdownReason(
    ShutdownStatus status,
    String message
) {

    private static final String SUCCESS_MESSAGE = "Application finished gracefully.";
    private static final String FAILURE_MESSAGE_TEMPLATE = "Application finished with errors: %s.";

    /**
     * Constructor that builds a ShutdownReason for success cases.
     *
     * @return The information about the shutdown reason.
     */
    public static ShutdownReason success() {
        return new ShutdownReason(SUCCESS, SUCCESS_MESSAGE);
    }

    /**
     * Constructor that builds a ShutdownReason for failure cases.
     * 
     * @param message the reason on why it failed
     * @return The information about the shutdown reason.
     */
    public static ShutdownReason failure(final String message) {
        return new ShutdownReason(FAILURE, String.format(FAILURE_MESSAGE_TEMPLATE, message));
    }

}
