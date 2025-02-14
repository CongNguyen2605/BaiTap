package Multi_Threads.VD2;

class Customer {
    private int amount = 1000;

    synchronized void withdraw(int amount) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " chuẩn bị rút tiền...");

        // Kiểm tra số dư, nếu không đủ thì đợi
        while (this.amount < amount) {
            System.out.println("Không đủ tiền! Đang chờ nạp thêm...");
            wait();  // Chờ cho đến khi có notify()
        }

        this.amount -= amount;
        System.out.println(Thread.currentThread().getName() + " rút thành công " + amount + ". Số dư còn lại: " + this.amount);
    }

    synchronized void deposit(int amount) {
        System.out.println(Thread.currentThread().getName() + " chuẩn bị nạp tiền...");
        this.amount += amount;
        System.out.println(Thread.currentThread().getName() + " nạp thành công " + amount + ". Số dư hiện tại: " + this.amount);
        notify(); // Đánh thức một luồng đang chờ
    }
}

public class wait_notify {
    public static void main(String[] args) {
        final Customer c = new Customer();

        Thread t1 = new Thread(() -> {
            try {
                c.withdraw(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-Rút");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Đảm bảo nạp tiền xảy ra sau khi rút
                c.deposit(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread-Nạp");

        t1.start();
        t2.start();
    }
}
