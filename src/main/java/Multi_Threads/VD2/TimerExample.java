package Multi_Threads.VD2;

import java.util.Timer;
import java.util.TimerTask;

public class TimerExample {
    public static void main(String[] args) {
        Timer timer = new Timer(); // Tạo bộ đếm thời gian

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tác vụ chạy sau 3 giây: " + System.currentTimeMillis());
            }
        };
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tác vụ chạy sau 3 giây: " + System.currentTimeMillis());
            }
        };

        timer.schedule(task, 3000,3000); // Chạy sau 3 giâyti
        timer.schedule(task1, 3000,3000);
    }
}

