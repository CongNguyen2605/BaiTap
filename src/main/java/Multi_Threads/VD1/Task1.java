package Multi_Threads.VD1;

public class Task1 implements Runnable{
    private String name;
    private int num;

    public Task1(String name, int num) {
        this.name = name;
        this.num = num;
    }



    @Override
    public void run() {
        for (int i = 0 ; i < this.num;i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name);
        }
    }
}
