package club.cheapok.java;

import club.cheapok.java.observer.MyObservable;
import club.cheapok.java.observer.MyObservableImpl;
import club.cheapok.java.observer.Observer;
import club.cheapok.java.observer.ObserverImpl;

public class Iaka {
    public static void main(String[] args) {
        Observer obs1 = new ObserverImpl(10);
        Observer obs2 = new ObserverImpl(5);
        MyObservable observable = new MyObservableImpl(1);
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        ((MyObservableImpl) observable).setChangableValue(2);
    }
}
