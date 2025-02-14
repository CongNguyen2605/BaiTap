package Multi_Threads.VD2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CachedThreadTask implements Runnable {
    private final int taskId;

    public CachedThreadTask(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " đang xử lý Task-" + taskId);
        try {
            Thread.sleep(1000); // Giả lập xử lý công việc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " hoàn thành Task-" + taskId);
    }
}

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool(); // Thread Pool tự động mở rộng

        for (int i = 1; i <= 6; i++) {
            executor.execute(new CachedThreadTask(i)); // Gửi 6 task vào Thread Pool
        }

        executor.shutdown();
    }
}
