package blarknes.codle.lifecycle.shutdown;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ShutdownStatus {

    SUCCESS(0),
    FAILURE(1);

    private final int code;

}
