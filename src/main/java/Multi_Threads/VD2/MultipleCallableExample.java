package Multi_Threads.VD2;

import java.util.concurrent.*;

class MyTask implements Callable<String> {
    private final int taskId;

    public MyTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Task " + taskId + " hoàn thành bởi " + Thread.currentThread().getName();
    }
}

public class MultipleCallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = new MyTask(1);
        Callable<String> task2 = new MyTask(2);
        Callable<String> task3 = new MyTask(3);

        Future<String> future1 = executor.submit(task1);
        Future<String> future2 = executor.submit(task2);
        Future<String> future3 = executor.submit(task3);

        try {
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
