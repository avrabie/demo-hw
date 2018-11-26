package club.cheapok.fromJava5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.print.DocFlavor.READER;

public class MySimpleFuture {
    Callable<String> aPromis = new Callable<String>() {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            return "Iaka result :)";
        }
    };
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newSingleThreadExecutor();
        MySimpleFuture mySimpleFuture = new MySimpleFuture();

        final Future<String> submit = service.submit(mySimpleFuture.aPromis);
        if (submit.isDone()) {
            System.out.println("Done");
            System.out.println(submit.get());
        } else {
            System.out.println("Not done, waiting");
            System.out.println(submit.get());
        }
        service.shutdown();


    }

}
