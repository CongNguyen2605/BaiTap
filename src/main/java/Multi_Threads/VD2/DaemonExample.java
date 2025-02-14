package Multi_Threads.VD2;

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Daemon thread đang chạy...");
            try {
                Thread.sleep(1000); // Ngủ 1 giây
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class DaemonExample {
    public static void main(String[] args) {
        MyDaemonThread daemonThread = new MyDaemonThread();
        daemonThread.setDaemon(true); // Đặt thành daemon thread
        daemonThread.start();

        System.out.println("Main thread đang kết thúc...");


        //kiem tra xem luong daemon khong
        Thread t1 = new Thread(() -> System.out.println("Luồng 1"));
        Thread t2 = new Thread(() -> System.out.println("Luồng 2"));

        t1.setDaemon(true);
        System.out.println("t1 là daemon? " + t1.isDaemon());
        System.out.println("t2 là daemon? " + t2.isDaemon());
    }
}