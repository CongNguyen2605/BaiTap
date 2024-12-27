package Section9.Bai1.Model;

import java.util.Scanner;

public class Dog extends Animal{
    private long id;
    private String ten;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap id");
        id = scanner.nextLong();
        System.out.println("nhap ten");
        ten = scanner.next();
    }

    @Override
    public void infor() {
        System.out.println(id + "-" + ten);
    }
}
