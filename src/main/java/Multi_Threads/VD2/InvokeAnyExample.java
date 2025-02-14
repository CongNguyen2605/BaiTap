package Multi_Threads.VD2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAnyExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<String>> taskList = Arrays.asList(
                () -> { Thread.sleep(1000); return "Task 1 hoàn thành"; },
                () -> { Thread.sleep(200); return "Task 2 hoàn thành nhanh nhất"; },
                () -> { Thread.sleep(1500); return "Task 3 hoàn thành"; }
        );

        try {
            String result = executor.invokeAny(taskList);
            System.out.println("Kết quả đầu tiên nhận được: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

