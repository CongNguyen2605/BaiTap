package Section8.Bai2.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private long id;
    private String ten;
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ID:");
        id = scanner.nextLong();
        scanner.nextLine(); // Consume newline
        System.out.println("Nhap ten:");
        ten = scanner.nextLine();
    }

    public void infor() {
        System.out.println("ID: " + id);
        System.out.println("Ten: " + ten);
        if (country != null) {
            System.out.println("Quoc gia: " + country.getTen());
        }
    }
}