package club.cheapok.fromJava5.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    AtomicInteger counter = new AtomicInteger(0);

    public void increment() {
        counter.getAndIncrement();
    }

    public int getCounter() {
        return counter.get();
    }
}
