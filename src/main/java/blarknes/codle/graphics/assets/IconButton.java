package blarknes.codle.graphics.assets;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.Glyph;

import javafx.scene.control.Button;

/**
 * Custon implementation of a button component that displays only an icon and no
 * text.
 */
public class IconButton extends Button {

    private static final String FONT_AWESOME_FONT_FAMILY = "FontAwesome";

    public IconButton(final FontAwesome.Glyph icon) {
        super("", new Glyph(FONT_AWESOME_FONT_FAMILY, icon));
    }

}
