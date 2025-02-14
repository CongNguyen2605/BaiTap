package Multi_Threads.VD2;

//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
//public class LivelockExample {
//    private static final Lock lock1 = new ReentrantLock();
//    private static final Lock lock2 = new ReentrantLock();
//
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            while (true) {
//                if (lock1.tryLock()) {
//                    System.out.println("Thread-1 giữ lock1");
//                    try {
//                        Thread.sleep(50);
//                        if (lock2.tryLock()) {
//                            System.out.println("Thread-1 giữ lock2");
//                            lock2.unlock();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock1.unlock();
//                    }
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            while (true) {
//                if (lock2.tryLock()) {
//                    System.out.println("Thread-2 giữ lock2");
//                    try {
//                        Thread.sleep(50);
//                        if (lock1.tryLock()) {
//                            System.out.println("Thread-2 giữ lock1");
//                            lock1.unlock();
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        lock2.unlock();
//                    }
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
//}
import java.util.concurrent.locks.Lock;
        import java.util.concurrent.locks.ReentrantLock;
        import java.util.Random;

class SafeWorker {
    private final Lock lock = new ReentrantLock();
    private final Random random = new Random();

    public boolean tryWork(SafeWorker other) {
        int retryCount = 0;

        while (retryCount < 5) { // Giới hạn số lần thử lại
            if (lock.tryLock()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " đã lấy khóa " + this);
                    Thread.sleep(50);

                    if (other.lock.tryLock()) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " đã lấy khóa " + other);
                            return true;
                        } finally {
                            other.lock.unlock();
                        }
                    }
                } catch (InterruptedException ignored) {
                } finally {
                    lock.unlock();
                }
            }
            retryCount++;
            System.out.println(Thread.currentThread().getName() + " nhường quyền, thử lại lần " + retryCount);
            try {
                Thread.sleep(random.nextInt(100)); // Ngẫu nhiên hóa thời gian chờ
            } catch (InterruptedException ignored) {}
        }
        System.out.println(Thread.currentThread().getName() + " từ bỏ sau 5 lần thử.");
        return false;
    }
}

public class LivelockExample {
    public static void main(String[] args) {
        SafeWorker w1 = new SafeWorker();
        SafeWorker w2 = new SafeWorker();

        Thread t1 = new Thread(() -> w1.tryWork(w2), "Thread-1");
        Thread t2 = new Thread(() -> w2.tryWork(w1), "Thread-2");

        t1.start();
        t2.start();
    }
}

