package Multi_Threads.VD2;

class Resource {
    void methodA(Resource other) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " đã khóa " + this);
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (other) {
                System.out.println(Thread.currentThread().getName() + " đã khóa " + other);
            }
        }
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        Thread t1 = new Thread(() -> r1.methodA(r2), "Thread-1");
        Thread t2 = new Thread(() -> r2.methodA(r1), "Thread-2");

        t1.start();
        t2.start();
    }
}
//import java.util.concurrent.locks.Lock;
//        import java.util.concurrent.locks.ReentrantLock;
//
//class Resource {
//    private final Lock lock = new ReentrantLock();
//
//    public boolean tryAccess(Resource other) {
//        try {
//            // Thử khóa tài nguyên hiện tại trong 100ms
//            if (lock.tryLock()) {
//                System.out.println(Thread.currentThread().getName() + " đã khóa " + this);
//                try {
//                    Thread.sleep(50);
//                    // Thử khóa tài nguyên còn lại
//                    if (other.lock.tryLock()) {
//                        try {
//                            System.out.println(Thread.currentThread().getName() + " đã khóa " + other);
//                            return true; // Thành công
//                        } finally {
//                            other.lock.unlock(); // Giải phóng khóa tài nguyên khác
//                        }
//                    }
//                } finally {
//                    lock.unlock(); // Giải phóng khóa tài nguyên hiện tại
//                }
//            }
//        } catch (InterruptedException ignored) {}
//        System.out.println(Thread.currentThread().getName() + " không thể khóa cả hai tài nguyên, thử lại...");
//        return false;
//    }
//}
//
//public class DeadlockExample {
//    public static void main(String[] args) {
//        Resource r1 = new Resource();
//        Resource r2 = new Resource();
//
//        Runnable task1 = () -> {
//            while (!r1.tryAccess(r2)) {
//                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
//            }
//        };
//
//        Runnable task2 = () -> {
//            while (!r2.tryAccess(r1)) {
//                try { Thread.sleep(50); } catch (InterruptedException ignored) {}
//            }
//        };
//
//        Thread t1 = new Thread(task1, "Thread-1");
//        Thread t2 = new Thread(task2, "Thread-2");
//
//        t1.start();
//        t2.start();
//    }
//}
//

