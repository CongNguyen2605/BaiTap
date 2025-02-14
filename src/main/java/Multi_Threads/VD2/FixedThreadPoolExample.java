package Multi_Threads.VD2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FixedThreadTask implements Runnable {
    private final int taskId;

    public FixedThreadTask(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " đang xử lý Task-" + taskId);
        try {
            Thread.sleep(2000); // Giả lập xử lý công việc
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " hoàn thành Task-" + taskId);
    }
}

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); // 3 luồng cố định

        for (int i = 1; i <= 6; i++) {
            executor.execute(new FixedThreadTask(i)); // Gửi 6 task vào Thread Pool
        }

        executor.shutdown();
    }
}
