package blarknes.codle.ui;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.lifecycle.StartupEvent;
import blarknes.codle.ui.screen.ScreenRouter;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WindowManager {

    private final MainStage mainStage;
    private final ScreenRouter screenRouter;

    private Stage stage;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        this.stage = event.getStage();

        mainStage.initialize(this.stage);
        screenRouter.showHomeScreen(this.stage);

        this.stage.show();
    }

}
