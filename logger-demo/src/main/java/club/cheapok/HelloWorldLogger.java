package club.cheapok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldLogger {
        private static Logger logger = LoggerFactory.getLogger(HelloWorldLogger.class);

    public static void main(String[] args) {
        logger.info("Hello from Logger");
        Apple a = new Apple(3);
        a.setX(10);
    }

}
