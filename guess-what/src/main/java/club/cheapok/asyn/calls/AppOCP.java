package club.cheapok.asyn.calls;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AppOCP {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = null;
        try{
            executorService = Executors.newSingleThreadExecutor();
            Future<?> iaka = executorService.submit(() -> System.out.println("Iaka"));
            iaka.get(100L, TimeUnit.MILLISECONDS);

        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

}
