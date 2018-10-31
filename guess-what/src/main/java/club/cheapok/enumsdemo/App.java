package club.cheapok.enumsdemo;

import static club.cheapok.enumsdemo.MyEnums.IAKA1;
import static club.cheapok.enumsdemo.MyEnums.IAKA2;

import java.util.HashMap;
import java.util.Map;

public class App {

    private Map<String, Integer> myMap = new HashMap<>();

    {
        myMap.put("Adrian",10);
        myMap.put("Daniela",11);
        myMap.put("Natalia", 7);
        myMap.put("IAKA2", 8);
    }

    public static void main(String[] args) {
        System.out.println(IAKA1);
        App app = new App();
        System.out.println(app.myMap.get(IAKA1.toString()));
        System.out.println(app.myMap.get(IAKA2));
    }

}
