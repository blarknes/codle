package blarknes.codle.graphics;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import blarknes.codle.graphics.stage.MainStage;
import blarknes.codle.lifecycle.StartupEvent;
import lombok.RequiredArgsConstructor;
import lombok.val;

/**
 * Manages and performs routing operations to deletage what is displayed on the
 * screen.
 */
@Component
@RequiredArgsConstructor
public class Router {

    private final MainStage mainStage;

    @EventListener
    public void onStartupEvent(final StartupEvent event) {
        val stage = event.getStage();
        mainStage.set(stage);

        stage.show();
    }

}
