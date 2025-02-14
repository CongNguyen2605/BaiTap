package Multi_Threads.VD2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> taskList = Arrays.asList(
                () -> { Thread.sleep(1000); return "Task 1 hoàn thành"; },
                () -> { Thread.sleep(2000); return "Task 2 hoàn thành"; },
                () -> { Thread.sleep(1500); return "Task 3 hoàn thành"; }
        );

        try {
            List<Future<String>> results = executor.invokeAll(taskList);

            for (Future<String> future : results) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
