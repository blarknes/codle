// OK
package blarknes.codle;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Launcher {

    public static void main(final String[] args) {
        Main.start(Launcher.class, args);
    }

}
