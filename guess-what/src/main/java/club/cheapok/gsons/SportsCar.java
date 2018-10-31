package club.cheapok.gsons;

import java.util.ArrayList;
import java.util.List;

public class SportsCar {
    public String brand = null;
    public int    doors = 0;
    public List<Integer> iaka = new ArrayList<>();


    private SportsCar(String brand,
                      int doors) {
        this.brand = brand;
        this.doors = doors;
    }


    @Override
    public String toString() {
        return "SportsCar{" + "brand='" + brand + '\'' + ", doors=" + doors + ", iaka=" + iaka + '}';
    }
}
