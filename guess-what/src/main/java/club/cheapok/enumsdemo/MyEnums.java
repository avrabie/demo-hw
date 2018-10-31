package club.cheapok.enumsdemo;

public enum MyEnums {
    IAKA1("Adrian"), IAKA2("Eugene");

    private String name;

    MyEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
