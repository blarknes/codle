package blarknes.codle;

import java.util.Objects;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import blarknes.codle.lifecycle.StartupEvent;
import blarknes.codle.lifecycle.shutdown.Shutdown;
import blarknes.codle.lifecycle.shutdown.ShutdownReason;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.val;

public class Launcher extends Application {

    private static Class<Main> springClass;
    private ConfigurableApplicationContext context;

    private static final Shutdown shutdown = new Shutdown();
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String SPRING_STARTUP_ERROR_MESSAGE = "Failed to initialize Spring Context";

    public static void start(final Class<Main> springClass, final String[] args) {
        Launcher.springClass = springClass;
        Application.launch(Launcher.class, args);
    }

    @Override
    public void init() {
        try {
            val parameters = getParameters().getRaw().toArray(EMPTY_STRING_ARRAY);

            context = new SpringApplicationBuilder()
                .sources(springClass)
                .run(parameters);

            if (Objects.isNull(context)) {
                throw new RuntimeException();
            }
        } catch (Exception exception) {
            shutdown.terminate(ShutdownReason.failure(SPRING_STARTUP_ERROR_MESSAGE));
        }
    }

    @Override
    public void start(final Stage stage) {
        try {
            context.publishEvent(new StartupEvent(stage));
        } catch (Exception e) {
            shutdown.terminate(ShutdownReason.failure(e.getMessage()));
        }
    }

    @Override
    public void stop() {
        shutdown.terminate(ShutdownReason.success());
    }

}
