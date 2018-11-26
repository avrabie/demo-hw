package club.cheapok.fromJava5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class MyInvokeAll {

    private static ExecutorService executorService;
    private static Random random = new Random();

    private static Callable<String> myCallable = () -> {
        final int millis = random.nextInt(3000);
        Thread.sleep(millis);
        System.out.println(Thread.currentThread().getName()+" has worked around "+millis);
        return Thread.currentThread().getName();
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> myList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            myList.add(() -> {
                Thread.sleep(random.nextInt(3000));
                return Thread.currentThread().getName();});
        }
        final List<Future<String>> futures = executorService.invokeAll(myList);
        for (Future<String> future : futures) {
            if (future.isDone()) {
                System.out.println(future.get());
            }
        }
        executorService.shutdown();
    }


}
