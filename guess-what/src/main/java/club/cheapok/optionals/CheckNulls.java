package club.cheapok.optionals;

import java.util.Optional;

public class CheckNulls {

    private static final String NCSO = "NCSO";

    public static void main(String[] args) {

        String ncsoComponentName = "iaka";
        String subComponentName = (null != ncsoComponentName) ? "NCSO:" + ncsoComponentName : "NCSO";

        System.out.println(subComponentName);


        final String subComponentName2 = Optional.ofNullable(ncsoComponentName)
                                                .map(s -> NCSO + ":" + s)
                                                .orElse(NCSO);
        System.out.println(subComponentName2);
    }

}
