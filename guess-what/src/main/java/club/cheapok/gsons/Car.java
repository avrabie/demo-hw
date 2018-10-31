package club.cheapok.gsons;

public class Car {
    public String brand = null;
    public int    doors = 0;


    private Car(String brand,
               int doors) {
        this.brand = brand;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", doors=" + doors + '}';
    }
}
