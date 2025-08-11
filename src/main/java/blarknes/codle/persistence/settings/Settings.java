package blarknes.codle.persistence.settings;

import static jakarta.persistence.EnumType.STRING;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Database table to store the user preferred settings.
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Settings {

    @Id
    private final Long id = 1L;

    private int stageWidth;
    private int stageHeight;
    private boolean isFullScreen;

    @Enumerated(STRING)
    private Language language;

}
