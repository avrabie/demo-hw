package club.cheapok.java.observer;

public class ObserverImpl implements Observer {


    private int x;

    public ObserverImpl(int x) {
        this.x = x;
    }

    @Override
    public void update(MyObservable obs, Object update) {
        if (update instanceof Number) {
            x += (int)update;
        }
        System.out.println("Updated to "+x);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
