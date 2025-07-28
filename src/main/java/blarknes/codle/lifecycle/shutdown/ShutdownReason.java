package blarknes.codle.lifecycle.shutdown;

import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.FAILURE;
import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.SUCCESS;

public record ShutdownReason(
    ShutdownStatus status,
    String message
) {

    private static final String SUCCESS_MESSAGE = "Application finished gracefully.";
    private static final String FAILURE_MESSAGE_TEMPLATE = "Application finished an error: %s.";

    public static ShutdownReason success() {
        return new ShutdownReason(SUCCESS, SUCCESS_MESSAGE);
    }

    public static ShutdownReason failure(final String message) {
        return new ShutdownReason(FAILURE, String.format(FAILURE_MESSAGE_TEMPLATE, message));
    }

}
