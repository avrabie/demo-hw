package club.cheapok.java.basics;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        MyObservable myObservable1 = new MyObservable();
        MyObservable myObservable2 = new MyObservable();

        Observer observer = (obs, arg) -> System.out.println("Received response: " + arg);

        myObservable1.addObserver(observer);
        myObservable2.addObserver(observer);

        new Thread(myObservable1).start();
        new Thread(myObservable2).start();
    }
}

class MyObservable extends Observable implements Runnable {
    public void run() {
        while (true) {
            String response = new Scanner(System.in).next();
            super.setChanged();
            super.notifyObservers(response);
        }
    }
}
