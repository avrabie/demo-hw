package club.cheapok.gsons;

import com.google.gson.Gson;

public class MyGsonParser {

    public static void main(String[] args) {
        // default oconstructor? NO
        // getters and setters? NO
        // constructor with all params? NO!
        // private constructor? WORKS!
        // case sensitive YES!


        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        String json2 = "{\"brand\":\"Jeep\", \"doors\": 3, \"iaka\":[3,5,9]}";
        Gson gson = new Gson();
        Car car = gson.fromJson(json, Car.class);
        SportsCar sportsCar = gson.fromJson(json2, SportsCar.class);

        System.out.println(car);
        System.out.println(sportsCar.iaka.get(1));
    }

}
