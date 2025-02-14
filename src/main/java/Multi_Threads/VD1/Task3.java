package Multi_Threads.VD1;

public class Task3 extends Thread {
    @Override
    public void run() {
        for (int i = 0 ; i<5;i++){
            System.out.println(Thread.currentThread().getName() + "dang chay ..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Task3();
        Thread t2 = new Task3();
        t1.start();
        t1.join();
        t2.start();
    }
}
