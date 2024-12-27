package Section9.Bai1.Model;

import java.util.Scanner;

public class Animal {
    private long id;
    private String tenGiong;
    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        id = scanner.nextLong();
        System.out.println("nhap ten giong");
        tenGiong = scanner.next();
    }
    public void infor(){
        System.out.println(id);
        System.out.println(tenGiong);
    }
}
