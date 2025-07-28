package blarknes.codle.lifecycle.shutdown;

import static blarknes.codle.lifecycle.shutdown.ShutdownStatus.FAILURE;

import org.springframework.stereotype.Component;

import lombok.val;
import lombok.extern.apachecommons.CommonsLog;

@Component
@CommonsLog
public class Shutdown {

    public static void internalShutdown(final ShutdownReason reason) {
        val status = reason.status();

        if (status == FAILURE) {
            log.error(reason.message());
        } else {
            log.info(reason.message());
        }

        System.exit(status.getCode());
    }

    public void shutdown(final ShutdownReason reason) {
        Shutdown.internalShutdown(reason);
    }

}
