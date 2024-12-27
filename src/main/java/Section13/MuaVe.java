package Section13;

public class MuaVe {

        private int ve = 1;
        public synchronized void muave(){
            if (ve > 0){
                System.out.println("mua ve thanh cong");
                ve--;
            }
            else {
                System.out.println("het ve");
            }
        }


    public static void main(String[] args) {
       MuaVe muaVe = new MuaVe();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2 da ");
                muaVe.muave();
            }
        });
       Thread thread1 = new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("Thread 1 da");
               muaVe.muave();
           }
       });

        MuaVe muaVe1 = new MuaVe();

        muaVe.muave();
        muaVe1.muave();
        thread1.start();
        thread2.start();



    }
}
