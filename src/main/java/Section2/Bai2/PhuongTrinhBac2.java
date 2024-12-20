package Section2.Bai2;

import java.util.Scanner;

public class PhuongTrinhBac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        float x1;
        float x2;
        float delta = (b*b) - (4 *a * c);

        if (a == 0){
            if (b == 0){
                System.out.println("phuong trinh vo nghiem");
            }
            else {
                System.out.println("phuong trinh co nghiem duy nhat" + (-c/b));
            }
        }
        if (delta>0){
            x1 = (float) (-b + Math.sqrt(delta)) / (2*a);
            x2 = (float) (-b - Math.sqrt(delta)) / (2*a);
            System.out.println(" phuong trinh co 2 nghiem la : "
            + "x1 :" +x1 + " \n x2:" + x2
            );
        }
        else if (delta == 0){
            x1 = (-b / (2 * a));
            System.out.println("phuong trinh co nghiem kep la " + x1);
        }
        else {
            System.out.println("phuong trinh vo nghiem");
        }
    }
}
