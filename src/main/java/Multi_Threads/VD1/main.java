package Multi_Threads.VD1;

public class main {
    public static void main(String[] args) throws InterruptedException {
      Runnable task1 = new Task1("A",10);
      Thread t1 = new Thread(task1);
      Thread t2 = new Task2("B",5);
      t1.start();
      t2.start();

    }
}
