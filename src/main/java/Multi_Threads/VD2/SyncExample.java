package Multi_Threads.VD2;

class BankAccount {
    private int balance = 1000;

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " đang rút " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " rút thành công! Số dư còn lại: " + balance);
        } else {
            System.out.println("Không đủ tiền cho " + Thread.currentThread().getName());
        }
    }
}

public class SyncExample {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(700), "Thread 1");
        Thread t2 = new Thread(() -> account.withdraw(500), "Thread 2");

        t1.start();
        t2.start();
    }
}

