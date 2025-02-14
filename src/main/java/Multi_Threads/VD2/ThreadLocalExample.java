package Multi_Threads.VD2;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Runnable task = () -> {
            int value = threadLocalValue.get(); // Lấy giá trị cục bộ của luồng
            threadLocalValue.set(value + 1); // Tăng giá trị lên
            System.out.println(Thread.currentThread().getName() + " => " + threadLocalValue.get());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

