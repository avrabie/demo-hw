package club.cheapok.formating;

public class FormatingDemo {
    public final static String MISSING_MANDATORY_CONFIGURATION_PARAMETER = "Missing mandatory plugin configuration parameter: %s";

    public static void main(String[] args) {
        System.out.println(String.format(MISSING_MANDATORY_CONFIGURATION_PARAMETER, "Some String"));
    }

}
