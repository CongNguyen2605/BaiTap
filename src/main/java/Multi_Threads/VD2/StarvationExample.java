package Multi_Threads.VD2;

//class Worker extends Thread {
//    private final int priority;
//
//    public Worker(String name, int priority) {
//        super(name);
//        this.priority = priority;
//        setPriority(priority);
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println(getName() + " đang chạy với ưu tiên " + priority);
//            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
//        }
//    }
//}
//
//public class StarvationExample {
//    public static void main(String[] args) {
//        Worker highPriority = new Worker("HighPriority", Thread.MAX_PRIORITY);
//        Worker lowPriority = new Worker("LowPriority", Thread.MIN_PRIORITY);
//
//        highPriority.start();
//        lowPriority.start();
//    }
//}

import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;

class Starvation {
    private static final Lock lock = new ReentrantLock(true); // Công bằng

    public static void main(String[] args) {
        Runnable task = () -> {
            while (true) {
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " đang chạy...");
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
                finally {
                    lock.unlock();
                }
            }
        };

        Thread high1 = new Thread(task, "High-Priority-1");
        Thread high2 = new Thread(task, "High-Priority-2");
        Thread high3 = new Thread(task, "High-Priority-3");
        Thread low = new Thread(task, "Low-Priority");

        high1.setPriority(Thread.MAX_PRIORITY);
        high2.setPriority(Thread.MAX_PRIORITY);
        high3.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        high1.start();
        high2.start();
        high3.start();
        low.start();
    }
}

