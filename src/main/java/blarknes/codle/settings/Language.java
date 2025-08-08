// OK
package blarknes.codle.settings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Language {

    EN("english"),
    PT("português"),
    ES("español");

    private final String name;

}
