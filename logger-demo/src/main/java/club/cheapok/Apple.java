package club.cheapok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Apple {

    private final Logger logger = LoggerFactory.getLogger(Apple.class);
    private int x;

    public Apple(int x) {

        this.x = x;
    }

    public void setX(int x) {
        logger.debug("Setting x!");
        this.x = x;
    }
}
