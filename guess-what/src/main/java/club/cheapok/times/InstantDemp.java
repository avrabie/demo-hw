package club.cheapok.times;

import java.time.Instant;
import java.util.Date;

public class InstantDemp {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(Date.from(instant));
    }

}
