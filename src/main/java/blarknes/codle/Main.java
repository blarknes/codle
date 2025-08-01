package blarknes.codle;

import static blarknes.codle.string.StringUtilities.EMPTY_STRING_ARRAY;

import java.util.Objects;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import blarknes.codle.lifecycle.StartupEvent;
import blarknes.codle.lifecycle.shutdown.Shutdown;
import blarknes.codle.lifecycle.shutdown.ShutdownReason;
import javafx.application.Application;
import javafx.stage.Stage;
import lombok.val;

public class Main extends Application {

    private static Class<Launcher> springApplicationClass;
    private ConfigurableApplicationContext springContext;

    private static final String SPRING_STARTUP_ERROR_MESSAGE = "Failed to initialize Spring Context";

    public static void start(final Class<Launcher> springApplicationClass, final String[] args) {
        Main.springApplicationClass = springApplicationClass;
        Application.launch(Main.class, args);
    }

    @Override
    public void init() {
        try {
            val parameters = getParameters().getRaw().toArray(EMPTY_STRING_ARRAY);

            springContext = new SpringApplicationBuilder()
                .sources(springApplicationClass)
                .run(parameters);

            if (Objects.isNull(springContext)) {
                throw new RuntimeException();
            }
        } catch (Exception exception) {
            Shutdown.internalShutdown(ShutdownReason.failure(SPRING_STARTUP_ERROR_MESSAGE));
        }
    }

    @Override
    public void start(final Stage stage) {
        springContext.publishEvent(new StartupEvent(stage));
    }

    @Override
    public void stop() {
        Shutdown.internalShutdown(ShutdownReason.success());
    }

}
