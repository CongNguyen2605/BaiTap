package Multi_Threads.VD2;

class SharedDataVolatile {
    volatile boolean running = true; // Đảm bảo luôn lấy giá trị từ bộ nhớ chính

    void stop() {
        running = false;
    }
}

public class VolatileExample {
    public static void main(String[] args) {
        SharedDataVolatile data = new SharedDataVolatile();

        Thread t1 = new Thread(() -> {
            while (data.running) { }
            System.out.println("Thread 1 kết thúc.");
        });

        t1.start();

        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        data.stop(); // Ngay lập tức được cập nhật cho tất cả luồng
        System.out.println("Yêu cầu dừng luồng.");
    }
}
