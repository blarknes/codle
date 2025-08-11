package blarknes.codle.persistence.settings;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The preferred language by the user to be used to display the text contents on
 * the application.
 */
@Getter
@RequiredArgsConstructor
public enum Language {

    EN("english"),
    PT("português");

    private final String name;

}
