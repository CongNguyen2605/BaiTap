package Section1.Bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();


        System.out.println(HinhTron.tinhDienTich(a));
        System.out.println(HinhChuNhat.tinhDienTich(a,b));
        System.out.println(TamGiacVuong.TinhDienTich(a,b));

    }
}
