package Section12;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       while (true){
           try {
               int a = scanner.nextInt();
               int b = scanner.nextInt();
               int tong =a + b;
               System.out.println("tong : " + tong);
               break;
           } catch (Exception e) {
               System.out.println("vui long nhap hop le dinh dang");
               scanner.nextLine();
           }
       }


    }
}
