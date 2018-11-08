package club.cheapok.propertyGet;

import java.util.Properties;

public class SystemPropertyGet {

    public static void main(String[] args) {
        String SIMULATOR_URL = System.getProperty("simulatorURL");
        Properties properties = System.getProperties();
        System.out.println(SIMULATOR_URL);
        System.out.println("Hello World ¯\\_(ツ)_/¯");
    }

}
