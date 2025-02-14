package Multi_Threads.VD2;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> System.out.println("Tác vụ chạy sau 3 giây: " + System.currentTimeMillis());

        scheduler.schedule(task, 3, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(task, 3,2, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
