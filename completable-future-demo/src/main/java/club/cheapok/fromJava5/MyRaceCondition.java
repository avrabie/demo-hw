package club.cheapok.fromJava5;

import club.cheapok.fromJava5.entity.SillyCounter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MyRaceCondition {

   /* public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        Counter counter = new Counter();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> counter.increment());
        }
        executorService.awaitTermination(15, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println("res: "+counter.getCounter());

    }*/

    public static void main(String[] args) throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(10);
        SillyCounter sillyCounter = new SillyCounter();
        for (int i = 0; i < 10000; i++) {
            executorService.submit(() -> sillyCounter.increase());
        }
        executorService.awaitTermination(100, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println(sillyCounter.getCounter());

    }

}
