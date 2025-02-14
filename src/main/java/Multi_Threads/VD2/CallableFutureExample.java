package Multi_Threads.VD2;

import java.util.concurrent.*;

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " đang tính toán...");
        Thread.sleep(2000); // Giả lập xử lý
        return 10 + 20;
    }
}

public class CallableFutureExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> callableTask = new MyCallable();
        Future<Integer> future = executor.submit(callableTask);

        try {
            System.out.println("Kết quả tính toán: " + future.get()); // Chờ kết quả
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
