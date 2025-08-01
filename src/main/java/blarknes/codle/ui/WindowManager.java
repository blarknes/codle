package blarknes.codle.ui;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.lifecycle.StartupEvent;
import blarknes.codle.ui.screen.ScreenManager;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WindowManager {

    private final StageInitializer initializer;
    private final ScreenManager screenManager;

    private Stage stage;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        this.stage = event.getStage();

        initializer.initialize(this.stage);
        screenManager.showHomeScreen(this.stage);

        this.stage.show();
    }

}
