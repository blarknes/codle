package blarknes.codle.settings;

import static blarknes.codle.settings.Language.EN;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.val;

@Service
@RequiredArgsConstructor
public class SettingsService {

    private final SettingsRepository settingsRepository;

    private static final int INITIAL_STAGE_WIDTH = 1366;
    private static final int INITIAL_STAGE_HEIGHT = 768;
    private static final boolean INITIAL_FULL_SCREEN = false;
    private static final Language INITIAL_LANGUAGE = EN;
    private static final Settings INITIAL_SETTINGS = Settings.builder()
        .stageWidth(INITIAL_STAGE_WIDTH)
        .stageHeight(INITIAL_STAGE_HEIGHT)
        .isFullScreen(INITIAL_FULL_SCREEN)
        .language(INITIAL_LANGUAGE)
        .build();

    @PostConstruct
    public void initializeSettings() {
        val isDatabaseEmpty = settingsRepository.count() == 0;

        if (isDatabaseEmpty) {
            settingsRepository.save(INITIAL_SETTINGS);
        }
    }

    public Settings getSettings() {
        return settingsRepository.findSettings().orElse(INITIAL_SETTINGS);
    }

    public void setStageWidth() {
        val settings = getSettings();
        settings.setStageWidth(1920);
        settingsRepository.save(settings);
    }

}
