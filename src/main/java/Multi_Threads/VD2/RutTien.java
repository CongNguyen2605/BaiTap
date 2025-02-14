package Multi_Threads.VD2;

public class RutTien extends Thread {
    private int tien = 15000;

    @Override
    public  void run() {
        if (tien > 10000) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tien -= 10000;
            System.out.println("Số dư sau khi rút: " + tien);
        } else {
            System.out.println("Không đủ tiền");
        }
    }

    public static void main(String[] args) {
        RutTien rutTien = new RutTien();

        Thread t1 = new Thread(rutTien);
        Thread t2 = new Thread(rutTien);

        t1.start();
        t2.start();
    }
}
