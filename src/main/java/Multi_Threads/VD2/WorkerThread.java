package Multi_Threads.VD2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerThread implements Runnable{
    private final String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " bắt đầu thực hiện " + taskName);
        try {
            Thread.sleep(2000); // Giả lập công việc mất 2 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " hoàn thành " + taskName);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3); // Tạo Thread Pool với 3 luồng

        for (int i = 1; i <= 5; i++) {
            Runnable worker = new WorkerThread("Công việc " + i);
            executorService.execute(worker); // Gửi công việc vào Thread Pool
        }

        executorService.shutdown(); // Đóng Thread Pool sau khi hoàn thành tất cả các công việc
        while (!executorService.isTerminated()) {
        }

        System.out.println("Tất cả công việc đã hoàn thành");
    }
}
