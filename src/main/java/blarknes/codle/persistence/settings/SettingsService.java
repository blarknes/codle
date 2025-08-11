package blarknes.codle.persistence.settings;

import static blarknes.codle.persistence.settings.Language.EN;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * Performs all operations related to the game settings.
 */
@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository settingsRepository;

    private static final Long SETTINGS_ID = 1L;

    private static final int DEFAULT_STAGE_WIDTH = 1366;
    private static final int DEFAULT_STAGE_HEIGHT = 768;
    private static final boolean DEFAULT_FULL_SCREEN = false;
    private static final Language DEFAULT_LANGUAGE = EN;

    @PostConstruct
    public void initialize() {
        val isDatabaseEmpty = !settingsRepository.existsById(SETTINGS_ID);

        if (isDatabaseEmpty) {
            createDefaultSettings();
        }
    }

    /**
     * Get the user preferred settings from the database.
     *
     * @return The user settings.
     */
    public Settings get() {
        return settingsRepository.getReferenceById(SETTINGS_ID);
    }

    private void createDefaultSettings() {
        val settings = Settings.builder()
            .stageWidth(DEFAULT_STAGE_WIDTH)
            .stageHeight(DEFAULT_STAGE_HEIGHT)
            .isFullScreen(DEFAULT_FULL_SCREEN)
            .language(DEFAULT_LANGUAGE)
            .build();

        settingsRepository.save(settings);
    }

}
