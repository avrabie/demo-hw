package club.cheapok.java.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyObservableImpl implements MyObservable {

    List<Observer> observers = new ArrayList<>();
    private int changableValue;


    public MyObservableImpl(int changableValue) {
        this.changableValue = changableValue;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(Object obj) {
        observers.stream().forEach(observer -> observer.update(this, obj));

    }

    public int getChangableValue() {
        return changableValue;
    }

    public void setChangableValue(int changableValue) {
        this.changableValue = changableValue;
        int anInt = ThreadLocalRandom.current().nextInt(10);

        notifyObservers(Integer.valueOf(anInt));
    }
}
