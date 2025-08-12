package blarknes.codle.graphics.screens.home;

import static org.controlsfx.glyphfont.FontAwesome.Glyph.BAR_CHART;
import static org.controlsfx.glyphfont.FontAwesome.Glyph.GEARS;

import org.springframework.stereotype.Component;

import blarknes.codle.graphics.assets.IconButton;
import blarknes.codle.graphics.screens.Screen;
import blarknes.codle.graphics.stage.MainStage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lombok.val;

/**
 * Wrapper for the home scene that renders visual components and performs
 * actions related to this screen.
 */
@Component
public class HomeScreen extends Screen {

    public HomeScreen(final MainStage mainStage) {
        super(mainStage);
    }

    protected void populate(final VBox root) {
        val todo = new Text("TODO: implement the home screen");

        val gearButton = new IconButton(GEARS);
        val chartButton = new IconButton(BAR_CHART);

        root.getChildren().addAll(todo, gearButton, chartButton);
    }

}
