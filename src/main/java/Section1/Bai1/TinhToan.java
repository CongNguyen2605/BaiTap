package Section1.Bai1;

import java.util.Scanner;

public class TinhToan {
    public int TinhTong(int a , int b){
        return a+b;
    }
    public float TinhTong(float a , float b){
        return a+b;
    }
    public int TinhHieu(int a , int b){
        return a-b;
    }
    public float TinhHieu(float a , float b){
        return a-b;
    }
    public int TinhTich(int a , int b){
        return a*b;
    }
    public float TinhTich(float a , float b){
        return a*b;
    }
    public int TinhThuong(int a , int b){
        return a/b;
    }
    public float TinhThuong(float a , float b){
        return a/b;
    }



    public static void main(String[] args) {
        //bai 1
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        TinhToan tinhToan = new TinhToan();
        System.out.println(tinhToan.TinhTong(a,b));


        //bai4
        System.out.println(Math.sqrt(a));
        System.out.println(a*a);
        System.out.println(Math.PI*a);



    }
}
