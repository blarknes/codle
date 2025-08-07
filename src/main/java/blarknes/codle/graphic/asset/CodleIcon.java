package blarknes.codle.graphic.asset;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import lombok.val;

public class CodleIcon {

    private static final String ICON_IMAGE_PATH = "/icon.png";

    public Image asImage() {
        val icon = new Image(CodleIcon.class.getResourceAsStream(ICON_IMAGE_PATH));

        return icon;
    }

    public Pane asPane() {
        val background = background();
        val innerSquare = innerSquare();
        val yellowSquare = yellowSquare();
        val greenSquare = greenSquare();
        val consoleSVG = consoleSVG();
        val icon = new Pane(background, innerSquare, yellowSquare, greenSquare, consoleSVG);

        return icon;
    }

    private Rectangle background() {
        val rectangle = new Rectangle(128, 128);
        rectangle.setArcWidth(36);
        rectangle.setArcHeight(36);
        rectangle.setFill(CustomColor.NIGHT);

        return rectangle;
    }

    private Rectangle innerSquare() {
        val rectangle = new Rectangle(12, 12, 104, 104);
        rectangle.setArcWidth(16);
        rectangle.setArcHeight(16);
        rectangle.setFill(CustomColor.ONYX);

        return rectangle;
    }

    private Rectangle yellowSquare() {
        val rectangle = new Rectangle(89, 30, 20, 20);
        rectangle.setArcWidth(8);
        rectangle.setArcHeight(8);
        rectangle.setFill(CustomColor.SATINSHEENGOLD);

        return rectangle;
    }

    private Rectangle greenSquare() {
        val rectangle = new Rectangle(89, 54, 20, 20);
        rectangle.setArcWidth(8);
        rectangle.setArcHeight(8);
        rectangle.setFill(CustomColor.SEAGREEN);

        return rectangle;
    }

    private SVGPath consoleSVG() {
        val path = new SVGPath();
        path.setContent("m60.408 68.022-32.39 28.614c-3.118 2.753-8.065 1.121-8.903-2.939-0.392-1.883 0.259-3.832 1.705-5.109l27.85-24.59-27.85-24.59c-3.117-2.754-2.064-7.828 1.894-9.133 1.834-0.607 3.857-0.193 5.304 1.084l32.39 28.615c2.437 2.136 2.437 5.912 0 8.048m43.187 19.225h-43.187c-4.156 0-6.753 4.471-4.675 8.047 0.964 1.661 2.745 2.682 4.675 2.682h43.187c4.154 0 6.752-4.47 4.674-8.047-0.964-1.66-2.747-2.682-4.674-2.682");
        path.setFill(CustomColor.SEASALT);

        return path;
    }

}
