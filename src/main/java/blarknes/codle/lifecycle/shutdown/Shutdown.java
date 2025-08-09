package blarknes.codle.lifecycle.shutdown;

import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.FAILURE;

import lombok.val;
import lombok.extern.apachecommons.CommonsLog;

/**
 * Manages and performs all operations related to the shutdown of the
 * application.
 */
@CommonsLog
public class Shutdown {

    private static final String SUCCESS_MESSAGE_TEMPLATE = "\u001B[32m%s\u001B[0m";
    private static final String FAILURE_MESSAGE_TEMPLATE = "\u001B[31m%s\u001B[0m";

    /**
     * Terminates the whole application and logs information accordingly based on
     * the reason provided.
     *
     * @param reason the reason to terminate the application
     */
    public void terminate(final ShutdownReason reason) {
        val status = reason.status();

        if (status == FAILURE) {
            log.error(String.format(FAILURE_MESSAGE_TEMPLATE, reason.message()));
        } else {
            log.info(String.format(SUCCESS_MESSAGE_TEMPLATE, reason.message()));
        }

        System.exit(status.getCode());
    }

}
