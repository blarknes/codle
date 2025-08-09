package blarknes.codle.lifecycle.shutdown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The status of a shutdown reason to be used in a termination process.
 */
@Getter
@RequiredArgsConstructor
public enum ShutdownStatus {

    SUCCESS(0),
    FAILURE(1);

    private final int code;

}
