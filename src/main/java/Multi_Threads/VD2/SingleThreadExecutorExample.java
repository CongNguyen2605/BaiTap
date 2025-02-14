package Multi_Threads.VD2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingleThreadTask implements Runnable {
    private final int taskId;

    public SingleThreadTask(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " đang xử lý Task-" + taskId);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " hoàn thành Task-" + taskId);
    }
}

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor(); // Dùng 1 luồng duy nhất

        for (int i = 1; i <= 5; i++) {
            executor.execute(new SingleThreadTask(i));
        }

        executor.shutdown();
    }
}
