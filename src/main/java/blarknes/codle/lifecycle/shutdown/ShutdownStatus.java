package blarknes.codle.lifecycle.shutdown;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ShutdownStatus {

    SUCCESS(0),
    FAILURE(1);

    private final int code;

}
